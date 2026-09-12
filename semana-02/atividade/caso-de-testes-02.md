# Caso de Teste - Alteração e Cancelamento de Reserva

## Descrição:

Este caso de teste visa validar as regras e permissões para alteração e cancelamento de reservas, garantindo que apenas a coordenação possa modificar agendamentos de terceiros (RF-06). Verifica também a liberação de horários com registro de histórico (RF-07), a geração de notificações para os envolvidos (RF-08), o tempo de resposta das buscas (RNF-01) e o registro da trilha de auditoria (RNF-02).

## Pré-condições:

Sistema rodando com acesso ao banco de dados. Devem existir usuários, turmas, salas e reservas previamente cadastrados.

- Sala 35 com capacidade de 30 alunos e vinculada à unidade 1.
- Turma 4-B vinculada à unidade 1.

- Usuário Carlos está cadastrado, vinculado à unidade 1 e é do tipo COORDENADOR.
- Usuário Marcos está cadastrado, vinculado à unidade 1 e é do tipo PROFESSOR.
- Usuário João está cadastrado, vinculado à unidade 1 e é do tipo PROFESSOR.

- Reserva da sala 35 com data 12/09/2026 21:00 às 22:30, criada pelo usuário João para a turma 4-B.

## Passos:

1. Acessar a página de reservas.
2. Utilizar a busca para encontrar o agendamento específico (Sala 35, 12/09/2026).
3. Clicar no botão para alterar ou cancelar a reserva pertencente ao outro professor.
4. Confirmar a ação no modal do sistema.

## Cenários:

1.  - Dados de teste:
      - Usuário logado: Carlos (COORDENADOR).
      - Alvo da ação: Cancelar reserva da Sala 35 do usuário João.
      - Horário da reserva: 12/09/2026 as 21:00.

    - Resultado Esperado:
      - O sistema permite o cancelamento e libera o horário da sala no calendário.
      - O sistema envia uma notificação automática de cancelamento para o professor João e para a turma 4-B.
      - O histórico da requisição e a liberação são salvos no log de auditoria com sucesso.
      - Feedback visual na tela indicando que a reserva foi cancelada.

2.  - Dados de teste:
      - Usuário logado: Marcos (PROFESSOR).
      - Alvo da ação: Cancelar reserva da Sala 35 do usuário João.
      - Horário da reserva: 12/09/2026 as 21:00.

    - Resultado Esperado:
      - A ação é bloqueada pelo sistema retornando erro de permissão negada (permission_denied).
      - O horário não é liberado e a reserva do usuário João permanece intacta.
      - A tentativa de ação não autorizada do usuário Marcos é registrada no log de auditoria.
      - Feedback visual na tela indicando erro de permissão.

3.  - Dados de teste:
      - Ação: Executar a busca pelo agendamento.
      - Condição: Tempo de resposta normal do servidor.

    - Resultado Esperado:
      - O sistema deve processar a busca e renderizar os resultados na tela em até 2 segundos (Atendendo ao RNF-01).

4.  - Dados de teste:
      - Ação: Executar a busca pelo agendamento.
      - Condição: Simulação de timeout/lentidão da rede (tempo de resposta superior a 2 segundos).

    - Resultado Esperado:
      - O sistema lida com a lentidão mantendo o indicador de carregamento (loading) visível e exibe uma mensagem de erro amigável (timeout) caso o tempo máximo de espera estoure, sem quebrar a interface visual.

## Pós-condições:

Todas as requisições executadas, sejam elas bem-sucedidas (Cenário 1) ou falhas (Cenário 2), devem estar obrigatoriamente persistidas na trilha de auditoria do banco de dados, contendo a data, a ação, e o responsável pela requisição.
