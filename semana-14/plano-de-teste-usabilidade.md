# Plano de Teste de Usabilidade — Mercado Livre (Teste de Usuário Final)

Este plano detalha o teste descrito em [enunciado-teste-usuario-final.pdf](enunciado-teste-usuario-final.pdf). As seções 1 a 9 seguem a numeração do enunciado. As seções 4 e 5 não existem no original (a numeração passa de 3 para 6) e foram completadas pela equipe. As seções 10 em diante registram decisões, riscos e responsabilidades.

## 1. Objetivo do Teste

Avaliar a facilidade de uso, a eficiência e a clareza da interface do site Mercado Livre (versão desktop) durante a **busca**, a **comparação** e a **simulação de compra** de um produto, observando o comportamento de usuários finais.

O teste mede as três dimensões de usabilidade da ISO 9241-11:

| Dimensão | Pergunta | Métrica | Instrumento |
| --- | --- | --- | --- |
| Eficácia | Os usuários conseguem concluir as tarefas sem ajuda? | Taxa de sucesso | Planilha de observação |
| Eficiência | Quanto esforço o fluxo exige? | Tempo de execução e erros | Cronômetro e planilha |
| Satisfação | Como os usuários percebem a experiência? | Pontuação SUS | Questionário SUS |

## 2. Cenário de Uso

> Você está procurando **um fone de ouvido sem fio** para uso diário e quer comprar pelo Mercado Livre. Seu objetivo é **encontrar um modelo com boa avaliação**, comparar opções e **simular a compra até o carrinho** (sem finalizar o pagamento).

**Contexto de uso:** computador desktop do laboratório, navegador Google Chrome, conta de teste da equipe já autenticada, rede da instituição.

## 3. Tarefas a Serem Executadas

| ID | Tarefa (enunciado) | Marco de término |
| --- | --- | --- |
| T1 | Acessar o site https://www.mercadolivre.com.br | Página inicial do Mercado Livre exibida |
| T2 | Pesquisar "fone de ouvido Bluetooth" | Página de resultados da busca exibida |
| T3a | Filtrar apenas produtos com entrega Full | Interruptor "FULL com frete grátis" ativado na lista de resultados |
| T3b | Ordenar pelos melhores avaliados | Último contato com os controles de ordenação ou filtro antes de escolher um produto (o site não tem ordenação por avaliação; ver D2) |
| T4 | Escolher um produto e acessar os detalhes | Página do produto exibida |
| T5 | Adicionar o item ao carrinho | Confirmação exibida e contador do carrinho atualizado |
| T6 | Simular o início da compra (sem concluir o pagamento) | Tela "Finalize sua compra" exibida, sem clicar em "Pagar e finalizar" |
| T7 | Retornar à tela inicial | Página inicial exibida (o cronômetro para aqui) |

A tarefa 3 do enunciado foi dividida em T3a e T3b para identificar qual das duas ações causa dificuldade. Os critérios de sucesso e falha de cada tarefa estão em [casos-de-teste-usabilidade.md](casos-de-teste-usabilidade.md).

## 4. Perfil dos Participantes (seção completada pela equipe)

- **Público:** alunos da turma, maiores de 18 anos, no papel de compradores.
- **Quantidade:** no mínimo 5 participantes. Cinco usuários costumam revelar a maior parte dos problemas de um fluxo (Nielsen, 2000), mas, para o critério de 90% ter significado, o ideal é de 8 a 10 participantes (ver 7.1).
- **Exclusão:** integrantes da equipe que prepararam o teste e pessoas que assistiram a outras sessões.
- **Dados de perfil (questionário pré-teste):** faixa etária, frequência de compras pela internet, experiência com o Mercado Livre e se conhece o serviço Full. Nenhum dado pessoal identificável é registrado.

## 5. Procedimento (seção completada pela equipe)

### 5.1 Preparação

Antes de cada sessão, o avaliador prepara o ambiente conforme o checklist do [roteiro-do-avaliador.md](roteiro-do-avaliador.md): conta de teste autenticada, carrinho vazio, histórico limpo, mesmo navegador, janela anônima, zoom de 100% e extensões desativadas.

### 5.2 Teste piloto

A inspeção feita pela equipe em 22/11/2026 ([análise heurística](analise-heuristica.md)) já registrou o rótulo do filtro Full, a ausência de ordenação por avaliação, os botões da página do produto, o carrinho, a tela de seguro e a tela única do checkout. Uma sessão piloto, não contabilizada nos resultados, é feita antes das sessões reais para confirmar:

1. O retorno visual logo após "Adicionar ao carrinho" e o que aparece depois de "Continuar (1)" no carrinho (tela de seguro ou checkout direto).
2. Se o logotipo do checkout leva à página inicial.
3. Se a conta de teste tem limite do Mercado Parcelado disponível (R1).
4. O tempo do caminho ideal executado por um usuário experiente, com voltas por tarefa como nas sessões (tempo de referência).

O resultado do piloto é registrado na seção 2 do [relatorio-de-resultados.md](relatorio-de-resultados.md).

### 5.3 Etapas da sessão

| Etapa | Duração aproximada |
| --- | --- |
| Boas-vindas e termo de consentimento | 2 min |
| Questionário pré-teste (perfil) | 1 min |
| Leitura do cenário e entrega do cartão de tarefas | 1 min |
| Execução cronometrada de T1 a T7 | até 6 min |
| Questionário SUS | 2 min |
| Entrevista pós-teste | 3 min |
| Reinicialização do ambiente | 2 min |

Cada sessão leva de 15 a 20 minutos.

### 5.4 Política de ajuda

O avaliador não orienta o participante durante as tarefas. Ele só intervém quando há 2 minutos sem progresso na mesma tarefa, pedido explícito de ajuda, intenção de desistir ou risco de concluir uma compra real. A tarefa em que houve ajuda é registrada como **N** (sem sucesso) e o participante segue para a próxima.

### 5.5 Protocolo de verbalização

Não se usa o pensar em voz alta durante a execução, pois ele aumenta o tempo das tarefas e comprometeria o critério de 4 minutos. Comentários espontâneos são anotados, e as percepções são coletadas na entrevista pós-teste.

## 6. Dados Coletados

| Métrica | Definição operacional | Como medir |
| --- | --- | --- |
| Tempo de execução | Do primeiro contato com o navegador na T1 até a exibição da página inicial na T7. Leitura de instruções, SUS e entrevista ficam fora. | Cronômetro com voltas no marco de término de cada tarefa |
| Taxa de sucesso | Por tarefa: participantes com S ÷ n. Do fluxo: participantes com S em todas as tarefas ÷ n. | Coluna "Sucesso (S/N)" da planilha |
| Erros cometidos | Ações que afastam o participante do objetivo, classificadas em E1 a E4 | Coluna "Erros" da planilha |
| Satisfação | Pontuação SUS de 0 a 100 por participante e média do grupo | [questionario-sus.md](questionario-sus.md) |
| Observações | Comentários espontâneos, estratégias usadas e respostas da entrevista | "Observações", "Registros complementares" e "Entrevista pós-teste" da planilha |

**Classificação dos erros:**

| Código | Tipo | Exemplos |
| --- | --- | --- |
| E1 | Clique incorreto | Clicar em anúncio, em produto não desejado ou em "Comprar agora" em vez de "Adicionar ao carrinho" |
| E2 | Perda do caminho | Sair do fluxo para uma página não relacionada ou voltar várias páginas para se reorientar |
| E3 | Confusão nos filtros | Aplicar filtro ou ordenação errada, ou remover um filtro sem perceber |
| E4 | Outro | Erro de digitação na URL ou na busca, ação acidental (descrever) |

**Fórmulas:**

- Taxa de sucesso da tarefa = (participantes com S na tarefa ÷ n) × 100
- Taxa de conclusão sem ajuda = (participantes com S em todas as tarefas ÷ n) × 100
- Tempo médio total = soma dos tempos totais ÷ número de participantes que chegaram à T7
- Tempo médio da tarefa = soma dos tempos da tarefa ÷ número de participantes que a executaram, incluindo quem recebeu ajuda, para mostrar onde o tempo é perdido
- Erros por participante = total de erros ÷ n

As regras para marcar as voltas do cronômetro, inclusive em tarefas que falham, estão em [casos-de-teste-usabilidade.md](casos-de-teste-usabilidade.md).

## 7. Critérios de Sucesso

| ID | Critério | Origem |
| --- | --- | --- |
| C1 | Pelo menos 90% dos participantes adicionam o produto ao carrinho (T5 = S, sem ajuda) | Enunciado |
| C2 | Tempo médio para concluir o teste de até 4 minutos (240 s) | Enunciado |
| C3 | Pontuação SUS média de pelo menos 68 (média de referência do SUS) | Proposto pela equipe |

O tempo médio (C2) considera todos os participantes que chegaram à T7, com ou sem ajuda. Quem abandonou o teste fica fora da média e é relatado à parte. A mediana também é apresentada, por ser menos sensível a valores extremos.

### 7.1 Interpretação do critério de 90% com amostras pequenas

O número mínimo de sucessos é o arredondamento para cima de 0,9 × n:

| Participantes (n) | 5 | 6 | 8 | 10 | 12 | 15 | 20 |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Sucessos necessários | 5 | 6 | 8 | 9 | 11 | 14 | 18 |

Com até 9 participantes, o C1 só é atendido se **todos** tiverem sucesso. Por isso, os resultados também são apresentados como "x de n".

## 8. Recursos e Organização da Atividade

| Papel | Descrição |
| --- | --- |
| Usuário final | Aluno que executa as tarefas como comprador |
| Avaliador | Colega que conduz a sessão, cronometra e registra tempo, erros e comentários |
| Avaliador anotador (opcional) | Segundo colega que registra erros e citações, liberando o avaliador para conduzir e cronometrar |
| Instrutor | Professor que orienta e supervisiona o teste |

**Ferramentas:**

- Navegador Google Chrome (o mesmo em todas as sessões).
- Cronômetro com função de voltas (celular).
- [Planilha de observação](planilha-de-observacao.md), em papel ou digital.
- [Questionário SUS](questionario-sus.md), no Google Forms ou impresso.
- Conta de teste da equipe no Mercado Livre, sem cartões salvos e, se possível, sem limite do Mercado Parcelado.
- Termo de consentimento e cartão de tarefas (anexos do [roteiro](roteiro-do-avaliador.md)).

## 9. Planilha de Observação

O modelo completo está em [planilha-de-observacao.md](planilha-de-observacao.md). Em relação ao exemplo do enunciado, foram feitas as seguintes alterações:

- inclusão da linha "Retornar à tela inicial" (o exemplo tem 6 linhas para 7 tarefas);
- divisão de "Aplicar filtros" em 3a (Full) e 3b (ordenação);
- inclusão da coluna "Ajuda", pois a taxa de sucesso considera apenas quem concluiu sem ajuda;
- legenda com os códigos de erro E1 a E4.

## 10. Premissas e Decisões

| ID | Ponto em aberto | Decisão da equipe |
| --- | --- | --- |
| D1 | O enunciado não define conta de acesso, mas o checkout do Mercado Livre exige uma conta | A sessão começa com uma conta de teste da equipe já autenticada. O login fica fora do tempo medido e os participantes não expõem suas contas pessoais. |
| D2 | O enunciado pede para ordenar pelos melhores avaliados, mas o site não oferece essa ordenação: na inspeção, o controle "Ordenar por" (padrão "Mais relevantes") não tinha opção por avaliação, o que coincide com a documentação da API de buscas (apenas relevância, menor preço e maior preço) | A tarefa é mantida no cartão, para observar como os participantes lidam com a ausência da opção. A T3b conta como sucesso quando o produto escolhido sem ajuda tem nota ≥ 4,5. Como os cards mostram a nota, mas não o número de avaliações, o limiar usa apenas a nota. |
| D3 | O início e o fim do tempo não estão definidos | O tempo vai do primeiro contato com o navegador na T1 até a página inicial exibida na T7. |
| D4 | O enunciado permite Chrome, Firefox ou Edge | Usa-se um único navegador (Chrome), na mesma máquina, para que os tempos sejam comparáveis. |
| D5 | O que conta como "ajuda" não está definido | Ajuda é qualquer intervenção que indique onde clicar ou confirme o caminho. Repetir o enunciado da tarefa não é ajuda. |
| D6 | O enunciado cita o SUS, mas não define meta | Adota-se o critério complementar C3 (SUS ≥ 68). |
| D7 | A disponibilidade do Full e os prazos dependem do endereço de entrega, e o cabeçalho do site exibe o nome e o endereço do titular da conta ("Enviar para …") | A conta de teste usa um endereço fixo, de preferência o da instituição, o que também evita expor o endereço residencial de um integrante. |
| D8 | O ponto de parada do checkout não está definido | O checkout do Mercado Livre reúne entrega, pagamento e o botão "Pagar e finalizar" em uma única tela. O participante para quando a tela "Finalize sua compra" aparece, sem escolher forma de pagamento. |

## 11. Riscos e Mitigações

| ID | Risco | Mitigação |
| --- | --- | --- |
| R1 | Compra concluída por engano. Uma conta sem cartão salvo não basta: o checkout oferece Mercado Parcelado, um crédito que dispensa cartão, e o botão "Pagar e finalizar" fica na mesma tela do pagamento. | Conta sem cartões salvos e, se possível, sem limite do Mercado Parcelado. Parada explícita no cartão de tarefas e avaliador ao lado do participante durante a T6, pronto para intervir. |
| R2 | Contaminação entre sessões: a página inicial exibe "Visto recentemente", "Sua busca" e "Inspirado no último visto", e a lista de resultados muda quando o carrinho tem itens | Checklist de reinicialização após cada sessão, conferindo que a página inicial não exibe fones |
| R3 | O site muda entre o piloto e as sessões (promoções de Black Friday, novos módulos) | Realizar todas as sessões no mesmo dia e registrar diferenças no relatório |
| R4 | Verificação de segurança no login | O avaliador faz o login antes da sessão, fora do tempo medido |
| R5 | Rede lenta inflando os tempos | Mesma rede em todas as sessões e anotação de carregamentos acima de 5 s |
| R6 | Participantes conhecem as tarefas antecipadamente | Participantes aguardam fora da sala e são orientados a não comentar as tarefas |
| R7 | Amostra pequena e homogênea (colegas de turma) | Relatar como limitação e apresentar resultados como "x de n" |

## 12. Ética e Privacidade

- Participação voluntária, com termo de consentimento assinado e direito de desistir a qualquer momento.
- Participantes identificados apenas por código (P1, P2, …), em conformidade com a LGPD (Lei nº 13.709/2018).
- Uso exclusivo da conta de teste da equipe; nenhuma credencial ou dado de pagamento do participante é usado.
- Gravação de tela apenas com consentimento específico; nenhuma gravação de rosto ou voz.
- Capturas de tela anexadas ao relatório devem ocultar nome e endereço do titular da conta, agência de retirada e abas do navegador.
- Os dados coletados são usados somente nesta atividade.

## 13. Responsabilidades e Comunicação

**Equipe:** preparar o ambiente e a conta de teste, executar o piloto e as sessões, consolidar os dados e redigir o relatório.

**Instrutor:** orientar a atividade e supervisionar as sessões.

Os resultados são consolidados no [relatorio-de-resultados.md](relatorio-de-resultados.md), que compara os dados obtidos com os critérios C1 a C3 e com as hipóteses da [análise heurística](analise-heuristica.md).

## 14. Referências

- BROOKE, J. SUS: a "quick and dirty" usability scale. In: JORDAN, P. W. et al. (ed.). *Usability Evaluation in Industry*. London: Taylor & Francis, 1996.
- BRASIL. Lei nº 13.709, de 14 de agosto de 2018. Lei Geral de Proteção de Dados Pessoais (LGPD).
- ISO 9241-11:2018. *Ergonomics of human-system interaction — Part 11: Usability: Definitions and concepts*.
- MERCADO LIVRE. Envios Full. Disponível em: https://www.mercadolivre.com.br/l/envios-full. Acesso em: 22 nov. 2026.
- MERCADO LIVRE DEVELOPERS. Itens e buscas. Disponível em: https://developers.mercadolivre.com.br/pt-br/itens-e-buscas. Acesso em: 22 nov. 2026.
- NIELSEN, J. *10 Usability Heuristics for User Interface Design*. Nielsen Norman Group, 1994 (atualizado em 2020).
- NIELSEN, J. *How to Conduct a Heuristic Evaluation*. Nielsen Norman Group, 1994.
- NIELSEN, J. *Severity Ratings for Usability Problems*. Nielsen Norman Group, 1994.
- NIELSEN, J. *Why You Only Need to Test with 5 Users*. Nielsen Norman Group, 2000.
- SAURO, J. *Measuring Usability with the System Usability Scale (SUS)*. MeasuringU, 2011.
- SAURO, J.; LEWIS, J. R. *Quantifying the User Experience: Practical Statistics for User Research*. 2. ed. Cambridge: Morgan Kaufmann, 2016.
- W3C. *Web Content Accessibility Guidelines (WCAG) 2.2*. 2023.

## 15. Controle de Versões

| Versão | Data | Descrição |
| --- | --- | --- |
| 1.0 | 22/11/2026 | Versão inicial do plano |
| 1.1 | 22/11/2026 | Inclusão das evidências da inspeção do fluxo (tela de seguro, checkout em uma tela, rótulo do filtro Full); regras do cronômetro para tarefas que falham; alinhamento dos itens do piloto |
| 1.2 | 22/11/2026 | Ajustes após teste de mesa dos instrumentos: transcrição das voltas, linguagem neutra nos textos lidos ao participante, uso do tempo de referência no relatório e matriz de rastreabilidade no README |
| 1.3 | 22/11/2026 | Confirmação de que o site não oferece ordenação por avaliação (critério da T3b definido) e inclusão da tela do carrinho ("Continuar (1)") nas evidências |
