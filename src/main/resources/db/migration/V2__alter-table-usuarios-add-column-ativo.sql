alter table usuarios add ativo tinyint not null;
update usuarios set usuarios.ativo =1