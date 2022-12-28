create table agendamento(

    id bigint not null auto_increment,
    paciente varchar(100) not null,
    medico varchar(100) not null,
    data_hora varchar(16) not null,

    primary key(id)

);