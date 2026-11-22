# Casos de Teste de Usabilidade — Fluxo de Compra no Mercado Livre

## Descrição

Este documento define, para cada tarefa do [plano de teste](plano-de-teste-usabilidade.md), o ponto de partida, o caminho esperado, o marco de término e as regras de sucesso (S) e falha (N). O objetivo é que avaliadores diferentes classifiquem a mesma situação da mesma forma.

O caminho esperado descreve o percurso mais direto e serve apenas de referência para o avaliador. O participante pode seguir qualquer caminho que alcance o marco de término. Os rótulos citados foram registrados na inspeção de 22/11/2026 ([análise heurística](analise-heuristica.md)); os que não apareceram nas capturas estão marcados como "a confirmar no piloto".

## Pré-condições gerais

Ambiente preparado conforme o checklist da seção 1 do [roteiro do avaliador](roteiro-do-avaliador.md). Em resumo:

- Google Chrome com janela maximizada, zoom de 100% e extensões desativadas.
- Janela anônima com a conta de teste da equipe autenticada.
- Conta com endereço de entrega fixo, sem cartões salvos e, se possível, sem limite do Mercado Parcelado.
- Carrinho vazio e histórico de navegação da conta limpo.
- Apenas uma guia em branco aberta.

## Regras do cronômetro

- A volta de cada tarefa é marcada quando o participante alcança o marco de término.
- Se a tarefa falhar ou for abandonada, a volta é marcada quando o participante passa para a tarefa seguinte.
- Se o participante pular uma tarefa sem interagir com ela (por exemplo, não tocar na ordenação da T3b), a tarefa recebe tempo 0 e o tempo gasto entra na tarefa seguinte.

## Visão geral

| ID | Tarefa | Marco de término (volta do cronômetro) | Conferência pela URL |
| --- | --- | --- | --- |
| T1 | Acessar o site | Página inicial exibida | `mercadolivre.com.br` |
| T2 | Pesquisar "fone de ouvido Bluetooth" | Página de resultados exibida | `lista.mercadolivre.com.br/…` |
| T3a | Filtrar por entrega Full | Interruptor "FULL com frete grátis" ativado | Contém `_Frete_Full` |
| T3b | Ordenar pelos melhores avaliados | Último contato com os controles de ordenação ou filtro antes de escolher um produto | — |
| T4 | Acessar os detalhes de um produto | Página do produto exibida | Contém o código do anúncio (`MLB…`) |
| T5 | Adicionar ao carrinho | Item no carrinho: confirmação exibida ou carrinho aberto com o item | Carrinho aberto: contém `/cart/` |
| T6 | Simular o início da compra | Tela "Finalize sua compra" exibida | Contém `/checkout/` |
| T7 | Retornar à tela inicial | Página inicial exibida (fim do cronômetro) | `mercadolivre.com.br` |

Cada linha da tabela corresponde a uma linha da [planilha de observação](planilha-de-observacao.md). A URL serve para desempatar dúvidas do avaliador e para conferir gravações de tela.

---

### T1 — Acessar o site

**Descrição:** verificar se o participante chega à página inicial do Mercado Livre a partir de uma guia em branco.

**Ponto de partida:** guia em branco.

**Caminho esperado:**

1. Digitar `mercadolivre.com.br` na barra de endereços.
2. Pressionar Enter.

**Resultado esperado:** página inicial do Mercado Livre exibida, com logotipo e campo de busca visíveis.

- **S:** chegou à página inicial sem ajuda. Pesquisar "Mercado Livre" no Google e clicar no resultado oficial também conta como sucesso (anotar o caminho).
- **N:** precisou de ajuda, entrou em outro site ou desistiu.

**O que observar:** erro de digitação na URL (E4) e clique em anúncio no buscador (E1).

---

### T2 — Pesquisar "fone de ouvido Bluetooth"

**Descrição:** verificar se o participante usa a busca para chegar à lista de produtos.

**Ponto de partida:** página inicial.

**Caminho esperado:**

1. Clicar no campo de busca.
2. Digitar "fone de ouvido Bluetooth".
3. Pressionar Enter ou clicar no ícone de lupa.

**Resultado esperado:** página de resultados exibida, com o título da busca e a quantidade de resultados. Na inspeção, a busca aplicou automaticamente o filtro "Com Bluetooth"; isso não é ação do participante.

- **S:** chegou à lista de resultados do termo pedido (ou de uma sugestão equivalente do autocompletar) sem ajuda.
- **N:** precisou de ajuda, buscou outro produto ou navegou por categorias sem chegar a uma lista de fones Bluetooth.

**O que observar:** escolha de sugestão do autocompletar diferente do termo (anotar), clique em produto dos módulos personalizados da página inicial em vez de buscar (E1) e erro de digitação que exige refazer a busca (E4).

---

### T3a — Filtrar apenas produtos com entrega Full

**Descrição:** verificar se o participante encontra e aplica o filtro de entrega Full.

**Ponto de partida:** página de resultados.

**Caminho esperado:**

1. Localizar, na barra lateral esquerda, o interruptor "FULL com frete grátis — Em carrinhos a partir de R$ 19".
2. Ativar o interruptor.

**Resultado esperado:** interruptor em azul e lista recarregada; a URL passa a conter `_Frete_Full`. Na inspeção, os demais interruptores sumiram (exceto "Frete grátis"), nenhum chip de filtro foi adicionado e a contagem de resultados mudou pouco.

- **S:** filtro Full ativo sem ajuda.
- **N:** precisou de ajuda, ativou "Frete grátis" acreditando ser o Full e seguiu adiante, ou desistiu.

**O que observar:** tempo para localizar o filtro, confusão entre "FULL com frete grátis" e "Frete grátis" (E3), clique no link "Ver mais produtos do Full" do módulo promocional, que sai da busca (E1), e perguntas sobre o significado de "Full" (anotar a fala).

---

### T3b — Ordenar pelos melhores avaliados

**Descrição:** verificar se o participante consegue priorizar os produtos mais bem avaliados.

**Ponto de partida:** lista de resultados com o filtro Full ativo.

**Caminho esperado:** o controle "Ordenar por" (canto superior direito da lista, padrão "Mais relevantes") **não oferece opção por avaliação**, conforme confirmado na inspeção (decisão D2 do plano). O caminho possível é comparar as notas exibidas nos cards ("★ nota | +N vendidos") e escolher um produto bem avaliado.

**Resultado esperado:** o participante prioriza um produto bem avaliado. O marco de término é o último contato com os controles de ordenação ou filtro, antes de começar a escolher um produto.

- **S:** o produto escolhido na T4 tem nota ≥ 4,5, sem ajuda.
- **N:** precisou de ajuda, escolheu um produto com nota abaixo de 4,5 ou desistiu.

**O que observar:** abrir o "Ordenar por" procurando avaliação **não é erro** do participante, pois a tarefa induz essa busca; anotar se procurou e por quanto tempo. Aplicar outra ordenação acreditando que seja por avaliação é E3. Registrar a estratégia usada (comparar estrelas na lista, abrir vários produtos, confiar em "Mais relevantes").

**Atenção na análise:** na inspeção, os quatro primeiros produtos da lista filtrada tinham notas entre 4,6 e 4,9. O limiar de 4,5 tende a ser atingido mesmo sem comparação, por isso a análise da T3b deve considerar também o tempo, os erros E3 e a estratégia observada.

---

### T4 — Escolher um produto e acessar os detalhes

**Descrição:** verificar se o participante seleciona um produto da lista filtrada e chega à página de detalhes.

**Ponto de partida:** lista de resultados com o filtro Full ativo.

**Caminho esperado:**

1. Clicar no título ou na imagem de um produto da lista.

**Resultado esperado:** página do produto exibida, com nota, número de avaliações e o link "Voltar à lista".

- **S:** abriu a página de um produto sem ajuda.
- **N:** precisou de ajuda ou não chegou a nenhuma página de produto.

**O que observar:** registrar na planilha o produto escolhido (nome, nota, número de avaliações, selo Full e se veio da lista filtrada). Abrir um produto de fora da lista filtrada (anúncio ou módulo promocional) é E1. Se um produto sem o selo Full aparecer na própria lista filtrada, a escolha não é erro do participante; registrar como evidência da hipótese A05. Voltar à lista e perder os filtros é E2. Se o participante comparar produtos indo e voltando, o tempo continua contando na T4 até a página do produto escolhido.

---

### T5 — Adicionar o item ao carrinho

**Descrição:** verificar se o participante identifica e usa a ação de adicionar ao carrinho.

**Ponto de partida:** página do produto.

**Caminho esperado:**

1. Conferir a variação (cor ou modelo). Na inspeção, a cor já vinha selecionada.
2. Clicar em "Adicionar ao carrinho", o botão azul-claro logo abaixo de "Comprar agora", na coluna da direita.

**Resultado esperado:** item no carrinho, indicado por uma confirmação de produto adicionado ou pelo carrinho aberto com o item, e contador do ícone do carrinho atualizado. A forma exata da confirmação logo após o clique deve ser registrada no piloto.

- **S:** item adicionado ao carrinho sem ajuda.
- **N:** precisou de ajuda, não adicionou o item ou foi direto para o checkout por "Comprar agora" sem passar pelo carrinho.

**O que observar:** clique em "Comprar agora", que é o botão principal (E1; se depois voltar e adicionar ao carrinho, a tarefa conta como S com erro), e distração com ofertas exibidas após adicionar.

---

### T6 — Simular o início da compra (sem concluir o pagamento)

**Descrição:** verificar se o participante inicia o checkout a partir do carrinho e reconhece o ponto de parada.

**Ponto de partida:** confirmação de item adicionado ao carrinho, ou a tela seguinte, se a T5 não foi concluída.

**Caminho esperado:**

1. Abrir o carrinho (ícone no canto superior direito do cabeçalho; a URL contém `/cart/`). O item aparece no grupo "Produtos FULL", já marcado.
2. Clicar em "Continuar (1)", no quadro "Resumo da compra". O número indica quantos itens marcados seguem para a compra.
3. Se aparecer a tela "Adicione um seguro", escolher "Agora não" (a inspeção registrou essa tela pelo caminho "Comprar agora"; pelo carrinho, confirmar no piloto).
4. Parar quando a tela "Finalize sua compra" aparecer.

**Resultado esperado:** tela "Finalize sua compra" exibida, com forma de entrega, meios de pagamento, resumo da compra e o botão "Pagar e finalizar". A URL contém `/checkout/`.

- **S:** chegou à tela "Finalize sua compra" sem ajuda e parou sem escolher forma de pagamento. Chegar ao checkout por "Comprar agora" também conta como sucesso na T6 (anotar o caminho); se o item não foi adicionado ao carrinho, a falha é registrada apenas na T5.
- **N:** precisou de ajuda, não encontrou como iniciar a compra ou tentou pagar.

**O que observar:**

- No carrinho: desmarcar o item ou alterar a quantidade sem querer, e clicar em "Ver produtos" (oferta de frete grátis Full) ou em "Recomendações para você", que saem do fluxo (E1). Se o participante excluir o item por engano, o aviso "Pronto! Você excluiu o produto." oferece "DESFAZER"; registrar se ele usa essa opção.
- Na tela de seguro, o plano de 2 anos já vem selecionado e "Adicionar" é o botão principal. Clicar em "Adicionar" sem querer o seguro é E1. Registrar a escolha na planilha.
- Na inspeção, a forma de entrega veio pré-selecionada como "Retirada", e não "Frete". Anotar se o participante altera a forma de entrega.
- **Intervenção imediata** se o participante escolher um meio de pagamento ou levar o cursor ao botão "Pagar e finalizar". Mercado Parcelado e Pix aparecem como opções, e uma compra pode ser concluída mesmo sem cartão salvo.

---

### T7 — Retornar à tela inicial

**Descrição:** verificar se o participante consegue sair do checkout e voltar à página inicial.

**Ponto de partida:** tela do checkout.

**Caminho esperado:**

1. Clicar no logotipo do Mercado Livre, no canto superior esquerdo (destino a confirmar no piloto), ou usar outro meio de navegação.

**Resultado esperado:** página inicial exibida. **O cronômetro para aqui.**

- **S:** chegou à página inicial sem ajuda, por qualquer meio (logotipo, botão voltar ou digitando a URL). Anotar o meio usado e quantas vezes usou o botão voltar.
- **N:** precisou de ajuda ou desistiu.

**O que observar:** o cabeçalho do checkout mostra apenas o logotipo, o menu do usuário e "Contato", sem busca nem carrinho. Observar o uso repetido do botão voltar e a passagem por páginas não relacionadas (E2).

---

## Pós-condições

- Nenhuma compra foi concluída (conferir em "Compras", no cabeçalho do site).
- O carrinho da conta de teste contém o item adicionado e deve ser esvaziado na reinicialização do ambiente.
- A página inicial passa a exibir o fone visto em "Visto recentemente"; o histórico deve ser limpo antes da próxima sessão.
- A planilha de observação tem tempos, sucesso, ajuda e erros das tarefas T1 a T7, além do produto escolhido.
