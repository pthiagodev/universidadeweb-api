create table matriz_curricular(
    id bigint not null,
    codigo varchar(10) not null,

    primary key(id)
);

alter table matriz_curricular add constraint fk_matriz_curricular_id foreign key (id) references cursos (id);