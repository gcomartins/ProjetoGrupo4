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
grupo VARCHAR(45),
fkEmpresa INT,
constraint FKEmpresa
foreign key (fkEmpresa) references tbEmpresas (idEmpresa));


create table tbUsuarios (
idUsuario INT PRIMARY KEY AUTO_INCREMENT,
nomeUsuario VARCHAR(45),
sobrenome VARCHAR(45),
email VARCHAR(45) unique,
senha VARCHAR(45),
fkEmpresa INT,
constraint EmpresaUsuario 
foreign key (fkEmpresa) references tbEmpresas (idEmpresa),
sudo TINYINT,
administrador TINYINT,
usuario TINYINT
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

insert into tbEmpresas (nomeEmpresa, cnpj, representante, email, senha)values 
("Bradesco","45245213652148","Guilherme","bradesco@email.com.br","1234"),
("Santander","41256913652148","Leticia","santander@email.com.br","4321"),
("Itau","32156485213549","Larissa","Itau@email.com.br","4215"),
("Banco do Brasil","4124563254862","Lucas","bdrasil@email.com.br","4532");


insert into tbMaquinas (grupo, fkEmpresa) values 
("GrupoA", 1),
("GrupoA",4),
("grupoB",2),
("GrupoA",3),
("grupoB",1),
("GrupoB",3),
("GrupoB",4),
("GrupoB",2);

insert into tbUsuarios (nomeUsuario, sobrenome, email, senha, fkempresa, sudo, administrador, usuario) values 
("Guilherme","Pereira","guilherme@email.com","1234", 1,true,true,true),
("Lara","Regina","lara@email.com","1234", 2,true,true,true),
("Leticia","Marques","leticia@email.com","1234", 3,true,true,true),
("Larissa","Santos","larissa@email.com","1234", 4,true,true,true),
("Lucas","Mastelini","lucas@email.com","1234", 3,false,true,true),
("Vinicius","Pieroni","vinicius@email.com","1234", 2,false,false,true),
("Danilo","Kovaks","danilo@email.com","1234", 1,false,true,true),
("Vinicius","Cavalcante","cavalcante@email.com","1234", 4,false,false,true);


insert into tbComponentes (nome, capacidade, limiteAlerta, limiteTemperatura, fkMaquina) values 
("Disco",1000,70,70,1),
("Ram", 16,70,70,1),
("Cpu", 64, 70,70,1),
("Ram",8,70,70,3),
("Disco",3000,85,85,3),
("Cpu",64,70,55,3);

insert into tbLogs (leituraDesempenho, leituraTemperatura, dataHora, fkComponente) values 
(100, 22.5, now(),1),
(55, 30.25, now(),2),
(100, 22.5, now(),3),
(45, 50.0, now(),4),
(20, 100.0, now(),5),
(100, 22.0, now(),6);


insert into tbAlertas (fkLog, categoria, descrição) values
(1, "Moderado", "*******"),
(2, "Alto", "**********"),
(3,"Moderado", "********"),
(4, "Severo", "********"),
(5, "Severo", "*******"),
(6, "Moderado", "******");




select * from tbLogs;

