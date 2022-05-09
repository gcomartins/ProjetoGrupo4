package br.com.sptech.login.java.swing;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import com.github.britooo.looca.api.group.servicos.ServicosGroup;
import com.github.britooo.looca.api.group.sistema.Sistema;
import data.cat.modal.TesteLog;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

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

        TesteLog testeLog = new TesteLog();
        List<TesteLog> testeLogs = new ArrayList();
        
        testeLog.gerarLog(testeLogs);

    }
}
