# Plano de Teste – Sistema de Gerenciamento de Salas

## 1. Introdução

Este plano de teste descreve a abordagem para testar o Sistema de Gerenciamento de Salas, cujo objetivo é permitir o controle de reservas de salas, considerando disponibilidade, capacidade, manutenção, permissões de usuários e notificações.

O objetivo dos testes é verificar se o sistema atende aos requisitos especificados e apresenta funcionamento correto, seguro e confiável.

## 2. Objetivos

Os objetivos dos testes são:

- Verificar se os requisitos funcionais foram implementados corretamente.
- Validar os requisitos não funcionais relacionados a desempenho, auditoria e controle de acesso.
- Identificar comportamentos incorretos e possíveis falhas.
- Garantir que operações inválidas sejam impedidas pelo sistema.
- Validar cenários de limite e situações de conflito entre reservas.

## 3. Escopo

O teste abrangerá as funcionalidades relacionadas a:

- Reserva e alteração de salas.
- Verificação de disponibilidade e compatibilidade.
- Controle de capacidade.
- Bloqueio de salas em manutenção.
- Controle de horários de reserva.
- Permissões de professores e coordenação.
- Cancelamento e histórico de reservas.
- Notificações.
- Desempenho das buscas.
- Auditoria das operações.
- Restrição de acesso por unidade.

## 4. Estratégia de Teste

A estratégia de teste incluirá:

- **Testes unitários:** validação das regras individuais de negócio.
- **Testes de integração:** validação da comunicação entre reservas, usuários, salas, histórico e notificações. <!-- - **Testes de sistema:** validação do comportamento do sistema completo. -->
- **Testes de aceitação:** verificação de que o sistema atende às necessidades dos usuários.
- **Testes de desempenho:** medição do tempo de resposta das buscas.
- **Testes de segurança/autorização:** validação das permissões de acesso e alteração.

## 5. Casos de Teste

Serão elaborados casos de teste positivos e negativos, incluindo situações de limite e conflito.

Segue um exemplo do modelo a ser seguido:

### CT01 – Reservar sala disponível e compatível

**Requisito(s):** RF1

**Descrição:** Verificar se uma sala disponível e compatível com a solicitação pode ser reservada.

**Pré-condições:**

- Usuário autenticado.
- Existência de uma sala compatível.
- Sala disponível no horário solicitado.

**Passos:**

1. Acessar a tela de reservas.
2. Informar data, horário e demais critérios da reserva.
3. Selecionar uma sala compatível disponível.
4. Confirmar a reserva.

**Resultado esperado:** A reserva é criada com sucesso e a sala fica vinculada ao horário solicitado.

---

## 6. Ambiente de Teste

Os testes serão realizados em ambiente dedicado, configurado de forma semelhante ao ambiente de produção.

O ambiente deverá possuir:

- Sistema instalado e configurado.
- Banco de dados com salas, reservas, usuários e unidades.
- Diferentes perfis de usuário.
- Salas com diferentes capacidades e estados.
- Dados suficientes para realização dos testes de desempenho.
- Serviço de notificações disponível para validação.

## 7. Recursos

**Equipe de teste:** responsáveis pela execução dos casos de teste e registro dos resultados.

**Ambiente:** servidor e banco de dados configurados para testes.

**Dados de teste:**

- Professores.
- Usuários da coordenação.
- Unidades.
- Salas com diferentes capacidades.
- Salas em manutenção.
- Reservas em diferentes horários.
- Registros de histórico e auditoria.

## 8. Cronograma

O processo poderá ser dividido em:

- **Etapa 1:** testes unitários das regras de negócio.
- **Etapa 2:** testes de integração entre reservas, usuários, salas e notificações.
- **Etapa 3:** testes de sistema dos 11 requisitos.
- **Etapa 4:** testes de desempenho e segurança.
- **Etapa 5:** testes de aceitação.

## 9. Critérios de Aceitação

O sistema será considerado aprovado quando:

- Todos os 11 requisitos forem testados.
- Todos os casos críticos forem aprovados.
- As regras de negócio forem respeitadas nos cenários positivos e negativos.
- A busca atender ao limite de até 2 segundos definido no RNF1.
- As operações previstas possuírem registros de auditoria.
- O controle de acesso por unidade funcionar corretamente.
- Defeitos críticos e importantes forem corrigidos e retestados.

## 10. Riscos

Os principais riscos são:

- Falhas nas regras de conflito entre reservas.
- Erros nos cálculos de capacidade ou horários.
- Falhas no envio de notificações.
- Registros de auditoria incompletos.
- Acesso indevido a dados de outras unidades.
- Degradação do desempenho com grande volume de dados.
- Alterações no sistema durante a execução dos testes.

## 11. Responsabilidades

**Equipe de desenvolvimento:**

- Corrigir defeitos identificados.
- Apoiar a análise de falhas.
- Disponibilizar versões corrigidas para reteste.

**Equipe de teste:**

- Preparar os dados de teste.
- Executar os casos de teste.
- Registrar evidências e resultados.
- Reportar defeitos encontrados.
- Realizar os retestes após as correções.

## 12. Comunicação

Os resultados dos testes e os defeitos encontrados serão registrados e compartilhados com a equipe responsável pelo desenvolvimento.

Os resultados deverão indicar, no mínimo:

- Caso de teste executado.
- Resultado obtido.
- Resultado esperado.
- Situação: aprovado ou reprovado.
- Defeitos identificados.

## 13. Aprovação

Este plano de teste deverá ser revisado pelas partes responsáveis pelo projeto antes do início da execução.

Alterações nos requisitos ou na estratégia de testes deverão ser documentadas e comunicadas aos envolvidos.

## 14. Considerações Finais

Este plano estabelece os testes necessários para verificar o atendimento aos 11 requisitos definidos para o Sistema de Gerenciamento de Salas.

A execução dos casos de teste permitirá validar as principais regras de reserva, controle de acesso, auditoria, notificações e desempenho, contribuindo para a qualidade e confiabilidade do sistema.