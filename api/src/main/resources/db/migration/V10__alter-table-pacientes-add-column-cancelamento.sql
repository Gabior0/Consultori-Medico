alter table agendamento add cancelamento tinyint;
update agendamento set cancelamento = 1;
alter table agendamento add motivo varchar(100) not null;
update agendamento set motivo = "Consulta ativa";