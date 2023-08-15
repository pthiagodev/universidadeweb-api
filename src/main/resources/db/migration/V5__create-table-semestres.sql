create table semestres(
    id bigint not null auto_increment,
    codigo varchar(10) not null,
    matriz_curricular_id bigint not null,

    primary key(id)
);

alter table semestres add constraint fk_semestres_matriz_curricular_id foreign key (matriz_curricular_id) references matriz_curricular (id);