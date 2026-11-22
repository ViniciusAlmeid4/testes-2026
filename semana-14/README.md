# Semana 14 — Teste de Usuário Final (Mercado Livre)

Atividade de IHC e testes de usabilidade: planejar, executar e analisar um teste com usuários finais no fluxo de busca, comparação e simulação de compra de um fone de ouvido Bluetooth no Mercado Livre.

**Enunciado:** [enunciado-teste-usuario-final.pdf](enunciado-teste-usuario-final.pdf)

## Documentos

| Arquivo | Conteúdo | Quando usar |
| --- | --- | --- |
| [plano-de-teste-usabilidade.md](plano-de-teste-usabilidade.md) | Objetivo, cenário, tarefas, participantes, procedimento, métricas, critérios, decisões e riscos | Leitura da equipe antes de tudo |
| [analise-heuristica.md](analise-heuristica.md) | Inspeção do fluxo e avaliação com as 10 heurísticas de Nielsen; hipóteses a observar | Antes do piloto |
| [casos-de-teste-usabilidade.md](casos-de-teste-usabilidade.md) | Marco de término e regras de sucesso e falha de cada tarefa | Piloto e sessões |
| [roteiro-do-avaliador.md](roteiro-do-avaliador.md) | Checklists, falas padronizadas, política de ajuda, termo de consentimento e cartão de tarefas | Durante as sessões |
| [planilha-de-observacao.md](planilha-de-observacao.md) | Registro de tempo, sucesso, ajuda e erros por participante e consolidação | Durante e após as sessões |
| [questionario-sus.md](questionario-sus.md) | Questionário SUS, cálculo e interpretação | Ao fim de cada sessão |
| [relatorio-de-resultados.md](relatorio-de-resultados.md) | Modelo do relatório final: critérios, problemas e recomendações | Após as sessões |

## Como executar

1. **Preparar:** ler o plano, preparar a conta de teste conforme o checklist do roteiro e imprimir o roteiro, as planilhas, o termo, o cartão de tarefas e o SUS.
2. **Piloto:** fazer uma sessão não contabilizada e registrar na seção 2 do relatório os itens que a inspeção não cobriu, como o que aparece depois de "Continuar (1)" no carrinho.
3. **Sessões:** seguir o roteiro com cada participante (de 15 a 20 minutos por pessoa) e reinicializar o ambiente ao final de cada sessão.
4. **Consolidar:** preencher a consolidação da planilha e do SUS.
5. **Relatar:** preencher o relatório, comparando os resultados com os critérios C1 a C3 e com as hipóteses da análise heurística.

## Rastreabilidade com o enunciado

| Item do enunciado | Onde é tratado |
| --- | --- |
| 1. Objetivo do teste | [Plano](plano-de-teste-usabilidade.md), seção 1 |
| 2. Cenário de uso | Plano, seção 2; [roteiro](roteiro-do-avaliador.md), seção 4 e Anexo B (cartão de tarefas) |
| 3. Tarefas 1 a 7 | Plano, seção 3; [casos de teste](casos-de-teste-usabilidade.md) T1 a T7 |
| 6. Dados coletados: tempo, taxa de sucesso e erros | Plano, seção 6; [planilha de observação](planilha-de-observacao.md) |
| 7. Critério: 90% adicionam o produto ao carrinho | Plano, seção 7 (C1 e tabela 7.1); [relatório](relatorio-de-resultados.md), seção 6 |
| 7. Critério: tempo médio de até 4 minutos | Plano, seção 7 (C2); relatório, seção 6 |
| 8. Papéis: usuário final, avaliador e instrutor | Plano, seção 8; roteiro |
| 8. Ferramentas: navegador, cronômetro, planilha e formulário SUS | Plano, seção 8; planilha; [questionário SUS](questionario-sus.md) |
| 9. Exemplo de planilha de observação | Planilha de observação, com as alterações listadas na seção 9 do plano |
| Aplicação de conceitos de IHC e testes de usabilidade | ISO 9241-11 (plano, seção 1); heurísticas de Nielsen ([análise heurística](analise-heuristica.md)); SUS |

## Situação da entrega

- [x] Planejamento e instrumentos de coleta
- [x] Inspeção do fluxo e análise heurística
- [ ] Teste piloto
- [ ] Sessões com os participantes
- [ ] Relatório de resultados preenchido

## Ajustes em relação ao enunciado

O enunciado deixa alguns pontos em aberto. As decisões da equipe estão na seção 10 do plano e as principais são:

- as seções 4 (perfil dos participantes) e 5 (procedimento), ausentes no enunciado, foram completadas;
- a sessão começa com uma conta de teste já autenticada, porque o checkout exige conta;
- como o site não oferece ordenação por avaliação, a T3b é avaliada pela nota do produto escolhido (≥ 4,5);
- o participante para na tela "Finalize sua compra", que reúne pagamento e o botão "Pagar e finalizar";
- a planilha de observação ganhou a linha da tarefa 7, a divisão da tarefa 3 e a coluna "Ajuda";
- foi proposto um critério complementar de satisfação (SUS ≥ 68).
