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

    private Integer idLog;
    private Double leituraDesempenho;
    private Date dataHora;
    private Integer fkComponente;

    public Log() {
    }

    public Log(Integer idLog, Double leituraDesempenho, Date dataHora, Integer componente) {
        this.idLog = idLog;
        this.leituraDesempenho = leituraDesempenho;
        this.dataHora = dataHora;
        this.fkComponente = componente;
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
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

    public Integer getComponente() {
        return fkComponente;
    }

    public void setComponente(Integer componente) {
        this.fkComponente = componente;
    }

    @Override
    public String toString() {
        return "Log{" + "idLog=" + idLog + ", leituraDesempenho=" + leituraDesempenho + ", dataHora=" + dataHora + ", componente=" + fkComponente + '}';
    }

}
