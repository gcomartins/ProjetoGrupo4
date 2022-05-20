create database Grupo4;

use Grupo4;

drop database grupo4;

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
check(categoria = "Critico"  or categoria = "Alerta" or categoria = "Estavel" ),
descrição varchar(255)
);



insert into tbEmpresas (idEmpresa,nomeEmpresa, cnpj, representante, email, senha)values 
(34, "Bradesco","45245213652148","Guilherme","bradesco@email.com.br","1234"),
(0,"Santander","41256913652148","Leticia","santander@email.com.br","4321"),
(0,"Itau","32156485213549","Larissa","Itau@email.com.br","4215"),
(0,"Banco do Brasil","4124563254862","Lucas","bdrasil@email.com.br","4532");


insert into tbMaquinas (hostName,grupo, fkEmpresa) values 
("STFSAOC046893-L","GrupoA", 34),
("Mari","GrupoA",34),
("Pieroni","grupoB",34),
("Leticia","GrupoA",34),
("Lara","grupoB",34),
("Larissa","GrupoB",34),
("Gulherme","GrupoB",34),
("Algusto","GrupoB",34);

insert into tbUsuarios (nomeUsuario, email, senha, fkempresa) values 
("Guilherme","guilherme@email.com","1234", 1),
("Lara","lara@email.com","1234", 2),
("Leticia","leticia@email.com","1234", 3),
("Larissa","larissa@email.com","1234", 4),
("Lucas","lucas@email.com","1234", 3),
("Vinicius","vinicius@email.com","1234", 2),
("Danilo","danilo@email.com","1234", 1),
("Vinicius","cavalcante@email.com","1234", 4);


insert into tbComponentes (nome,limiteAlerta, fkMaquina) values 
("Disco",100,1),
("Ram",100,1),
("Cpu", 100,1),
("Ram",59,3),
("Disco",30,3),
("Cpu",39,3);

insert into tbLogs (leituraDesempenho, dataHora, fkComponente) values 
(100, now(),1),
(55, now(),2),
(100, now(),3),
(45, now(),4),
(20, now(),5),
(100, now(),6);


insert into tbAlertas (fkLog, categoria, descrição) values
(1, "Moderado", "*******"),
(2, "Alto", "**********"),
(3,"Moderado", "********"),
(4, "Severo", "********"),
(5, "Severo", "*******"),
(6, "Moderado", "******");




select * from tbUsuarios where email = 'guilherme@email.com' and senha = 1234;
select * from tbLogs;
select * from tbMaquinas;
select * from tbEmpresas;
select * from tbUsuarios;
select * from tbComponentes;
select * from tbAlertas;
truncate table tbMaquinas;
select * from tbLogs;

select *from tbComponentes as C join tbMaquinas as M on C.fkMaquina = M.idMaquina where hostName = 'STFSAOC046893-L';

select * from tbComponentes;

select L.idLog, C.nome, C.idComponentes, M.hostName, M.idMaquina from tbComponentes 
as C inner tbLogs as L 
                + " on C.idComponentes = L.fkComponente inner join tbMaquinas as M "
                + " on C.fkMaquina = M.idMaquina  where hostName = '" +nomeMaquina+ "'"
                + " and nome = '" + componente +"' order by idLog desc ",