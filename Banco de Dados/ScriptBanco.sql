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
identPessoal varchar(15),
hostName varchar(45),
grupo VARCHAR(45),
fkEmpresa INT,
constraint FKEmpresa
foreign key (fkEmpresa) references tbEmpresas (idEmpresa));

-- Select por HostName 
select M.*, C.nome, C.capacidade, C.limiteAlerta, C.limiteTemperatura from tbMaquinas as M 
inner join tbComponentes as C on M.idmaquina =  C.fkMaquina where hostName = "Lucas";



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




CREATE TABLE tbComponentes (
idComponentes INT PRIMARY KEY AUTO_INCREMENT, 
nome VARCHAR(45)
check( nome = "Cpu" or nome = "Disco" or nome = "Ram"),
capacidade DOUBLE,
limiteAlerta DOUBLE,
fkMaquina INT,
constraint fkMaquina 
foreign key (fkMaquina) references tbMaquinas (idMaquina)
);





-- DashCards
select M.idMaquina , M.hostName, C.nome, L.leituraDesempenho, L.dataHora
, A.idAlerta, A.categoria, A.descrição  from tbMaquinas as M  inner join tbComponentes as C on C.fkMaquina = C.fkMaquina
inner join tbLogs as L on L.fkComponente = C.idComponentes 
inner join tbAlertas as A on A.fkLog = L.idLog Where hostName = "Lucas" ;

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


insert into tbMaquinas (hostName,grupo, fkEmpresa) values 
("Lucas","GrupoA", 1),
("Mari","GrupoA",4),
("Pieroni","grupoB",2),
("Leticia","GrupoA",3),
("Lara","grupoB",1),
("Larissa","GrupoB",3),
("Gulherme","GrupoB",4),
("Algusto","GrupoB",2);

insert into tbUsuarios (nomeUsuario, email, senha, fkempresa) values 
("Guilherme","guilherme@email.com","1234", 1),
("Lara","lara@email.com","1234", 2),
("Leticia","leticia@email.com","1234", 3),
("Larissa","larissa@email.com","1234", 4),
("Lucas","lucas@email.com","1234", 3),
("Vinicius","vinicius@email.com","1234", 2),
("Danilo","danilo@email.com","1234", 1),
("Vinicius","cavalcante@email.com","1234", 4);


insert into tbComponentes (nome, capacidade, limiteAlerta, fkMaquina) values 
("Disco",1000,70,1),
("Ram", 16,70,1),
("Cpu", 64, 70,1),
("Ram",8,70,3),
("Disco",3000,85,3),
("Cpu",64,70,3);

insert into tbLogs (leituraDesempenho, dataHora, fkComponente) values 
(100, now(),7),
(55, now(),8),
(100, now(),9),
(45, now(),10),
(20, now(),11),
(100, now(),12);


insert into tbAlertas (fkLog, categoria, descrição) values
(33, "Moderado", "*******"),
(34, "Alto", "**********"),
(35,"Moderado", "********"),
(36, "Severo", "********"),
(37, "Severo", "*******"),
(38, "Moderado", "******");





select * from tbLogs;
select * from tbMaquinas;
select * from tbEmpresas;
SELECT * FROM tbUsuarios;
SELECT * FROM tbComponentes;
SELECT * FROM tbMaquinasComponentes;
