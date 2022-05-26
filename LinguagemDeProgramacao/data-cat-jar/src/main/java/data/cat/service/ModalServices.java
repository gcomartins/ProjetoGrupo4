/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.service;

import data.cat.banco.ConexaoAzure;
import br.com.sptech.aplication.LoginGui;
import br.com.sptech.aplication.OptionsGui;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import data.cat.banco.ConexaoMysql;
import data.cat.modal.Componente;
import data.cat.modal.Maquina;
import data.cat.modal.Usuario;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author lmmelo1
 */
public class ModalServices {

    private String nomeMaquina;

    private static int log = 1;

    private MedidasServices medidasServices;

    Timer timer = new Timer();

    public ModalServices() {
        try {
            medidasServices = new MedidasServices();
            this.nomeMaquina = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ModalServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ConexaoAzure conexaoAzure = new ConexaoAzure();
    ConexaoMysql conexaoMysql = new ConexaoMysql();
    Date dataHora = new Date();
    List<Componente> listaComponentesAzure = new ArrayList<>();
    List<Componente> listaComponentesMysql = new ArrayList<>();
    List<Usuario> listaUsuarios = new ArrayList<>();
    List<Maquina> listaMaquinas = new ArrayList<>();

    public void inserirComponenteBanco(MedidasServices medidasServices, String componente) {
        int comp = 0;
        int compMysql = 0;

        listaComponentesAzure = conexaoAzure.getConexaoAzure().query(
                "select C.idComponentes, C.nome, C.limiteAlerta, C.fkMaquina from tbComponentes as C join tbMaquinas as M "
                + "on C.fkMaquina = M.idMaquina where  hostName = '" + nomeMaquina + "'",
                new BeanPropertyRowMapper<>(Componente.class));

        for (int i = 0; i < listaComponentesAzure.size(); i++) {
            if (listaComponentesAzure.get(i).getNome().equalsIgnoreCase(componente)) {
                comp = listaComponentesAzure.get(i).getIdComponentes();
                break;
            }
        }

        if (componente.equalsIgnoreCase("Disco")) {
            conexaoAzure.getConexaoAzure().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
                    + "values(?, ?, ?)", medidasServices.getDiscoEmUso(), dataHora, comp);
        }
        if (componente.equalsIgnoreCase("Ram")) {
            conexaoAzure.getConexaoAzure().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
                    + "values(?, ?, ?)", medidasServices.getRamEmUso(), dataHora, comp);
        }
        if (componente.equalsIgnoreCase("Cpu")) {
            conexaoAzure.getConexaoAzure().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
                    + "values(?, ?, ?)", medidasServices.getProcessadorEmUso(), dataHora, comp);
        }

        listaComponentesMysql = conexaoMysql.getConexaoMysql().query(
                "select C.idComponentes, C.nome, C.limiteAlerta, C.fkMaquina from tbComponentes as C join tbMaquinas as M "
                + "on C.fkMaquina = M.idMaquina where  hostName = '" + nomeMaquina + "'",
                new BeanPropertyRowMapper<>(Componente.class));

        for (int i = 0; i < listaComponentesMysql.size(); i++) {
            if (listaComponentesMysql.get(i).getNome().equalsIgnoreCase(componente)) {
                compMysql = listaComponentesMysql.get(i).getIdComponentes();
                break;
            }
        }

        if (componente.equalsIgnoreCase("Disco")) {
            conexaoMysql.getConexaoMysql().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
                    + "values(?, ?, ?)", medidasServices.getDiscoEmUso(), dataHora, compMysql);
        }
        if (componente.equalsIgnoreCase("Ram")) {
            conexaoMysql.getConexaoMysql().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
                    + "values(?, ?, ?)", medidasServices.getRamEmUso(), dataHora, compMysql);
        }
        if (componente.equalsIgnoreCase("Cpu")) {
            conexaoMysql.getConexaoMysql().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
                    + "values(?, ?, ?)", medidasServices.getProcessadorEmUso(), dataHora, compMysql);
        }

    }

    public Double getLimiteBanco(String componente) {
        listaComponentesAzure = conexaoAzure.getConexaoAzure().query(
                "select C.idComponentes, C.nome, C.limiteAlerta, C.fkMaquina from tbComponentes as C join tbMaquinas as M "
                + "on C.fkMaquina = M.idMaquina where  hostName = '" + nomeMaquina + "'",
                new BeanPropertyRowMapper<>(Componente.class));

        Double dado = 0.0;

        for (int i = 0; i < listaComponentesAzure.size(); i++) {
            if (listaComponentesAzure.get(i).getNome().equalsIgnoreCase(componente)) {
                dado = listaComponentesAzure.get(i).getLimiteAlerta();
                return dado;
            }
        }

        return 0.0;
    }

    public void cadastroMaquinaAzure(String email) {
        Integer fkEmpresa;
        Integer fkMaquina;
        String disco = "Disco";
        String ram = "Ram";
        String cpu = "Cpu";

        listaUsuarios = conexaoAzure.getConexaoAzure().query(
                String.format("select * from tbUsuarios where email = '%s'",
                        email),
                new BeanPropertyRowMapper<>(Usuario.class));

        fkEmpresa = listaUsuarios.get(0).getFkEmpresa();

        conexaoAzure.getConexaoAzure().update("insert into tbMaquinas (hostName,fkEmpresa)"
                + "values(?,?)", nomeMaquina, fkEmpresa);

        listaMaquinas = conexaoAzure.getConexaoAzure().query(
                String.format("select * from tbMaquinas where hostName = '%s'",
                        nomeMaquina),
                new BeanPropertyRowMapper<>(Maquina.class));

        fkMaquina = listaMaquinas.get(0).getIdMaquina();

        conexaoAzure.getConexaoAzure().update("insert into tbComponentes (nome,fkMaquina) "
                + "values(?,?);", disco, fkMaquina);
        conexaoAzure.getConexaoAzure().update("insert into tbComponentes (nome,fkMaquina) "
                + "values(?,?);", ram, fkMaquina);
        conexaoAzure.getConexaoAzure().update("insert into tbComponentes (nome,fkMaquina) "
                + "values(?,?);", cpu, fkMaquina);
    }

    public void cadastroMysql(String email) {

        Integer fkEmpresa;
        Integer fkMaquina;
        String disco = "Disco";
        String ram = "Ram";
        String cpu = "Cpu";

        listaUsuarios = conexaoAzure.getConexaoAzure().query(
                String.format("select * from tbUsuarios where email = '%s'",
                        email),
                new BeanPropertyRowMapper<>(Usuario.class));

        fkEmpresa = listaUsuarios.get(0).getFkEmpresa();

        conexaoMysql.getConexaoMysql().update("insert into tbMaquinas (hostName,fkEmpresa)"
                + "values(?,?)", nomeMaquina, fkEmpresa);

        listaMaquinas = conexaoMysql.getConexaoMysql().query(
                String.format("select * from tbMaquinas where hostName = '%s'",
                        nomeMaquina),
                new BeanPropertyRowMapper<>(Maquina.class));

        fkMaquina = listaMaquinas.get(0).getIdMaquina();

        conexaoMysql.getConexaoMysql().update("insert into tbComponentes (nome,fkMaquina) "
                + "values(?,?);", disco, fkMaquina);
        conexaoMysql.getConexaoMysql().update("insert into tbComponentes (nome,fkMaquina) "
                + "values(?,?);", ram, fkMaquina);
        conexaoMysql.getConexaoMysql().update("insert into tbComponentes (nome,fkMaquina) "
                + "values(?,?);", cpu, fkMaquina);

    }

}
