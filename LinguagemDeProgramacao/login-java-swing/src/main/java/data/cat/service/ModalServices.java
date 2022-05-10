/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.service;

import br.com.sptech.login.java.swing.App;
import br.com.sptech.login.java.swing.ConexaoBanco;
import br.com.sptech.login.java.swing.LoginGui;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import data.cat.modal.Componente;
import data.cat.modal.Usuario;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import javax.swing.JOptionPane;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

/**
 *
 * @author lmmelo1
 */
public class ModalServices {

    private Integer idLog;
    private Integer limiteAlertaCpu;
    private Integer limiteAlertaRam;
    private Integer limiteAlertaDisco;
    private Double leituraDesempenhoCpu;
    private Double leituraDesempenhoRam;
    private Double leituraDesempenhoDisco;
    private String idMaquina;
    private String nomeMaquina;

    private static int log = 1;

    Looca looca = new Looca();
    Memoria memoria = new Memoria();
    Processador processador = new Processador();
    DiscosGroup discosGroup = new DiscosGroup();
    ProcessosGroup processosGroup = new ProcessosGroup();
    MedidasServices medidasServices = new MedidasServices();

    Timer timer = new Timer();

    public ModalServices() throws UnknownHostException {
        this.idLog = log++;
        this.idMaquina = InetAddress.getLocalHost().getHostAddress();
        this.nomeMaquina = InetAddress.getLocalHost().getHostName();
        this.limiteAlertaCpu = 80;
        this.limiteAlertaRam = 80;
        this.limiteAlertaDisco = 80;
        this.leituraDesempenhoCpu = medidasServices.getProcessador();
        this.leituraDesempenhoRam = medidasServices.getRam();
        this.leituraDesempenhoDisco = medidasServices.getDiscoEmUso();

    }

    ConexaoBanco conexao = new ConexaoBanco();
    Date dataHora = new Date();
    List<Componente> listaComponentes = new ArrayList<>();
    LoginGui label = new LoginGui();

    public void inserirDisco(MedidasServices medidasServices) {
        conexao.getConexao().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
                + "values(?, ?, 5)", medidasServices.getDiscoEmUso(), dataHora);
    }

    public void inserirRAM(MedidasServices medidasServices) {
        conexao.getConexao().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
                + "values(?, ?, 4)", medidasServices.getRam(), dataHora);
    }

    public void inserirProcessador(MedidasServices medidasServices) {
        conexao.getConexao().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
                + "values(?, ?, 6)", medidasServices.getProcessador(), dataHora);
    }

    public double getDiscoBanco() {

        listaComponentes = conexao.getConexao().query(
                "select C.nome, C.limiteAlerta, C.fkMaquina from tbComponentes as C join tbMaquinas as M "
                + "on C.fkMaquina = M.idMaquina where  hostName = '" + nomeMaquina + "'",
                new BeanPropertyRowMapper<>(Componente.class));

        Double disco = 0.0;

        disco = listaComponentes.get(0).getLimiteAlerta();

        for (int i = 0; i < listaComponentes.size(); i++) {
            if (listaComponentes.get(i).getNome().equalsIgnoreCase("Disco")) {
                 disco = listaComponentes.get(i).getLimiteAlerta();
                 return disco;
            }
        }
        return 0.0;
    }

    public Double getRAMBanco() {

       listaComponentes = conexao.getConexao().query(
                "select C.nome, C.limiteAlerta, C.fkMaquina from tbComponentes as C join tbMaquinas as M "
                + "on C.fkMaquina = M.idMaquina where  hostName = '" + nomeMaquina + "'",
                new BeanPropertyRowMapper<>(Componente.class));

        Double ram = 0.0;

      

        for (int i = 0; i < listaComponentes.size(); i++) {
            if (listaComponentes.get(i).getNome().equalsIgnoreCase("Ram")) {
                 ram = listaComponentes.get(i).getLimiteAlerta();
                 return ram;
            }
        }
        return 0.0;
    }
    
    public Double getProcessadorBanco() {
    
    listaComponentes = conexao.getConexao().query(
                "select C.idComponentes, C.nome, C.limiteAlerta, C.fkMaquina from tbComponentes as C join tbMaquinas as M "
                + "on C.fkMaquina = M.idMaquina where  hostName = '" + nomeMaquina + "'",
                new BeanPropertyRowMapper<>(Componente.class));

        Double processador = 0.0;

      
        for (int i = 0; i < listaComponentes.size(); i++) {
            if (listaComponentes.get(i).getNome().equalsIgnoreCase("cpu")) {
                  processador = listaComponentes.get(i).getLimiteAlerta();
                 return processador;
            }
        }
       
        return 0.0;
}

}
