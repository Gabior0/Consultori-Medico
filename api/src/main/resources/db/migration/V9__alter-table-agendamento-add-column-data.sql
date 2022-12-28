ALTER TABLE agendamento DROP COLUMN data_hora;
alter table agendamento add data varchar(10);
alter table agendamento add hora varchar(05);