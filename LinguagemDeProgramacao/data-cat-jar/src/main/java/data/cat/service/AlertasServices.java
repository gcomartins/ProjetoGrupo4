/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.service;

import com.github.britooo.looca.api.core.Looca;
import data.cat.banco.ConexaoAzure;
import data.cat.banco.ConexaoMysql;
import data.cat.modal.Alertas;
import data.cat.modal.Componente;
import data.cat.modal.Log;
import data.cat.modal.LogApp;
import data.cat.modal.Maquina;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author lmmelo1
 */
public class AlertasServices {

    List<Alertas> listaAlertas = new ArrayList<>();
    ConexaoAzure conexaoAzure;
//    ConexaoMysql conexaoMysql;
    MedidasServices medidaslServices;
    List<Log> logs;
    List<Log> logsSql;

    private String nomeMaquina;

    public AlertasServices() throws UnknownHostException {
        medidaslServices = new MedidasServices();
        conexaoAzure = new ConexaoAzure();
//        conexaoMysql = new ConexaoMysql();
        logs = new ArrayList<>();
//        logsSql = new ArrayList<>();
        nomeMaquina = InetAddress.getLocalHost().getHostName();
    }

    public Integer inserirAlertas(String categoria, String componente) {

        Integer idLog;
//        Integer idLogSql;

        logs = conexaoAzure.getConexaoAzure().query(""
                + "select L.idLog, C.nome, C.idComponentes, M.hostName,"
                + " M.idMaquina from[dbo].[tbComponentes]"
                + " as C  inner join[dbo].[tbLogs] as L"
                + " on(C.idComponentes = L.fkComponente) inner join[dbo].[tbMaquinas] as M "
                + " on(C.fkMaquina = M.idMaquina) where hostName = '" + nomeMaquina + "'"
                + " and nome = '" + componente + "' order by idLog desc ",
                new BeanPropertyRowMapper<>(Log.class));

//        logsSql = conexaoMysql.getConexaoMysql().query(""
//                + "select L.idLog, C.nome, C.idComponentes, M.hostName,"
//                + " M.idMaquina from tbComponentes" 
//                + " as C inner join tbLogs as L" 
//                + " on C.idComponentes = L.fkComponente inner join tbMaquinas as M "
//                + " on C.fkMaquina = M.idMaquina  where hostName = '" +nomeMaquina+ "'"
//                + " and nome = '" + componente +"' order by idLog desc ",
//                new BeanPropertyRowMapper<>(Log.class));
        idLog = logs.get(0).getIdLog();
//        idLogSql = logsSql.get(0).getIdLog();

        conexaoAzure.getConexaoAzure().update("insert into tbAlertas"
                + " (fkLog, categoria, descrição) values(?, ?, '*******')",
                idLog, categoria);

//        conexaoMysql.getConexaoMysql().update("insert into tbAlertas"
//                + " (fkLog, categoria, descrição) values(?, ?, '*******')",
//                idLogSql, categoria);
        listaAlertas = conexaoAzure.getConexaoAzure().query("select * from "
                + "tbAlertas",
                new BeanPropertyRowMapper<>(Alertas.class));

        Integer idAlerta = listaAlertas.get(0).getIdAlertas();

        return idAlerta;
    }

}
