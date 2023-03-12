create database TOTVS_TEST;

USE TOTVS_TEST;

create table USERS(
	COD_USER int not null,
    NOME CHAR(250),
    MAIL CHAR(250),
    CPF varchar(38),
    STATUS VARCHAR(250));

insert into USERS values (1, "Boromir", "boromir@totvs.com.br", "83522866096", "Em rota de entrega");
insert into USERS values (2, "Frodo", "Frodo@totvs.com.br", "71515491056", "Aguardando postagem");
insert into USERS values (3, "Aragorn", "Aragorn@totvs.com.br", "91189406098", "Entrega concluida");
insert into USERS values (4, "Gimili", "Gimili@totvs.com.br", "15811951094", "Aguardando postagem");
insert into USERS values (5, "Gandalf", "Gandalf@totvs.com.br", "93112900090", "Aguardando postagem");
insert into USERS values (6, "Legolas", "Legolas@totvs.com.br", "93317977027", "Entrega concluida");
insert into USERS values (7, "Faramir", "Faramir@totvs.com.br", "27105941022", "Em rota de entrega");
insert into USERS values (8, "Theoden", "Theoden@totvs.com.br", "63861636050", "Entrega concluida");
insert into USERS values (9, "Galadriel", "Galadriel@totvs.com.br", "18318606000", "Em rota de entrega");
insert into USERS values (10, "Thranduil", "Thranduil@totvs.com.br", "82510046080", "Entrega concluida");