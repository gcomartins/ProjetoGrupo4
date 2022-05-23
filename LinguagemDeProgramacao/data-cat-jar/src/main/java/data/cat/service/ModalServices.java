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

    private Looca looca;  
    private MedidasServices medidasServices;
    

    Timer timer = new Timer();

    public ModalServices() {
        try {
            looca = new Looca();
            medidasServices = new MedidasServices();
            this.idLog = log++;
            this.idMaquina = InetAddress.getLocalHost().getHostAddress();
            this.nomeMaquina = InetAddress.getLocalHost().getHostName();
            this.leituraDesempenhoCpu = medidasServices.getProcessadorEmUso();
            this.leituraDesempenhoRam = medidasServices.getRamEmUso();
            this.leituraDesempenhoDisco = medidasServices.getDiscoEmUso();
        } catch (UnknownHostException ex) {
            Logger.getLogger(ModalServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    ConexaoAzure conexaoAzure = new ConexaoAzure();
//    ConexaoMysql conexaoMysql = new ConexaoMysql();
    Date dataHora = new Date();
    List<Componente> listaComponentes = new ArrayList<>();
    List<Usuario> listaUsuarios = new ArrayList<>();
    List<Maquina> listaMaquinas = new ArrayList<>();

    

    public void inserirComponenteBanco(MedidasServices medidasServices, String componente) {
        int comp = 0;

        listaComponentes = conexaoAzure.getConexaoAzure().query(
                "select C.idComponentes, C.nome, C.limiteAlerta, C.fkMaquina from tbComponentes as C join tbMaquinas as M "
                + "on C.fkMaquina = M.idMaquina where  hostName = '" + nomeMaquina + "'",
                new BeanPropertyRowMapper<>(Componente.class));

        for (int i = 0; i < listaComponentes.size(); i++) {
            if (listaComponentes.get(i).getNome().equalsIgnoreCase(componente)) {
                comp = listaComponentes.get(i).getIdComponentes();
                break;
            }
        }
        
        if (componente.equalsIgnoreCase("Disco")) {
        conexaoAzure.getConexaoAzure().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
                + "values(?, ?, ?)", medidasServices.getDiscoEmUso(), dataHora, comp);    
        }if (componente.equalsIgnoreCase("Ram")) {
        conexaoAzure.getConexaoAzure().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
                + "values(?, ?, ?)", medidasServices.getRamEmUso(), dataHora, comp);    
        }if (componente.equalsIgnoreCase("Cpu")) {
        conexaoAzure.getConexaoAzure().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
                + "values(?, ?, ?)", medidasServices.getProcessadorEmUso(), dataHora, comp);    
        }
        
        
//        conexaoMysql.getConexaoMysql().update("insert into tbLogs(leituraDesempenho, dataHora, fkComponente) "
//                + "values(?, ?, ?)", medidasServices.getDiscoEmUso(), dataHora, comp);      




    }
 
    public Double getLimiteBanco(String componente)
    {
         listaComponentes = conexaoAzure.getConexaoAzure().query(
                "select C.idComponentes, C.nome, C.limiteAlerta, C.fkMaquina from tbComponentes as C join tbMaquinas as M "
                + "on C.fkMaquina = M.idMaquina where  hostName = '" + nomeMaquina + "'",
                new BeanPropertyRowMapper<>(Componente.class));

        Double dado = 0.0;

        for (int i = 0; i < listaComponentes.size(); i++) {
            if (listaComponentes.get(i).getNome().equalsIgnoreCase(componente)) {
                dado = listaComponentes.get(i).getLimiteAlerta();
                return dado;
            }
        }

        return 0.0;
    }
    
//    public boolean cadastroMaquina(ModalServices modalServices, String email, 
//            String hostName){
//        
//        Integer fkEmpresa;
//        String hostExistente;
//        
//        listaMaquinas = conexaoMysql.getConexaoMysql().query(
//                    String.format("select * from tbMaquinas where hostName = '%s'",
//                            hostName),
//                    new BeanPropertyRowMapper<>(Maquina.class));
//        hostExistente = listaMaquinas.get(0).getHostName();
//        
//        if (hostExistente == null) {
//           listaUsuarios = conexaoMysql.getConexaoMysql().query(
//                    String.format("select * from tbUsuarios where email = '%s'",
//                            email),
//                    new BeanPropertyRowMapper<>(Usuario.class)); 
//         
//         fkEmpresa = listaUsuarios.get(0).getFkEmpresa();
//         
//         conexaoMysql.getConexaoMysql().update("insert into tbMaquina (hostName,fkEmpresa)"
//                 + "values(?,?)", hostName, fkEmpresa); 
//         return true;
//         
//        }
//        return false;
//        
//         
//    }
}
