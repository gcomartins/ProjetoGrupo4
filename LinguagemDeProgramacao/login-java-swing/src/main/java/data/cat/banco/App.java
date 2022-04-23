/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.banco;

import br.com.sptech.login.java.swing.ConexaoBanco;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lmmelo1
 */
public class App {

    public static void main(String[] args) {
        ConexaoBanco conexao = new ConexaoBanco();

        conexao.getConexao().execute("drop table if exists tbEmpresas");
        conexao.getConexao().execute("drop table if exists tbMaquinas");
        conexao.getConexao().execute("drop table if exists tbUsuarios");
        conexao.getConexao().execute("drop table if exists tbComponentes");
        conexao.getConexao().execute("drop table if exists tbLogs");
        conexao.getConexao().execute("drop table if exists tbAlertas");

        conexao.getConexao().execute("create table tbEmpresas ("
                + "idEmpresa INT PRIMARY KEY AUTO_INCREMENT,"
                + "nomeEmpresa VARCHAR(45),"
                + "cnpj VARCHAR(45),"
                + "representante VARCHAR(45),"
                + "email VARCHAR(45) unique,"
                + "senha VARCHAR(45)"
                + ");");

        conexao.getConexao().execute("create table tbMaquinas ("
                + "idMaquina INT PRIMARY KEY AUTO_iNCREMENT,"
                + "identPessoal varchar(15),"
                + "hostName varchar(45),"
                + "grupo VARCHAR(45),"
                + "fkEmpresa INT,"
                + "constraint FKEmpresa\n"
                + "foreign key (fkEmpresa) references tbEmpresas (idEmpresa));");

        conexao.getConexao().execute("create table tbUsuarios ("
                + "idUsuario INT PRIMARY KEY AUTO_INCREMENT,"
                + "nomeUsuario VARCHAR(45),"
                + "email VARCHAR(45) unique,"
                + "senha VARCHAR(45),"
                + "fkEmpresa INT,"
                + "constraint EmpresaUsuario "
                + "foreign key (fkEmpresa) references tbEmpresas (idEmpresa),"
                + "sudo TINYINT,"
                + "administrador TINYINT,"
                + "usuario TINYINT"
                + ");");

        conexao.getConexao().execute("CREATE TABLE tbComponentes ("
                + "idComponentes INT PRIMARY KEY AUTO_INCREMENT, "
                + "nome VARCHAR(45),"
                + "check( nome = 'Cpu' or nome = 'Disco' or nome = 'Ram'),"
                + "capacidade DOUBLE,"
                + "limiteAlerta DOUBLE,"
                + "fkMaquina INT,"
                + "constraint fkMaquina "
                + "foreign key (fkMaquina) references tbMaquinas (idMaquina)"
                + ");");

        conexao.getConexao().execute("Create table tbLogs ("
                + "idLog INT PRIMARY KEY AUTO_INCREMENT, "
                + "leituraDesempenho DOUBLE,"
                + "leituraTemperatura DOUBLE,"
                + "dataHora DATETIME,"
                + "fkComponente INT,"
                + "constraint fkComponente "
                + "foreign key (fkComponente) references tbComponentes (idComponentes)"
                + "); ");

        conexao.getConexao().execute("CREATE TABLE tbAlertas ("
                + "idAlerta int primary key auto_increment,"
                + "fkLog int,"
                + "constraint fkLog\n"
                + "foreign key (fkLog) references tbLogs (idLog),"
                + "categoria varchar(45)"
                + "check(categoria = 'Moderado'  or categoria = 'Alto' or categoria = 'Severo' ),"
                + "descrição varchar(255)"
                + ");");

        conexao.getConexao().update("insert into tbEmpresas(nomeEmpresa, cnpj, representante, email, senha)values "
                + "('Bradesco','45245213652148','Guilherme','bradesco@email.com.br','1234'),"
                + "('Santander','41256913652148','Leticia','santander@email.com.br','4321'),"
                + "('Itau','32156485213549','Larissa','Itau@email.com.br','4215'),"
                + "('Banco do Brasil','4124563254862','Lucas','bdrasil@email.com.br','4532');");

        conexao.getConexao().update("insert into tbMaquinas (hostName,grupo, fkEmpresa) values \n"
                + "('Lucas','GrupoA', 1),"
                + "('Mari','GrupoA',4),"
                + "('Pieroni','grupoB',2),"
                + "('Leticia','GrupoA',3),"
                + "('Lara','grupoB',1),"
                + "('Larissa','GrupoB',3),"
                + "('Gulherme','GrupoB',4),"
                + "('Algusto','GrupoB',2);");

        conexao.getConexao().update("insert into tbUsuarios (nomeUsuario, email, senha, fkempresa, sudo, administrador, usuario) values \n"
                + "('Guilherme','guilherme@email.com','1234', 1,true,true,true),"
                + "('Lara','lara@email.com','1234', 2,true,true,true),"
                + "('Leticia','leticia@email.com','1234', 3,true,true,true),"
                + "('Larissa','larissa@email.com','1234', 4,true,true,true),"
                + "('Lucas','lucas@email.com','1234', 3,false,true,true),"
                + "('Vinicius','vinicius@email.com','1234', 2,false,false,true),"
                + "('Danilo','danilo@email.com','1234', 1,false,true,true),"
                + "('Vinicius','cavalcante@email.com','1234', 4,false,false,true);");

        conexao.getConexao().update("insert into tbComponentes (nome, capacidade, limiteAlerta, fkMaquina) values "
                + "('Disco',1000,70,1),"
                + "('Ram', 16,70,1),"
                + "('Cpu', 64, 70,1),"
                + "('Ram',8,70,3),"
                + "('Disco',3000,85,3),"
                + "('Cpu',64,70,3);");

        conexao.getConexao().update("insert into tbLogs (leituraDesempenho, leituraTemperatura, dataHora, fkComponente) values \n"
                + "(100, 22.5, now(),1),"
                + "(55, 30.25, now(),2),"
                + "(100, 22.5, now(),3),"
                + "(45, 50.0, now(),4),"
                + "(20, 100.0, now(),5),"
                + "(100, 22.0, now(),6);");

        conexao.getConexao().update("insert into tbAlertas (fkLog, categoria, descrição) values\n"
                + "(1, 'Moderado', '*******'),"
                + "(2, 'Alto', '**********'),"
                + "(3,'Moderado', '********'),"
                + "(4, 'Severo', '********'),"
                + "(5, 'Severo', '*******'),"
                + "(6, 'Moderado', '******');");

        List<Map<String, Object>> tbEmpresas = conexao
                .getConexao()
                .queryForList("select * from tbEmpresas");

        System.out.println(tbEmpresas);
    }
}
