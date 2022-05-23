/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.banco;

import data.cat.modal.Componente;
import data.cat.service.ModalServices;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author lmmelo1
 */
public class H2 {

    public static void main(String[] args) throws UnknownHostException {
        ConexaoAzure conexao = new ConexaoAzure();

        conexao.getConexaoAzure().execute("drop table if exists tbEmpresas");
        conexao.getConexaoAzure().execute("drop table if exists tbMaquinas");
        conexao.getConexaoAzure().execute("drop table if exists tbUsuarios");
        conexao.getConexaoAzure().execute("drop table if exists tbComponentes");
        conexao.getConexaoAzure().execute("drop table if exists tbLogs");
        conexao.getConexaoAzure().execute("drop table if exists tbAlertas");

        conexao.getConexaoAzure().execute("create table tbEmpresas ("
                + "idEmpresa INT PRIMARY KEY AUTO_INCREMENT,"
                + "nomeEmpresa VARCHAR(45),"
                + "cnpj VARCHAR(45),"
                + "representante VARCHAR(45),"
                + "email VARCHAR(45) unique,"
                + "senha VARCHAR(45)"
                + ");");

        conexao.getConexaoAzure().execute("create table tbMaquinas ("
                + "idMaquina INT PRIMARY KEY AUTO_iNCREMENT,"
                + "identPessoal varchar(15),"
                + "hostName varchar(45),"
                + "grupo VARCHAR(45),"
                + "fkEmpresa INT,"
                + "constraint FKEmpresa\n"
                + "foreign key (fkEmpresa) references tbEmpresas (idEmpresa));");

        conexao.getConexaoAzure().execute("create table tbUsuarios ("
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

        conexao.getConexaoAzure().execute("CREATE TABLE tbComponentes ("
                + "idComponentes INT PRIMARY KEY AUTO_INCREMENT, "
                + "nome VARCHAR(45),"
                + "check( nome = 'Cpu' or nome = 'Disco' or nome = 'Ram'),"
                + "capacidade DOUBLE,"
                + "limiteAlerta DOUBLE,"
                + "fkMaquina INT,"
                + "constraint fkMaquina "
                + "foreign key (fkMaquina) references tbMaquinas (idMaquina)"
                + ");");

        conexao.getConexaoAzure().execute("Create table tbLogs ("
                + "idLog INT PRIMARY KEY AUTO_INCREMENT, "
                + "leituraDesempenho DOUBLE,"
                + "leituraTemperatura DOUBLE,"
                + "dataHora DATETIME,"
                + "fkComponente INT,"
                + "constraint fkComponente "
                + "foreign key (fkComponente) references tbComponentes (idComponentes)"
                + "); ");

        conexao.getConexaoAzure().execute("CREATE TABLE tbAlertas ("
                + "idAlerta int primary key auto_increment,"
                + "fkLog int,"
                + "constraint fkLog\n"
                + "foreign key (fkLog) references tbLogs (idLog),"
                + "categoria varchar(45)"
                + "check(categoria = 'Moderado'  or categoria = 'Alto' or categoria = 'Severo' ),"
                + "descrição varchar(255)"
                + ");");

        conexao.getConexaoAzure().update("insert into tbEmpresas(nomeEmpresa, cnpj, representante, email, senha)values "
                + "('Bradesco','45245213652148','Guilherme','bradesco@email.com.br','1234'),"
                + "('Santander','41256913652148','Leticia','santander@email.com.br','4321'),"
                + "('Itau','32156485213549','Larissa','Itau@email.com.br','4215'),"
                + "('Banco do Brasil','4124563254862','Lucas','bdrasil@email.com.br','4532');");

        conexao.getConexaoAzure().update("insert into tbMaquinas (hostName,grupo, fkEmpresa) values \n"
                + "('STFSAOC046893-L','GrupoA', 1),"
                + "('Mari','GrupoA',4),"
                + "('Pieroni','grupoB',2),"
                + "('Leticia','GrupoA',3),"
                + "('Lara','grupoB',1),"
                + "('Larissa','GrupoB',3),"
                + "('Gulherme','GrupoB',4),"
                + "('Algusto','GrupoB',2);");

        conexao.getConexaoAzure().update("insert into tbUsuarios (nomeUsuario, email, senha, fkempresa, sudo, administrador, usuario) values \n"
                + "('Guilherme','guilherme@email.com','1234', 1,true,true,true),"
                + "('Lara','lara@email.com','1234', 2,true,true,true),"
                + "('Leticia','leticia@email.com','1234', 3,true,true,true),"
                + "('Larissa','larissa@email.com','1234', 4,true,true,true),"
                + "('Lucas','lucas@email.com','1234', 3,false,true,true),"
                + "('Vinicius','vinicius@email.com','1234', 2,false,false,true),"
                + "('Danilo','danilo@email.com','1234', 1,false,true,true),"
                + "('Vinicius','cavalcante@email.com','1234', 4,false,false,true);");

        conexao.getConexaoAzure().update("insert into tbComponentes (nome,limiteAlerta, fkMaquina) values "
                + "('Disco',75,1),"
                + "('Ram',55,1),"
                + "('Cpu',90,1),"
                + "('Ram',30,3),"
                + "('Disco',85,3),"
                + "('Cpu',64,3);");

        conexao.getConexaoAzure().update("insert into tbLogs (leituraDesempenho, leituraTemperatura, dataHora, fkComponente) values \n"
                + "(100, 22.5, now(),1),"
                + "(55, 30.25, now(),2),"
                + "(100, 22.5, now(),3),"
                + "(45, 50.0, now(),4),"
                + "(20, 100.0, now(),5),"
                + "(100, 22.0, now(),6);");

        conexao.getConexaoAzure().update("insert into tbAlertas (fkLog, categoria, descrição) values\n"
                + "(1, 'Moderado', '*******'),"
                + "(2, 'Alto', '**********'),"
                + "(3,'Moderado', '********'),"
                + "(4, 'Severo', '********'),"
                + "(5, 'Severo', '*******'),"
                + "(6, 'Moderado', '******');");
        
        List<Componente> listaComponentes = new ArrayList<>();
        List<Componente> listaComponentes2 = new ArrayList<>();
        
//        List<Double> Disco = listaComponentes.forEach(((t) -> {
//            t.limiteAlerta
//        }));

        listaComponentes = conexao.getConexaoAzure().query(
                "select * from tbComponentes where fkMaquina = 1",
                new BeanPropertyRowMapper<>(Componente.class));
        
         listaComponentes2 = conexao.getConexaoAzure().query(
                "select C.nome, C.limiteAlerta, C.fkMaquina from tbComponentes as C join tbMaquinas as M "
                        + "on C.fkMaquina = M.idMaquina where  hostName = 'STFSAOC046893-L'",
                new BeanPropertyRowMapper<>(Componente.class));
        
        
        ModalServices modalServices = new ModalServices();
        
        System.out.println(listaComponentes);
        System.out.println(listaComponentes.get(2).getLimiteAlerta());
        System.out.println(listaComponentes.get(0).getLimiteAlerta());
        System.out.println(listaComponentes.get(0).getidComponentes());
        System.out.println(InetAddress.getLocalHost().getHostName());
        System.out.println(listaComponentes2);
//        System.out.println(modalServices.getDiscoBanco());

    }
}
