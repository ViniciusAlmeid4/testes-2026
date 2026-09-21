# Calculos e lógica de resolução do ex 2

V(G) = 12 - 10 + 2 = 4

V(G) = 3 + 1 = 4

## Caminhos

Início -> A -> B -> C -> Fim

Início -> A -> B -> D -> E -> H -> B -> C -> Fim

Início -> A -> B -> D -> F -> H -> B -> C -> Fim

Início -> A -> B -> D -> F -> G -> H -> B -> C -> Fim

## Vetores de entrada e valores retornados

| Objetivo | Vetor `temperaturas` | Caminho no CFG | Retorno |
|---|---|---|---|
| Saída do laço sem iteração | `{}` | Início → A → B → C → Fim | 0 |
| Temperatura negativa | `{-5.0}` | Início → A → B → D → E → H → B → C → Fim | 2 |
| Temperatura > 35 | `{40.0}` | Início → A → B → D → F → G → H → B → C → Fim | 1 |
| Temperatura entre 0 e 35 | `{20.0}` | Início → A → B → D → F → H → B → C → Fim | 0 |
| Combinado (todos os ramos) | `{-5.0, 40.0, 20.0}` | Início → A → B → (D → E → H → B) → (D → F → G → H → B) → (D → F → H → B) → C → Fim | 3 |

## Por que a aresta de retorno (H → B) precisa aparecer no CFG

| Motivo | Explicação |
|---|---|
| Representa todos os fluxos possíveis | Sem H → B o grafo não tem ciclo e descreveria um método que examina no máximo uma temperatura, o que não corresponde ao código. |
| Reavaliação da condição | É a aresta de retorno que permite testar `i < temperaturas.length` de novo com `i` incrementado, até a condição ser falsa e o fluxo seguir para C. |
| Afeta a métrica | Sem ela, E = 11 e V(G) = 11 − 10 + 2 = 3, divergindo da contagem por decisões (3 + 1 = 4). Com ela, E = 12 e V(G) = 4 pelas duas fórmulas. |
| Orienta os testes | Só com o ciclo faz sentido testar zero, uma e várias iterações e verificar o acúmulo de `alertas` entre elas. |