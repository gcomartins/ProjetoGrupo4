package br.com.sptch.aplication.scanner;

import br.com.sptech.aplication.OptionsGui;
import data.cat.banco.ConexaoAzure;
import data.cat.banco.ConexaoMysql;
import data.cat.modal.Componente;
import data.cat.modal.Maquina;
import data.cat.modal.Usuario;
import data.cat.service.AlertasServices;
import data.cat.service.MedidasServices;
import data.cat.service.ModalServices;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.json.JSONObject;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import slack.Slack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author lmmelo1
 */
public class AplicacaoScanner {

    public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {

        MedidasServices medidasServices = new MedidasServices();
        ModalServices modalServices = new ModalServices();
        Double discoBanco = modalServices.getLimiteBanco("Disco");
        Double ramBanco = modalServices.getLimiteBanco("Ram");
        Double processadorBanco = modalServices.getLimiteBanco("Cpu");
        Double limiteAlertaRam = ramBanco;
        Double limiteAlertaCpu = processadorBanco;
        Double limiteAlertaDisco = discoBanco;
        AlertasServices alertas = new AlertasServices();
        String nomeMaquina = InetAddress.getLocalHost().getHostName();
        ConexaoMysql conexaoMysql = new ConexaoMysql();
        ConexaoAzure conexaoazure = new ConexaoAzure();
        List<Componente> listaComponentes = new ArrayList<>();
        List<Usuario> listaUsuarios = new ArrayList<>();
        List<Maquina> listaMaquinas = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Bem vindo ao nosso sistema");
        String email;
        String senha;

        System.out.println("Para fazer seu login nos informe seu email");
        email = sc.nextLine();
        System.out.println("Agora sua Senha");
        senha = sc.nextLine();

        if (email.isEmpty() || senha.isEmpty()) {
            do {
                System.out.println("Email ou senha vazios tente novamente");
                System.out.println("Nos informe seu Email");
                email = sc.nextLine();
                System.out.println("Agora sua Senha ");
                senha = sc.nextLine();
            } while (email.isEmpty() || senha.isEmpty());
        }
        try {
            listaUsuarios = conexaoazure.getConexaoAzure().query(
                    String.format("select * from tbUsuarios where email = '%s'",
                            email),
                    new BeanPropertyRowMapper<>(Usuario.class));

        } catch (DataAccessException e) {

            System.out.println(e.getMessage());
            System.out.println("Não foi possivel conectar ao banco");
        }

        for (Usuario usuario : listaUsuarios) {

            if (usuario.getEmail().equals(email)
                    && usuario.getSenha().equals(senha)) {
                Integer fkEmpresa;
                Integer hostExistente;
                Integer fkMaquina;
                String disco = "Disco";
                String ram = "Ram";
                String cpu = "Cpu";
                listaMaquinas = conexaoazure.getConexaoAzure().query(
                        String.format("select * from tbMaquinas where hostName = '%s'",
                                nomeMaquina),
                        new BeanPropertyRowMapper<>(Maquina.class));
                hostExistente = listaMaquinas.size();

                if (hostExistente == 0) {
                    listaUsuarios = conexaoazure.getConexaoAzure().query(
                            String.format("select * from tbUsuarios where email = '%s'",
                                    email),
                            new BeanPropertyRowMapper<>(Usuario.class));

                    fkEmpresa = listaUsuarios.get(0).getFkEmpresa();

                    conexaoazure.getConexaoAzure().update("insert into tbMaquinas (hostName,fkEmpresa)"
                            + "values(?,?)", nomeMaquina, fkEmpresa);

                    listaMaquinas = conexaoazure.getConexaoAzure().query(
                            String.format("select * from tbMaquinas where hostName = '%s'",
                                    nomeMaquina),
                            new BeanPropertyRowMapper<>(Maquina.class));

                    fkMaquina = listaMaquinas.get(0).getIdMaquina();

                    conexaoazure.getConexaoAzure().update("insert into tbComponentes (nome,fkMaquina) "
                            + "values(?,?);", disco, fkMaquina);
                    conexaoazure.getConexaoAzure().update("insert into tbComponentes (nome,fkMaquina) "
                            + "values(?,?);", ram, fkMaquina);
                    conexaoazure.getConexaoAzure().update("insert into tbComponentes (nome,fkMaquina) "
                            + "values(?,?);", cpu, fkMaquina);
                } else if (hostExistente != 0) {
                    listaComponentes = conexaoazure.getConexaoAzure().query(
                            "select C.nome , C.limiteAlerta from tbComponentes as C join tbMaquinas as M "
                            + "on C.fkMaquina = M.idMaquina where  hostName = '" + nomeMaquina + "'",
                            new BeanPropertyRowMapper<>(Componente.class));

                    for (int i = 0; i < listaComponentes.size(); i++) {
                        if (listaComponentes.get(i).getLimiteAlerta().equals(0)) {
                            System.out.println("Vimos que seus componentes não tem um limite cadastrado");
                            System.out.println("Então vamos começar o cadastro");
                            if (listaComponentes.get(i).getNome().equalsIgnoreCase("Disco")) {
                                System.out.println("Coloque o limite para o Disco");
                                Integer limiteDisco = sc.nextInt();

                                conexaoazure.getConexaoAzure().update(
                                        String.format("update tbComponentes set limiteAlerta = %d were nome = 'Disco'",
                                                limiteDisco));
                            }
                            if (listaComponentes.get(i).getNome().equalsIgnoreCase("Ram")) {
                                System.out.println("Coloque o limite para o Ram");
                                Integer limiteRam = sc.nextInt();

                                conexaoazure.getConexaoAzure().update(
                                        String.format("update tbComponentes set limiteAlerta = %d were nome = 'Ram'",
                                                limiteRam));
                            }
                            if (listaComponentes.get(i).getNome().equalsIgnoreCase("Cpu")) {
                                System.out.println("Coloque o limite para o Processador");
                                Integer limiteCpu = sc.nextInt();

                                conexaoazure.getConexaoAzure().update(
                                        String.format("update tbComponentes set limiteAlerta = %d were nome = 'Cpu'",
                                                limiteCpu));
                            }
                        } else {
                            break;
                        }
                    }

                    //Objeto para envio de alertas ao Slack
                    JSONObject json = new JSONObject();

                    modalServices.inserirComponenteBanco(medidasServices, "Disco");
                    modalServices.inserirComponenteBanco(medidasServices, "Ram");
                    modalServices.inserirComponenteBanco(medidasServices, "Cpu");

                    //DISCO
                    if (medidasServices.getDiscoEmUso() >= (limiteAlertaDisco * 0.75)) {
                        //CRITICO
                        System.out.println("Critico");
                        System.out.println(alertas.inserirAlertas("Crítico", "Disco"));

                        //Envio ao Slack
                        json.put("text", "Máquina:" + nomeMaquina + "\nDisco:\nCritico: " + String.format("%.2f%%", medidasServices.getDiscoEmUso()));
                        Slack.enviarMensagem(json);

                    } else if (medidasServices.getDiscoEmUso() >= (limiteAlertaDisco * 0.5)) {
                        //ALERTA
                        System.out.println("Alerta");
                        System.out.println(alertas.inserirAlertas("Alerta", "Disco"));

                        //Envio ao Slack
                        json.put("text", "Máquina:" + nomeMaquina + "\nDisco:\nAlerta: " + String.format("%.2f%%", medidasServices.getDiscoEmUso()));
                        Slack.enviarMensagem(json);

                    } else if (medidasServices.getDiscoEmUso() >= (limiteAlertaDisco * 0.25)) {
                        System.out.println("Estavel");
                    } else {
                        System.out.println("Perfeito");
                    }

                    //RAM
                    if (medidasServices.getRamEmUso() >= (limiteAlertaRam * 0.75)) {
                        //CRITICO
                        System.out.println("Crítico");
                        System.out.println(alertas.inserirAlertas("Crítico", "Ram"));

                        //Envio ao Slack
                        json.put("text", "Máquina:" + nomeMaquina + "\nRAM:\nCritico: " + String.format("%.2f%%", medidasServices.getRamEmUso()));
                        Slack.enviarMensagem(json);

                    } else if (medidasServices.getRamEmUso() >= (limiteAlertaRam * 0.5)) {
                        //ALERTA
                        System.out.println("Alerta");
                        System.out.println(alertas.inserirAlertas("Alerta", "Ram"));

                        //Envio ao Slack
                        json.put("text", "Máquina:" + nomeMaquina + "\nRAM:\nAlerta: " + String.format("%.2f%%", medidasServices.getRamEmUso()));
                        Slack.enviarMensagem(json);

                    } else if (medidasServices.getRamEmUso() >= (limiteAlertaRam * 0.25)) {
                        System.out.println("Estável");
                    } else {
                        System.out.println("Perfeito");
                    }

                    //CPU
                    if (medidasServices.getProcessadorEmUso() >= (limiteAlertaCpu * 0.75)) {
                        //CRITICO
                        System.out.println("Crítico");
                        alertas.inserirAlertas("Crítico", "Cpu");

                        //Envio ao Slack
                        json.put("text", "Máquina:" + nomeMaquina + "\nCPU:\nCritico: " + String.format("%.2f%%", medidasServices.getProcessadorEmUso()));
                        Slack.enviarMensagem(json);

                    } else if (medidasServices.getProcessadorEmUso() >= (limiteAlertaCpu * 0.5)) {
                        //Alerta
                        System.out.println("Alerta");
                        alertas.inserirAlertas("Alerta", "Cpu");

                        //Envio ao Slack
                        json.put("text", "Máquina:" + nomeMaquina + "\nCPU:\nAlerta: " + String.format("%.2f%%", medidasServices.getProcessadorEmUso()));
                        Slack.enviarMensagem(json);

                    } else if (medidasServices.getProcessadorEmUso() >= (limiteAlertaCpu * 0.25)) {
                        System.out.println("Estável");

                    } else {
                        System.out.println("Perfeito");
                    }

                }
            } else {
                System.out.println(email);
                System.out.println(usuario.getEmail());
                System.out.println(senha);
                System.out.println(usuario.getSenha());
                do {
                    System.out.println("Email ou senha invalidos");
                    System.out.println("Tente novamente");
                    System.out.println("Nos informe seu Email");
                    email = sc.nextLine();
                    System.out.println("Agora sua Senha ");
                    senha = sc.nextLine();
                } while (!usuario.getEmail().equals(email)
                        && usuario.getSenha().equals(senha));
            }
        }
    }
}
