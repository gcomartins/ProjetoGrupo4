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
create database Grupo4;

use Grupo4;


create table tbEmpresas (
idEmpresa INT PRIMARY KEY AUTO_INCREMENT,
nomeEmpresa VARCHAR(45),
cnpj VARCHAR(45),
representante VARCHAR(45),
email VARCHAR(45) unique,
senha VARCHAR(45)
);


create table tbMaquinas (
idMaquina INT PRIMARY KEY AUTO_iNCREMENT,
hostName varchar(45),
grupo VARCHAR(45),
fkEmpresa INT,
constraint FKEmpresa
foreign key (fkEmpresa) references tbEmpresas (idEmpresa));


create table tbUsuarios (
idUsuario INT PRIMARY KEY AUTO_INCREMENT,
nomeUsuario VARCHAR(45),
sobrenomeUsuario VARCHAR(45),
email VARCHAR(45) unique,
senha VARCHAR(45),
cargo VARCHAR(45),
fkEmpresa INT,
constraint EmpresaUsuario 
foreign key (fkEmpresa) references tbEmpresas (idEmpresa)
);

create table tbfuncionarios (
idfuncionario INT PRIMARY KEY AUTO_INCREMENT,
nomefuncionario VARCHAR(45),
email VARCHAR(45) unique,
senha VARCHAR(45),
fkEmpresa INT,
constraint EmpresaUsuario 
foreign key (fkEmpresa) references tbEmpresas (idEmpresa),
cargo VARCHAR(45)
);


CREATE TABLE tbComponentes (
idComponentes INT PRIMARY KEY AUTO_INCREMENT, 
nome VARCHAR(45)
check( nome = "Cpu" or nome = "Disco" or nome = "Ram"),
capacidade DOUBLE,
limiteAlerta DOUBLE,
limiteTemperatura DOUBLE,
fkMaquina INT,
constraint fkMaquina 
foreign key (fkMaquina) references tbMaquinas (idMaquina)
);


Create table tbLogs (
idLog INT PRIMARY KEY AUTO_INCREMENT, 
leituraDesempenho DOUBLE,
leituraTemperatura DOUBLE,
dataHora DATETIME,
fkComponente INT,
constraint fkComponente 
foreign key (fkComponente) references tbComponentes (idComponentes)
); 



CREATE TABLE tbAlertas (
idAlerta int primary key auto_increment,
fkLog int,
constraint fkLog
foreign key (fkLog) references tbLogs (idLog),
categoria varchar(45) 
check(categoria = "Moderado"  or categoria = "Alto" or categoria = "Severo" ),
descrição varchar(255)
);
