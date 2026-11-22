# Relatório do grupo

Integrantes: Grupo de laboratório de testes estruturais (modelo de entrega do projeto).

## 1. Grafos e complexidade

### 1.1 Relação entre classes e grafo de chamadas de fechar

O fluxo principal parte de `PedidoService.fechar`, que valida as referências, aplica as verificações de bloqueio, subtotal, estoque, desconto, frete, risco e pagamento. As dependências principais são:

- `PedidoService` usa `PoliticaDesconto`, `CalculadoraFrete`, `AnaliseRisco` e `PagamentoService`.
- `Pedido` centraliza subtotal, peso e avaliação de estoque e fragilidade.
- `ItemPedido` representa cada linha de pedido e valida seus limites.
- `Cliente` guarda VIP, bloqueio e histórico.
- `PagamentoService` recebe um `ProcessadorPagamento` funcional para simular a API externa.

Fluxo de fechamento (resumo):

```
PedidoService.fechar
  -> Objects.requireNonNull(pedido, cliente)
  -> cliente.bloqueado ? BLOQUEADO
  -> subtotal == 0 ? IllegalArgumentException
  -> pedido.estoqueSuficiente ? SEM_ESTOQUE
  -> PoliticaDesconto.calcular
  -> CalculadoraFrete.calcular
  -> AnaliseRisco.avaliar
  -> risco != APROVADO ? RETORNO COM VALORES
  -> PagamentoService.pagar
  -> PAGO ou PAGAMENTO_RECUSADO
```

### 1.2 Modelo de CFG e curto-circuito

Para os métodos com decisões condicionais, o modelo adotado considera cada condição como nó de decisão e cada retorno imediato como saída própria. Curto-circuito `&&`/`||` é tratado como decisão com ramificação, mas apenas o lado necessário é avaliado quando o resultado já é fixado. Exceções não representam branches do JaCoCo, mas são consideradas blocos de tratamento em análise estrutural.

### 1.3 McCabe por método relevante

| Método | Nós (N) | Arestas (E) | V(G) = E - N + 2 | Comentário |
| --- | ---: | ---: | ---: | --- |
| `PedidoService.fechar` | 11 | 15 | 6 | validações, retorno antecipado, risco e pagamento |
| `PoliticaDesconto.calcular` | 10 | 16 | 8 | VIP, cupom, bônus, teto e default |
| `CalculadoraFrete.calcular` | 11 | 18 | 9 | UF, peso extra, gratuidade, VIP, expresso e fragilidade |
| `AnaliseRisco.avaliar` | 7 | 10 | 5 | bloqueio, histórico e limite |
| `PagamentoService.pagar` | 8 | 11 | 5 | repetição com do/while e try/catch |

### 1.4 Base de caminhos independentes

- `PoliticaDesconto.calcular`: caminhos principais são VIP, cliente comum com subtotal alto, cupom `BEMVINDO`, cupom `EXTRA10`, cupom nulo e cupom desconhecido.
- `CalculadoraFrete.calcular`: base padrão, peso extra, frete zerado por subtotal alto, VIP, expresso, item frágil e combinação de todos.
- `AnaliseRisco.avaliar`: cliente bloqueado, sem histórico e valor alto, sem histórico com entrega expressa, cliente com histórico e VIP, cliente com histórico e sem VIP com valor alto.
- `PedidoService.fechar`: bloqueado, subtotal zero, sem estoque, risco pendente e aprovação com pagamento.

Alguns caminhos são inviáveis em colaboração por retorno antecipado; por exemplo, `pedido.estoqueSuficiente` impede qualquer avaliação de cupom/desconto quando falta estoque, e `cliente.bloqueado` impede avaliação do pedido antes mesmo de consultar subtotal.

## 2. Matriz de testes

| ID / método JUnit | Unidade | Entrada e estado do stub | Resultado esperado | Caminho / aresta | Critério atendido |
| --- | --- | --- | --- | --- | --- |
| `ClienteTest.deveAceitarClienteValido` | `Cliente` | `new Cliente(false,false,3)` | sem exceção | construtor válido | validação positiva |
| `ClienteTest.deveRejeitarHistoricoNegativo` | `Cliente` | `comprasAnteriores = -1` | `IllegalArgumentException` | validação de domínio | limite inválido |
| `ItemPedidoTest.deveCalcularTotalDoItem` | `ItemPedido` | preço, quantidade, estoque e peso válidos | subtotal do item e disponibilidade | total e `disponivel()` | regra de negócio |
| `ItemPedidoTest.deveIndicarItemIndisponivelQuandoQuantidadeExcedeEstoque` | `ItemPedido` | quantidade > estoque | `false` em `disponivel()` | retorno booliano | condição inversa |
| `ItemPedidoTest.deveRejeitarDadosInvalidos` | `ItemPedido` | SKU vazio, preço zero, quantidade > 100, estoque negativo, peso zero | exceção | validação do construtor | limites inválidos |
| `PedidoTest.deveSomarSubtotalEConsiderarItensAtivos` | `Pedido` | item ativo + item inativo | subtotal correto, peso e fragilidade | loop com `continue` | itens inativos |
| `PedidoTest.deveDetectarItemFragilEEstoqueInsuficiente` | `Pedido` | item frágil com estoque 0 | `temFragil() == true` e `estoqueSuficiente() == false` | detecção de fragilidade | regra de pedido |
| `PedidoTest.deveRejeitarUfInvalida` | `Pedido` | UF inválida | exceção | validação de UF | domínio de entrada |
| `PoliticaDescontoTest.deveAplicarDescontoVip` | `PoliticaDesconto` | cliente VIP com subtotal 100_000 | desconto 10_000 | ramo VIP |
| `PoliticaDescontoTest.deveAplicarDescontoClienteComumAposLimite` | `PoliticaDesconto` | cliente comum, subtotal 50_000 | desconto 2_500 | 5% para cliente comum |
| `PoliticaDescontoTest.deveAplicarCuponsConhecidosERespeitarLimite` | `PoliticaDesconto` | `BEMVINDO` e `EXTRA10` | 12_000 e 30_000 | cases e teto |
| `PoliticaDescontoTest.deveRejeitarCupomDesconhecido` | `PoliticaDesconto` | cupom `XYZ` | `IllegalArgumentException` | default do switch |
| `CalculadoraFreteTest.deveCalcularFreteBasePorUf` | `CalculadoraFrete` | PR e SP | 1_200 e 2_000 | base por UF |
| `CalculadoraFreteTest.deveAcrescentarPesoExtraQuandoUltrapassaDoisQuilogramas` | `CalculadoraFrete` | 3.500 g | acréscimo por fração | loop `while` |
| `CalculadoraFreteTest.deveAplicarAdicionaisDeExpressoEFragil` | `CalculadoraFrete` | expresso + item frágil | frete com adicionais | ramos de expresso e fragilidade |
| `CalculadoraFreteTest.deveAplicarMeiaTarifaParaVip` | `CalculadoraFrete` | cliente VIP e RJ | frete reduzido pela metade | ramo VIP |
| `AnaliseRiscoTest.deveRecusarClienteBloqueado` | `AnaliseRisco` | cliente bloqueado | `RECUSADO` | retorno imediato |
| `AnaliseRiscoTest.deveRevisarClienteNovoComPedidoGrandeOuExpresso` | `AnaliseRisco` | sem histórico, total alto ou expresso | `REVISAO` | `if ... || ...` |
| `AnaliseRiscoTest.deveAprovarClienteComComprasAnterioresEValorBaixo` | `AnaliseRisco` | histórico > 0 e total baixo | `APROVADO` | ramo final |
| `AnaliseRiscoTest.deveRevisarClienteComComprasAnterioresQuandoUltrapassaLimite` | `AnaliseRisco` | histórico > 0, total > 500_000 e não VIP | `REVISAO` | ramo de histórico |
| `PagamentoServiceTest.deveAutorizarPagamentoQuandoProcessadorAprova` | `PagamentoService` | stub que aceita | `true` e uma única chamada | sucesso sem retry |
| `PagamentoServiceTest.deveTentarNovamenteQuandoPagamentoEstiverIndisponivel` | `PagamentoService` | primeira chamada lança `IllegalStateException` | retry e sucesso | `do/while` + catch |
| `PagamentoServiceTest.deveRetornarFalseQuandoExcederTentativas` | `PagamentoService` | todas as chamadas falham | `false` e 3 tentativas | limite de retry |
| `PagamentoServiceTest.devePropagarOutrasExcecoes` | `PagamentoService` | `RuntimeException` | propagação | tratamento seletivo |
| `PagamentoServiceTest.deveRejeitarTotalOuTentativasInvalidas` | `PagamentoService` | total <= 0 ou limite fora de 1..3 | exceção | validação de domínio |
| `PedidoServiceTest.deveFecharPedidoDeClienteComumComFreteDoParanaEPagamentoAprovado` | `PedidoService` | cliente comum, item disponível, frete normal | `PAGO` com cobrança única | caminho feliz |
| `PedidoServiceTest.deveRetornarBloqueadoSemCobrar` | `PedidoService` | cliente bloqueado | `BLOQUEADO` com zeros | retorno antecipado |
| `PedidoServiceTest.deveRejeitarPedidoSemItensAtivos` | `PedidoService` | subtotal 0 | `IllegalArgumentException` | subtotal inválido |
| `PedidoServiceTest.deveRetornarRevistaQuandoRiscoPendente` | `PedidoService` | cliente sem histórico e expresso | `REVISAO` sem cobrança | risco antes do pagamento |

## 3. Evolução da cobertura

| Etapa | Testes executados | Linhas | Branches | Métodos | Classes | Lacunas e justificativas |
| --- | ---: | ---: | ---: | ---: | ---: | --- |
| Inicial (antes do relatório) | 29 | 99,1% | 81,9% | 100% | 100% | Cobertura alta do código principal. Ainda há combinações de ramos não exaustivas em `PoliticaDesconto` e `CalculadoraFrete`, mas as condições básicas e críticas já foram testadas. |

Métricas extraídas do JaCoCo após `mvn clean test`:

- Linhas: 107 cobertas / 108 totais = 99,1%
- Branches: 95 cobertos / 116 totais = 81,9%
- Métodos: 21/21 = 100%
- Classes: 9/9 = 100%
- Instruções: 606/637 = 95,1%

## 4. Análise crítica

- Mesmo com boa cobertura de ramos, não basta cobrir cada ramo individualmente. Por exemplo, em `CalculadoraFrete`, a condição de expresso e a condição de fragilidade podem ser cobertas separadamente, mas a combinação de ambos com `cliente.vip()` e frete gratuito por valor líquido alto ainda exige um cenário específico para validar a interação real.
- Um caso de exceção não contado como branch pelo JaCoCo é `IllegalStateException` dentro de `PagamentoService.pagar`. O JaCoCo mede fluxo de execução, não a semântica de retry; por isso esse caso precisa ser verificado com assertivas sobre número de chamadas e comportamento.
- O caminho de `PedidoService.fechar` sem estoque é inviável para avaliação de cupom porque o contrato exige retorno antecipado antes do desconto; esse cenário é testável em colaboração, mas não “mistura” com o cálculo de desconto.
- O teste de mutação foi feito de forma proposital: a regra de cliente comum foi alterada de `subtotal >= 50_000` para `subtotal >= 60_000` em `PoliticaDesconto`. O teste `deveAplicarDescontoClienteComumAposLimite` falhou, confirmando que a suíte detecta regressões de regra. A alteração foi desfeita imediatamente e a suíte foi reexecutada com sucesso.

## 5. Observação final

O relatório e os testes seguem o que foi pedido no README: foco em práticas de teste estrutural, múltiplos caminhos, análise do fluxo e validação com JaCoCo. A base está correta e a suíte foi executada com sucesso em `mvn clean test`.
