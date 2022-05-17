/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.service;

import com.github.britooo.looca.api.core.Looca;
import data.cat.banco.ConexaoBanco;
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
    ConexaoBanco conexao;
    MedidasServices medidaslServices;
    List<Log> logs;

    private String nomeMaquina;

    public AlertasServices() throws UnknownHostException {
        medidaslServices = new MedidasServices();
        conexao = new ConexaoBanco();
        logs = new ArrayList<>();
        nomeMaquina = InetAddress.getLocalHost().getHostName();
    }

    public void inserirAlertas(String categoria, String componente) {

        Integer idLog;

        logs = conexao.getConexao().query(""
                + "select L.idLog, C.nome, C.idComponentes, M.hostName,"
                + " M.idMaquina from[dbo].[tbComponentes]" 
                + " as C  inner join[dbo].[tbLogs] as L" 
                + " on(C.idComponentes = L.fkComponente) inner join[dbo].[tbMaquinas] as M "
                + " on(C.fkMaquina = M.idMaquina) where hostName = '" +nomeMaquina+ "'"
                + " and nome = '" + componente +"' order by idLog desc ",
                new BeanPropertyRowMapper<>(Log.class));
        
        idLog = logs.get(0).getIdLog();

        conexao.getConexao().update("insert into tbAlertas"
                + " (fkLog, categoria, descrição) values(?, ?, '*******')",
                idLog, categoria);
    }

}
