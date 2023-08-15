create table semestre_disciplinas(
    semestres_id bigint not null,
    disciplinas_id bigint not null,

    foreign key (semestres_id) references semestres (id),
    foreign key (disciplinas_id) references disciplinas (id)
);

