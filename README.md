Regras de negócio:

1. Um paciente só pode agendar consultas futuras.
2. Uma consulta deve possuir paciente, médico, horário inicial e horário final.
3. O horário inicial da consulta deve ser anterior ao horário final.
4. O médico precisa possuir disponibilidade cadastrada para o dia e horário solicitado.
5. Um médico não pode ter duas consultas ativas no mesmo intervalo de horário.
6. Um paciente não pode ter duas consultas ativas no mesmo intervalo de horário.
7. Toda consulta criada inicia com status SCHEDULED.
8. Apenas consultas SCHEDULED podem ser canceladas.
9. Consultas canceladas não bloqueiam novos agendamentos.
10. Consultas só podem ser concluídas após o horário final.