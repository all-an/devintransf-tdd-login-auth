create table clientes(
id serial,
cpf varchar(50),
name varchar(50),
password varchar,
email varchar(100),
primary key (id));


create table conta(
id serial,
name varchar(60),
value numeric(10,2),
primary key (id));

create table cliente_conta(
id serial,
conta integer,
clientes integer,
primary key(id),
foreign key(clientes) references clientes(id),
foreign key(conta) references conta(id));

create table conta_operacoes(
id serial,
conta integer,
date date,
type varchar(2),
description varchar(500),
value numeric(10,2),
primary key(id),
foreign key(conta) references conta(id)
);