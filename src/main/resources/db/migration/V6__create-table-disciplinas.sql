create table disciplinas(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    codigo varchar(10) not null,
    carga_horaria bigint not null,

    primary key(id)
);

