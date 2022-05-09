package data.cat.modal;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import data.cat.service.MedidasServices;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class TesteLog {
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
    
    public TesteLog() throws UnknownHostException {
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
    
    
    
    public void gerarLog(List<TesteLog> testeLogs) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                String caminho = "C:\\Users\\letic\\Desktop\\log.txt";
                try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(caminho, true))){
                    TesteLog newTesteLog = new TesteLog();
                    testeLogs.add(newTesteLog);
                    
                    for (TesteLog testeLog : testeLogs) {
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

    public Integer getLimiteAlertaCpu() {
        return limiteAlertaCpu;
    }

    public void setLimiteAlertaCpu(Integer limiteAlertaCpu) {
        this.limiteAlertaCpu = limiteAlertaCpu;
    }

    public Integer getLimiteAlertaRam() {
        return limiteAlertaRam;
    }

    public void setLimiteAlertaRam(Integer limiteAlertaRam) {
        this.limiteAlertaRam = limiteAlertaRam;
    }

    public Integer getLimiteAlertaDisco() {
        return limiteAlertaDisco;
    }

    public void setLimiteAlertaDisco(Integer limiteAlertaDisco) {
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
        
        if (leituraDesempenhoCpu >= limiteAlertaCpu * 0.75 ||
                leituraDesempenhoDisco >= limiteAlertaDisco * 0.75 || 
                leituraDesempenhoRam >= limiteAlertaRam * 0.75) {
            return String.format("LOG: %d [ID MÁQUINA: %s;"
                + "\nNOME MÁQUINA: %s;"
                + "\nLIMITE CPU: %d; LEITURA DESEMPENHO CPU: %.2f;"
                + "\nLIMITE RAM: %d; LEITURA DESEMPENHO RAM: %.2f;"
                + "\nLIMITE DISCO: %d; LEITURA DESEMPENHO DISCO: %.2f -> CRÍTICO] ***\n\n", 
                idLog, idMaquina, nomeMaquina, limiteAlertaCpu, leituraDesempenhoCpu, limiteAlertaRam, 
                leituraDesempenhoRam, limiteAlertaDisco, leituraDesempenhoDisco);
        }else if (leituraDesempenhoCpu >= limiteAlertaCpu * 0.5 ||
                leituraDesempenhoDisco >= limiteAlertaDisco * 0.5 || 
                leituraDesempenhoRam >= limiteAlertaRam * 0.5) {
            return String.format("LOG: %d [ID MÁQUINA: %s;"
                + "\nNOME MÁQUINA: %s;"
                + "\nLIMITE CPU: %d; LEITURA DESEMPENHO CPU: %.2f;"
                + "\nLIMITE RAM: %d; LEITURA DESEMPENHO RAM: %.2f;"
                + "\nLIMITE DISCO: %d; LEITURA DESEMPENHO DISCO: %.2f -> ALERTA] ***\n\n", 
                idLog, idMaquina, nomeMaquina, limiteAlertaCpu, leituraDesempenhoCpu, limiteAlertaRam, 
                leituraDesempenhoRam, limiteAlertaDisco, leituraDesempenhoDisco);
        }else if (leituraDesempenhoCpu >= limiteAlertaCpu * 0.25 ||
                leituraDesempenhoDisco >= limiteAlertaDisco * 0.25 || 
                leituraDesempenhoRam >= limiteAlertaRam * 0.25) {
            return String.format("LOG: %d [ID MÁQUINA: %s;"
                + "\nNOME MÁQUINA: %s;"
                + "\nLIMITE CPU: %d; LEITURA DESEMPENHO CPU: %.2f;"
                + "\nLIMITE RAM: %d; LEITURA DESEMPENHO RAM: %.2f;"
                + "\nLIMITE DISCO: %d; LEITURA DESEMPENHO DISCO: %.2f -> ESTÁVEL] ***\n\n", 
                idLog, idMaquina, nomeMaquina, limiteAlertaCpu, leituraDesempenhoCpu, limiteAlertaRam, 
                leituraDesempenhoRam, limiteAlertaDisco, leituraDesempenhoDisco);
        }
        
            return String.format("LOG: %d [ID MÁQUINA: %s;"
                + "\nNOME MÁQUINA: %s;"
                + "\nLIMITE CPU: %d; LEITURA DESEMPENHO CPU: %.2f;"
                + "\nLIMITE RAM: %d; LEITURA DESEMPENHO RAM: %.2f;"
                + "\nLIMITE DISCO: %d; LEITURA DESEMPENHO DISCO: %.2f -> PERFEITO] ***\n\n", 
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