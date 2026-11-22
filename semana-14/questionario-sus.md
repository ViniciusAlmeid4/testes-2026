# Questionário SUS (System Usability Scale)

O SUS (Brooke, 1996) mede a usabilidade percebida com 10 afirmações respondidas em escala de 1 a 5. É aplicado logo após a execução das tarefas, antes da entrevista.

## Para o participante

**Participante:** P___ **Data:** ___/___/______

Pensando nas tarefas que você acabou de fazer no site do Mercado Livre, marque o quanto concorda com cada afirmação. Responda com a primeira impressão. Se não souber responder, marque 3.

**1** = Discordo totalmente · **2** = Discordo · **3** = Neutro · **4** = Concordo · **5** = Concordo totalmente

| Nº | Afirmação | 1 | 2 | 3 | 4 | 5 |
| ---: | --- | :---: | :---: | :---: | :---: | :---: |
| 1 | Eu acho que gostaria de usar este site com frequência. | ( ) | ( ) | ( ) | ( ) | ( ) |
| 2 | Eu achei o site desnecessariamente complexo. | ( ) | ( ) | ( ) | ( ) | ( ) |
| 3 | Eu achei o site fácil de usar. | ( ) | ( ) | ( ) | ( ) | ( ) |
| 4 | Eu acho que precisaria da ajuda de uma pessoa com conhecimentos técnicos para usar este site. | ( ) | ( ) | ( ) | ( ) | ( ) |
| 5 | Eu achei que as várias funções do site estão bem integradas. | ( ) | ( ) | ( ) | ( ) | ( ) |
| 6 | Eu achei que o site apresenta muita inconsistência. | ( ) | ( ) | ( ) | ( ) | ( ) |
| 7 | Eu imagino que a maioria das pessoas aprenderia a usar este site rapidamente. | ( ) | ( ) | ( ) | ( ) | ( ) |
| 8 | Eu achei o site muito complicado de usar. | ( ) | ( ) | ( ) | ( ) | ( ) |
| 9 | Eu me senti muito confiante ao usar o site. | ( ) | ( ) | ( ) | ( ) | ( ) |
| 10 | Eu precisei aprender muitas coisas antes de conseguir usar o site. | ( ) | ( ) | ( ) | ( ) | ( ) |

---

## Para a equipe: cálculo da pontuação

1. Itens ímpares (1, 3, 5, 7, 9), que são afirmações positivas: **resposta − 1**.
2. Itens pares (2, 4, 6, 8, 10), que são afirmações negativas: **5 − resposta**.
3. Somar os 10 valores (resultado de 0 a 40).
4. Multiplicar a soma por **2,5** (resultado de 0 a 100).

A pontuação SUS **não é uma porcentagem** e os itens isolados não devem ser interpretados separadamente. O resultado do grupo é a média das pontuações individuais.

### Exemplo de cálculo

Valores fictícios, apenas para ilustrar a fórmula:

| Item | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Resposta | 4 | 2 | 4 | 1 | 4 | 2 | 5 | 2 | 4 | 1 |
| Valor ajustado | 3 | 3 | 3 | 4 | 3 | 3 | 4 | 3 | 3 | 4 |

Soma = 33 → SUS = 33 × 2,5 = **82,5**

### Interpretação

| Pontuação SUS | Leitura |
| --- | --- |
| Abaixo de 51 | Faixa inferior (nota F): problemas sérios de usabilidade |
| De 51 a 67,9 | Abaixo da média |
| 68 | Média de referência (percentil 50) |
| De 68,1 a 80,2 | Acima da média |
| 80,3 ou mais | Faixa superior (nota A, cerca de 10% melhores) |

Referência das faixas: Sauro (2011) e Sauro e Lewis (2016). O critério complementar C3 do [plano](plano-de-teste-usabilidade.md) exige média de pelo menos 68.

## Consolidação

Registrar nas colunas Q1 a Q10 as respostas originais (1 a 5); a soma ajustada segue as regras de cálculo acima.

| Participante | Q1 | Q2 | Q3 | Q4 | Q5 | Q6 | Q7 | Q8 | Q9 | Q10 | Soma ajustada | SUS |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| P1 | | | | | | | | | | | | |
| P2 | | | | | | | | | | | | |
| P3 | | | | | | | | | | | | |
| P4 | | | | | | | | | | | | |
| P5 | | | | | | | | | | | | |
| **Média do SUS** | — | — | — | — | — | — | — | — | — | — | — | |

As médias por item não são calculadas, pois os itens não devem ser interpretados isoladamente.

## Montagem no Google Forms

- Usar uma pergunta do tipo **"Grade de múltipla escolha"**, com as 10 afirmações como linhas e as opções 1 a 5 como colunas.
- Ativar "Exigir uma resposta em cada linha".
- Incluir uma pergunta de resposta curta para o código do participante (P1, P2, …).
- Desativar a coleta de e-mails, para não registrar dados pessoais.
- Manter a ordem original das afirmações, sem embaralhar.
