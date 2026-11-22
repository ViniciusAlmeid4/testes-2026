# Análise Heurística e Inspeção do Fluxo

## Objetivo

Antecipar problemas de usabilidade antes das sessões com usuários, com dois usos:

1. ajustar o roteiro, os critérios e os riscos do teste;
2. gerar hipóteses que as sessões vão confirmar ou refutar (seção 8 do [relatório](relatorio-de-resultados.md)).

## Método

- **Inspeção do fluxo completo** (página inicial, busca, filtro, produto, carrinho, seguro, checkout e volta à página inicial), feita pela equipe em 22/11/2026, no Google Chrome desktop, com conta autenticada, durante o período de Black Friday. O percurso foi registrado em capturas de tela. A busca usou o termo "fone ouvido bluetooth" e o checkout foi aberto por "Comprar agora"; o carrinho foi registrado em uma captura à parte, e falta ver no piloto o que aparece depois de "Continuar (1)". A equipe também conferiu que o controle "Ordenar por" não oferece opção por avaliação.
- **Avaliação heurística** com as 10 heurísticas de Nielsen e a escala de severidade de 0 a 4.
- **Limitações:** a inspeção teve poucos avaliadores (Nielsen recomenda de 3 a 5, de forma independente), o site muda com personalização e promoções, e a conta usada já tinha itens no carrinho e histórico de navegação.
- As capturas de tela não fazem parte do repositório; o que elas mostram está descrito na tabela de evidências abaixo.

### Heurísticas de Nielsen

| ID | Heurística | Em resumo |
| --- | --- | --- |
| H1 | Visibilidade do status do sistema | O usuário sabe o que está acontecendo e recebe retorno das suas ações |
| H2 | Correspondência entre o sistema e o mundo real | Termos e conceitos familiares ao usuário |
| H3 | Controle e liberdade do usuário | Saídas claras para desfazer ou voltar |
| H4 | Consistência e padrões | Mesmos termos e comportamentos em todo o site |
| H5 | Prevenção de erros | O design evita que o erro aconteça |
| H6 | Reconhecimento em vez de memorização | As informações necessárias ficam visíveis |
| H7 | Flexibilidade e eficiência de uso | Atalhos e recursos que aceleram a tarefa |
| H8 | Estética e design minimalista | Sem informação que compita com o essencial |
| H9 | Ajuda para reconhecer, diagnosticar e corrigir erros | Mensagens de erro claras e com solução |
| H10 | Ajuda e documentação | Ajuda fácil de encontrar quando necessária |

### Escala de severidade

| Nota | Significado |
| ---: | --- |
| 0 | Não é um problema de usabilidade |
| 1 | Problema cosmético: corrigir se houver tempo |
| 2 | Problema pequeno: baixa prioridade |
| 3 | Problema grande: alta prioridade |
| 4 | Catástrofe: corrigir antes de qualquer outra coisa |

## Evidências da inspeção

| Tela | O que foi observado | Implicação para o teste |
| --- | --- | --- |
| Página inicial | Campo de busca em destaque no topo. Banners de Black Friday. Módulos personalizados: "Conclua sua compra", "Compre seu carrinho", "Visto recentemente", "Sua busca" e "Inspirado no último visto". O cabeçalho mostra "Enviar para" com o nome e o endereço do titular da conta. | Limpar histórico e carrinho entre sessões (R2). Usar o endereço da instituição na conta (D7). |
| Resultados da busca | Filtro "Com Bluetooth" aplicado automaticamente. "Buscas relacionadas" acima da lista. "Ordenar por: Mais relevantes" no canto superior direito, sem opção de ordenar por avaliação. Interruptores na barra lateral: "Lojas que sigo", "Chegará hoje", "FULL com frete grátis — Em carrinhos a partir de R$ 19", "Internacional", "Envio local" e "Frete grátis". Módulo "Economize no frete de produtos FULL — Adicione mais produtos ao carrinho", com o link "Ver mais produtos do Full", exibido quando a conta já tinha itens no carrinho. | Rótulo real do filtro da T3a. Possível confusão com "Frete grátis" e com o módulo promocional. |
| Resultados com Full | Interruptor do Full em azul. A URL passa a conter `_Frete_Full`. Os outros interruptores somem, exceto "Frete grátis". Nenhum chip novo aparece ao lado de "Com Bluetooth". A contagem muda pouco (de 2.467 para 2.383 resultados). Os cards mostram "★ nota \| +N vendidos", preço, desconto, parcelamento e selo FULL. Um dos quatro primeiros cards exibia apenas "Grátis", sem o selo FULL. | A T3a pode ser verificada pela URL. Os cards não mostram o número de avaliações. |
| Página do produto | Link "Voltar à lista" e trilha de categorias. Nota com o número de avaliações (por exemplo, 4,9 com 7.576 avaliações). Cor pré-selecionada. "Estoque disponível — Armazenado e enviado pelo FULL". "Comprar agora" (botão principal, azul sólido) acima de "Adicionar ao carrinho" (secundário, azul-claro). O cabeçalho não acompanha a rolagem. Parcelamento informado como "2x sem juros no cartão" no topo e "Pague em até 4x sem juros!" no bloco de meios de pagamento. | Risco de clicar em "Comprar agora" na T5. |
| Carrinho | URL com `/cart/` e cabeçalho completo. Itens agrupados por tipo de envio e por vendedor ("Produtos FULL" e um grupo por loja), com caixas de seleção e a opção "Todos os produtos". Cada item tem seletor de quantidade e lixeira; ao excluir, aparece o aviso "Pronto! Você excluiu o produto." com "DESFAZER". O quadro "Resumo da compra" mostra produto, desconto, frete, cupom e total, com o botão "Continuar (1)", que indica quantos itens seguem para a compra. Abaixo, "Aproveite o frete grátis adicionando mais produtos FULL. Ver produtos" e "Recomendações para você". Um item esgotado de outro vendedor, deixado no carrinho, aparecia com a sugestão "Leve este similar!". | Rótulo do botão da T6 confirmado ("Continuar (1)"). Itens antigos poluem o carrinho, que precisa estar vazio no início de cada sessão (R2). |
| Seguro (após "Comprar agora") | Tela "Adicione um seguro" com o plano de 2 anos pré-selecionado e marcado como "RECOMENDADO". Botões "Agora não" (secundário) e "Adicionar" (principal). Cabeçalho simplificado. | Registrar na T6 se o participante adiciona o seguro. |
| Checkout | "Finalize sua compra" em uma única tela: forma de entrega ("Retirada" veio selecionada em vez de "Frete"), meios de pagamento (incluindo Mercado Parcelado com limite disponível e Pix), resumo e botão "Pagar e finalizar". Cabeçalho apenas com logotipo, menu do usuário e "Contato". | A parada da T6 é esta tela. Uma conta sem cartão salvo não impede a compra (R1). |
| Volta à página inicial | "Visto recentemente" passa a mostrar o fone visto e "Inspirado no último visto" exibe fones semelhantes. | O participante seguinte veria fones na página inicial (R2). |

## Problemas e hipóteses

"Observado na inspeção" significa que a característica da interface foi vista nas capturas. Se ela causa dificuldade real, só as sessões vão mostrar.

| ID | Tarefa | Problema | Heurística | Severidade estimada | Evidência | Indicador no teste |
| --- | --- | --- | --- | ---: | --- | --- |
| A01 | T2 | A busca aplica o filtro "Com Bluetooth" sem ação do usuário | H1, H3 | 1 | Observado na inspeção | Participante remove o filtro ou comenta que não o aplicou |
| A02 | T3a | O rótulo "FULL com frete grátis — Em carrinhos a partir de R$ 19" mistura o serviço Full com uma condição de frete, ao lado do interruptor "Frete grátis" | H2, H4 | 3 | Observado na inspeção | Ativa "Frete grátis" no lugar do Full (E3) ou pergunta o que é Full |
| A03 | T3a | Ao ativar o Full, outros interruptores desaparecem, nenhum chip de filtro é exibido e a contagem muda pouco | H1 | 2 | Observado na inspeção | Ativa e desativa o filtro, ou volta a procurá-lo depois de já tê-lo ativado |
| A04 | T3a | O módulo "Economize no frete de produtos FULL" pode ser confundido com o filtro | H4, H8 | 2 | A confirmar no piloto (apareceu com o carrinho preenchido) | Clica em "Ver mais produtos do Full" (E1 ou E3) |
| A05 | T3a, T4 | Card sem selo FULL na lista filtrada | H1, H4 | 2 | Observado em um card | Desconfia do filtro ou escolhe produto sem o selo |
| A06 | T3b | Não há ordenação por avaliação: o "Ordenar por" (padrão "Mais relevantes") não oferece essa opção, e o participante precisa comparar as notas card a card | H7 | 3 | Confirmado na inspeção | Abre "Ordenar por" e não encontra a opção, ou escolhe outra ordenação (E3) |
| A07 | T3b, T4 | Os cards mostram nota e quantidade vendida, mas não o número de avaliações, e não há comparação lado a lado | H6, H7 | 2 | Observado na inspeção | Abre vários produtos e volta à lista (E2) |
| A08 | T5 | "Comprar agora" é o botão principal e fica acima de "Adicionar ao carrinho" | H4, H5 | 2 | Observado na inspeção | Clica em "Comprar agora" (E1) |
| A09 | T5, T6 | O cabeçalho some ao rolar a página do produto, e o carrinho só é alcançado voltando ao topo | H6, H7 | 1 | Observado na inspeção | Procura o carrinho depois de adicionar |
| A10 | T6 | Tela de seguro com o plano de 2 anos pré-selecionado e "Adicionar" como botão principal | H5 | 3 | Observado no caminho "Comprar agora"; pelo carrinho, a confirmar depois de "Continuar (1)" | Clica em "Adicionar" sem intenção (E1) |
| A11 | T6 | Checkout em uma tela: pagamento e "Pagar e finalizar" juntos, com forma de entrega pré-selecionada que pode não ser a esperada | H5 | 2 | Observado na inspeção | Hesita antes de parar, altera a forma de entrega ou exige intervenção |
| A12 | T7 | Cabeçalho do checkout sem busca, carrinho ou menu de navegação | H3 | 2 | Observado (logotipo presente; clique a confirmar no piloto) | Usa o botão voltar várias vezes ou digita a URL (E2) |
| A13 | Geral | Parcelamento informado de formas diferentes na mesma página | H4 | 1 | Observado (fora das tarefas) | Comentário sobre as condições de pagamento |
| A14 | T6 | Ofertas no carrinho ("Ver produtos" para frete grátis Full e "Recomendações para você") competem com o botão "Continuar (1)" | H8 | 1 | Observado na inspeção | Clica em "Ver produtos" ou em uma recomendação (E1) |

**Pontos positivos observados:**

- Campo de busca em destaque, com buscas relacionadas (H6).
- Selo FULL com o mesmo ícone de raio na lista, na página do produto e no checkout (H4).
- "Voltar à lista" e trilha de categorias na página do produto (H3).
- Nota e número de avaliações visíveis na página do produto (H1).
- Resumo com preço, desconto e total no carrinho e antes de finalizar a compra (H1, H5).
- Botão "Continuar (1)" informa quantos itens seguem para a compra (H1).
- Exclusão de item no carrinho com a opção "DESFAZER" (H3).

## Checklist complementar de front-end (para o piloto)

Além dos itens do piloto listados na seção 5.2 do [plano](plano-de-teste-usabilidade.md):

- [ ] Repetir o fluxo em 1366×768 e em 1920×1080 e verificar se o filtro Full fica visível sem rolar a página.
- [ ] Medir com o seletor de cor do DevTools o contraste do texto do botão "Adicionar ao carrinho" (azul sobre azul-claro). O WCAG 2.2 exige 4,5:1 para texto normal.
- [ ] Navegar com Tab até o filtro Full e até "Adicionar ao carrinho" e verificar se o foco fica visível.
- [ ] Verificar se há indicação de carregamento ao ativar o filtro.
