create table filmes(
    id bigint not null auto_increment,
    nome varchar(100) not null,
    duracao_em_minutos int not null,
    ano_lancamento int not null,
    categoria varchar(100),
primary key(id)
);
