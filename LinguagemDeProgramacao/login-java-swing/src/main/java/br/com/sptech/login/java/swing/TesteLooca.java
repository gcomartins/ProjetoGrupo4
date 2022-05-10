package br.com.sptech.login.java.swing;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.servicos.ServicosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import data.cat.modal.Componente;
import data.cat.modal.TesteLog;
import data.cat.service.ModalServices;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class TesteLooca {

    public static void main(String[] args) throws UnknownHostException {
//        Looca looca = new Looca();
//
//        Sistema sistema = new Sistema();
//        Memoria memoria = new Memoria();
//        Processador processador = new Processador();
//        DiscosGroup discosGroup = new DiscosGroup();
//        ServicosGroup servicosGroup = new ServicosGroup();
//        ProcessosGroup processosGroup = new ProcessosGroup();
//        
//        TesteLog log = new TesteLog();
//        
//        System.out.println(log);

//        System.out.println(discosGroup.getVolumes());

//        TesteLog testeLog = new TesteLog();
//        List<TesteLog> testeLogs = new ArrayList();
//        
//        testeLog.gerarLog(testeLogs);




 ConexaoBanco conexao = new ConexaoBanco();
        List<Componente> listaComponentes = new ArrayList<>();
        List<Componente> listaComponentes2 = new ArrayList<>();
        


        listaComponentes = conexao.getConexao().query(
                "select * from tbComponentes",
                new BeanPropertyRowMapper<>(Componente.class));
        
         listaComponentes2 = conexao.getConexao().query(
                "select C.idComponentes ,C.nome, C.limiteAlerta, C.fkMaquina from "
                        + "tbComponentes as C join tbMaquinas as M "
                        + "on C.fkMaquina = M.idMaquina where  "
                        + "hostName = 'STFSAOC046893-L'",
                new BeanPropertyRowMapper<>(Componente.class));
        
        
        ModalServices modalServices = new ModalServices();
        System.out.println(listaComponentes);
        System.out.println(listaComponentes.get(0).getLimiteAlerta());
        System.out.println(listaComponentes.get(0).getLimiteAlerta());
        System.out.println(listaComponentes.get(0).getidComponentes());
        System.out.println(InetAddress.getLocalHost().getHostName());
        System.out.println(listaComponentes2);
        
        
        System.out.println(modalServices.getDiscoBanco());
        System.out.println(modalServices.getRAMBanco());
        System.out.println(modalServices.getProcessadorBanco());



    }
}
