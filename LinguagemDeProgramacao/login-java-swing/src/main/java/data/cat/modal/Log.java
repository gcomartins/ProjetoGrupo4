/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.modal;

import java.util.Date;

/**
 *
 * @author lmmelo1
 */
public class Log {

    private Long idLog;
    private Double leituraDesempenho;
    private Date dataHora;
    private Long fkComponente;

    public Log() {
    }

    public Log(Long idLog, Double leituraDesempenho, Date dataHora, Long componente) {
        this.idLog = idLog;
        this.leituraDesempenho = leituraDesempenho;
        this.dataHora = dataHora;
        this.fkComponente = componente;
    }

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
    }

    public Double getLeituraDesempenho() {
        return leituraDesempenho;
    }

    public void setLeituraDesempenho(Double leituraDesempenho) {
        this.leituraDesempenho = leituraDesempenho;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Long getComponente() {
        return fkComponente;
    }

    public void setComponente(Long componente) {
        this.fkComponente = componente;
    }

    @Override
    public String toString() {
        return "Log{" + "idLog=" + idLog + ", leituraDesempenho=" + leituraDesempenho + ", dataHora=" + dataHora + ", componente=" + fkComponente + '}';
    }

}
