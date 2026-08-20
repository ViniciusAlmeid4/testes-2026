# Caso de Teste — Reserva de Sala

## Descrição:

Este caso de teste visa validar a efetividade e o tratamento de erros para a função de reserva de sala, focando em disponibilidade, viabilidade da junção entre sala e turma, horários e permissões, verificando se as reservas de sala de aula atendem às necessidades apresentadas nos requisitos RF-01, RF-02, RF-03, RF-04, RF-05 e RNF-03.

## Pré-condições:

Sistema em funcionamento, com acesso ao banco de dados. Também deve haver turmas, salas e professores cadastrados para serem utilizados nos testes.

- Sala 18, com capacidade para 40 alunos, vinculada à unidade 1.
- Sala 12 com capacidade de 30 alunos, vinculada à unidade 1, com status "Em Manutenção".
- Sala 10, com capacidade para 20 alunos, vinculada à unidade 1.
- Sala 7, com capacidade para 40 alunos, vinculada à unidade 1.

- Turma 6-A, com 25 alunos cadastrados, vinculada à unidade 1.

- Usuário Pedro está cadastrado, vinculado à unidade 1, e é do tipo professor.
- Usuário Vitor está cadastrado, vinculado à unidade 2, e é do tipo professor.

- Reserva da sala 7, com data de 2026/03/10, das 7h30 às 9h30, pelo usuário Vitor, para a turma 6-A.

## Passos:

1. Acessar página de reservas.
2. Clicar no botão para realizar reserva.
3. Abrir o modal de solicitação de reservas.
4. Preencher o formulário com as informações da reserva, contendo turma, horário e sala.
5. Solicitar reserva clicando no botão de enviar.

## Cenários:

1.  - Dados de teste:
      - Turma: Turma 6-A.
      - Sala: 18.
      - data: 2026/03/03 08:00 até 10:30.
      - Usuário: Pedro.

    - Resultado Esperado:
      - Reserva é adicionada a lista de reservas do professor e os alunos são informados.
      - Sistema retorna que a reserva foi efetuada e fechar o modal.

2.  - Dados de teste:
      - Turma: Turma 6-A.
      - Sala: 10.
      - data: 2026/03/03 08:00 até 10:30.
      - Usuário: Pedro.

    - Resultado Esperado:
      - Reserva é recusada pela sala não suportar a quantidade de alunos.
      - Sistema retorna que a reserva não foi efetuada e indica o problema por meio da mensagem de erro + erro visual no input de sala e turma.

3.  - Dados de teste:
      - Turma: Turma 6-A.
      - Sala: 18.
      - data: 2026/03/03 06:00 até 09:30.
      - Usuário: Pedro.

    - Resultado Esperado:
      - Reserva é recusada pelo horário inválido, antes das 07:30 ou depois das 22:30.
      - Sistema retorna que a reserva não foi efetuada e indica o problema por meio da mensagem de erro + erro visual no input de horário.

4.  - Dados de teste:
      - Turma: Turma 6-A.
      - Sala: 18.
      - data: 2026/03/03 21:30 até 23:00.
      - Usuário: Pedro.

    - Resultado Esperado:
      - Reserva é recusada pelo horário inválido, antes das 07:30 ou depois das 22:30.
      - Sistema retorna que a reserva não foi efetuada e indica o problema por meio da mensagem de erro + erro visual no input de horário.

5.  - Dados de teste:
      - Turma: Turma 6-A.
      - Sala: 18.
      - data: 2026/03/03 21:00 até 22:30.
      - Usuário: Vitor.

    - Resultado Esperado:
      - Reserva é recusada pois o usuário não está vinculado a unidade 1.
      - Sistema retorna que a reserva não foi efetuada e indica o problema por meio da mensagem de erro + fecha o modal e solicita a reabertura para puxar os dados novamente.

6.  - Dados de teste:
      - Turma: Turma 6-A.
      - Sala: 7.
      - data: 2026/03/10 08:00 até 10:30.
      - Usuário: Pedro.

    - Resultado Esperado:
      - Reserva é recusada pois o horário solicitado já tem alguma reserva.
      - Sistema retorna que a reserva não foi efetuada e indica o problema por meio da mensagem de erro + indica possiveis trocas de sala ou horários.

7.  - Dados de teste:
      - Turma: Turma 6-A.
      - Sala: 12 (Em Manutenção).
      - data: 2026/03/10 08:00 até 10:30.
      - Usuário: Pedro.

    - Resultado Esperado:
      - Reserva é recusada pois a sala selecionada encontra-se bloqueada para manutenção.
      - Sistema retorna que a reserva não foi efetuada e indica o problema por meio da mensagem de erro informando o status da sala.

## Pós-condições:

O modal de reservas é fechado; em seguida, uma mensagem de confirmação é apresentada ao usuário, e a lista de seus agendamentos é atualizada. Além disso, esse agendamento fica disponível para consulta de outros usuários, permitindo identificar sobreposições e informá-los sobre ele.
