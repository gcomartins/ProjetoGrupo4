package data.cat.modal;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import data.cat.service.AlertasServices;
import data.cat.service.MedidasServices;
import data.cat.service.ModalServices;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class LogApp {

    private Integer idLog;
    private Double limiteAlertaCpu;
    private Double limiteAlertaRam;
    private Double limiteAlertaDisco;
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
    AlertasServices alertasServices = new AlertasServices();
    ModalServices modalServices = new ModalServices();
    Timer timer = new Timer();

    public LogApp() throws UnknownHostException {
        this.idLog = log++;
        this.idMaquina = InetAddress.getLocalHost().getHostAddress();
        this.nomeMaquina = InetAddress.getLocalHost().getHostName();
        this.limiteAlertaCpu = modalServices.getLimiteBanco("cpu");
        this.limiteAlertaRam = modalServices.getLimiteBanco("ram");
        this.limiteAlertaDisco = modalServices.getLimiteBanco("disco");
        this.leituraDesempenhoCpu = medidasServices.getProcessadorEmUso();
        this.leituraDesempenhoRam = medidasServices.getRamEmUso();
        this.leituraDesempenhoDisco = medidasServices.getDiscoEmUso();

    }

    public void gerarLog(List<LogApp> testeLogs) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                String caminho = "C:\\Users\\lmmelo1\\Desktop\\log.txt";
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(caminho, true))) {
                    LogApp newTesteLog = new LogApp();
                    testeLogs.add(newTesteLog);

                    for (LogApp testeLog : testeLogs) {
                        bufferedWriter.write(testeLog.toString());
                        bufferedWriter.newLine();
                    }

                    while (!testeLogs.isEmpty()) {
                        testeLogs.remove(testeLogs.get(0));
                    }

                } catch (Exception e) {
                    e.getMessage();
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask, 0, 5000);
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public Double getLimiteAlertaCpu() {
        return limiteAlertaCpu;
    }

    public void setLimiteAlertaCpu(Double limiteAlertaCpu) {
        this.limiteAlertaCpu = limiteAlertaCpu;
    }

    public Double getLimiteAlertaRam() {
        return limiteAlertaRam;
    }

    public void setLimiteAlertaRam(Double limiteAlertaRam) {
        this.limiteAlertaRam = limiteAlertaRam;
    }

    public Double getLimiteAlertaDisco() {
        return limiteAlertaDisco;
    }

    public void setLimiteAlertaDisco(Double limiteAlertaDisco) {
        this.limiteAlertaDisco = limiteAlertaDisco;
    }

    public Double getLeituraDesempenhoCpu() {
        return leituraDesempenhoCpu;
    }

    public void setLeituraDesempenhoCpu(Double leituraDesempenhoCpu) {
        this.leituraDesempenhoCpu = leituraDesempenhoCpu;
    }

    public Double getLeituraDesempenhoRam() {
        return leituraDesempenhoRam;
    }

    public void setLeituraDesempenhoRam(Double leituraDesempenhoRam) {
        this.leituraDesempenhoRam = leituraDesempenhoRam;
    }

    public Double getLeituraDesempenhoDisco() {
        return leituraDesempenhoDisco;
    }

    public void setLeituraDesempenhoDisco(Double leituraDesempenhoDisco) {
        this.leituraDesempenhoDisco = leituraDesempenhoDisco;
    }

    public String getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(String idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    @Override
    public String toString() {

        if (leituraDesempenhoCpu >= limiteAlertaCpu * 0.75
                || leituraDesempenhoDisco >= limiteAlertaDisco * 0.75
                || leituraDesempenhoRam >= limiteAlertaRam * 0.75) {
            
            // Inserir alerta
            alertasServices.inserirAlertas("Critico", idLog);
            
            return String.format("LOG: %d [ID MÁQUINA: %s;"
                    + "\nNOME MÁQUINA: %s;"
                    + "\nLIMITE CPU: %.2f; LEITURA DESEMPENHO CPU: %.2f;"
                    + "\nLIMITE RAM: %.2f; LEITURA DESEMPENHO RAM: %.2f;"
                    + "\nLIMITE DISCO: %.2f; LEITURA DESEMPENHO DISCO: %.2f -> CRÍTICO] ***\n\n",
                    idLog, idMaquina, nomeMaquina, limiteAlertaCpu, leituraDesempenhoCpu, limiteAlertaRam,
                    leituraDesempenhoRam, limiteAlertaDisco, leituraDesempenhoDisco);
        } else if (leituraDesempenhoCpu >= limiteAlertaCpu * 0.5
                || leituraDesempenhoDisco >= limiteAlertaDisco * 0.5
                || leituraDesempenhoRam >= limiteAlertaRam * 0.5) {
            
            // Inserir alerta
            alertasServices.inserirAlertas("Alerta", idLog);
            return String.format("LOG: %d [ID MÁQUINA: %s;"
                    + "\nNOME MÁQUINA: %s;"
                    + "\nLIMITE CPU: %.2f; LEITURA DESEMPENHO CPU: %.2f;"
                    + "\nLIMITE RAM: %.2f; LEITURA DESEMPENHO RAM: %.2f;"
                    + "\nLIMITE DISCO: %.2f; LEITURA DESEMPENHO DISCO: %.2f -> ALERTA] ***\n\n",
                    idLog, idMaquina, nomeMaquina, limiteAlertaCpu, leituraDesempenhoCpu, limiteAlertaRam,
                    leituraDesempenhoRam, limiteAlertaDisco, leituraDesempenhoDisco);
        } else if (leituraDesempenhoCpu >= limiteAlertaCpu * 0.25
                || leituraDesempenhoDisco >= limiteAlertaDisco * 0.25
                || leituraDesempenhoRam >= limiteAlertaRam * 0.25) {
            
            // Inserir alerta
            alertasServices.inserirAlertas("Estavel", idLog);
            return String.format("LOG: %d [ID MÁQUINA: %s;"
                    + "\nNOME MÁQUINA: %s;"
                    + "\nLIMITE CPU: %.2f; LEITURA DESEMPENHO CPU: %.2f;"
                    + "\nLIMITE RAM: %.2f; LEITURA DESEMPENHO RAM: %.2f;"
                    + "\nLIMITE DISCO: %.2f; LEITURA DESEMPENHO DISCO: %.2f -> ESTÁVEL] ***\n\n",
                    idLog, idMaquina, nomeMaquina, limiteAlertaCpu, leituraDesempenhoCpu, limiteAlertaRam,
                    leituraDesempenhoRam, limiteAlertaDisco, leituraDesempenhoDisco);
        }

        return String.format("LOG: %d [ID MÁQUINA: %s;"
                + "\nNOME MÁQUINA: %s;"
                + "\nLIMITE CPU: %.2f; LEITURA DESEMPENHO CPU: %.2f;"
                + "\nLIMITE RAM: %.2f; LEITURA DESEMPENHO RAM: %.2f;"
                + "\nLIMITE DISCO: %.2f; LEITURA DESEMPENHO DISCO: %.2f -> PERFEITO] ***\n\n",
                idLog, idMaquina, nomeMaquina, limiteAlertaCpu, leituraDesempenhoCpu, limiteAlertaRam,
                leituraDesempenhoRam, limiteAlertaDisco, leituraDesempenhoDisco);
    }

}

//    private Integer idLog;
//    private Integer limiteAlertaCpu;
//    private Integer limiteAlertaRam;
//    private Integer limiteAlertaDisco;
//    private Double leituraDesempenhoCpu;
//    private Double leituraDesempenhoRam;
//    private Double leituraDesempenhoDisco;
//    private String idMaquina;
//    private String nomeMaquina;
