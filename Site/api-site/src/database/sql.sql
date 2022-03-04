-- Arquivo de apoio, caso você queira criar tabelas como as aqui criadas para a API funcionar.
-- Você precisa executar os comandos no banco de dados para criar as tabelas,
-- ter este arquivo aqui não significa que a tabela em seu BD estará como abaixo!

/* para sql server - remoto - produção */

create table Usuario (
idUsuario int primary key auto_increment,
Nome varchar(45),
Sobrenome varchar(45),
dataNascimento date,
email varchar(45),
check (email like '%@%'),
senha varchar(45),
-- check ((senha like '%1%' or senha like '%2%' or senha like '%3%' or senha like '%4%' or senha like '%5%' or senha like '%6%'
--  or senha like '%7%' or senha like '%8%' or senha like '%9%') and (senha like '%@%' or senha like '%#%' or senha like '%&%' or senha like '%$%')),
fkAnfitriao int,
foreign key (fkAnfitriao) references Usuario(idUsuario)
) auto_increment = 100;


/* para workbench - local - desenvolvimento */
create database HomoUniversalis;
use HomoUniversalis;

create table Usuario (
idUsuario int primary key auto_increment,
Nome varchar(45),
Sobrenome varchar(45),
dataNascimento date,
email varchar(45),
check (email like '%@%'),
senha varchar(45),
check ((senha like '%1%' or senha like '%2%' or senha like '%3%' or senha like '%4%' or senha like '%5%' or senha like '%6%'
 or senha like '%7%' or senha like '%8%' or senha like '%9%') and (senha like '%@%' or senha like '%#%' or senha like '%&%' or senha like '%$%')),
fkAnfitriao int,
foreign key (fkAnfitriao) references Usuario(idUsuario)
) auto_increment = 100;

create table Ranking (
idJogada int primary key auto_increment,
fkUsuario int,
foreign key (fkUsuario) references Usuario(idUsuario),
pontos int
)auto_increment = 1000;
