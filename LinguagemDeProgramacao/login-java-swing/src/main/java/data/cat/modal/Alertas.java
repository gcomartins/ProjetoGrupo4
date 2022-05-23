/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.modal;

/**
 *
 * @author lmmelo1
 */
public class Alertas {

    private Integer idAlertas;
    private Integer fkLog;
    private String categoria;
    private String Descrição;

    public Alertas() {
    }

    public Alertas(Integer idAlertas, Integer log, String categoria, String Descrição) {
        this.idAlertas = idAlertas;
        this.fkLog = log;
        this.categoria = categoria;
        this.Descrição = Descrição;
    }

    public Integer getIdAlertas() {
        return idAlertas;
    }

    public void setIdAlertas(Integer idAlertas) {
        this.idAlertas = idAlertas;
    }

    public Integer getLog() {
        return fkLog;
    }

    public void setLog(Integer log) {
        this.fkLog = log;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescrição() {
        return Descrição;
    }

    public void setDescrição(String Descrição) {
        this.Descrição = Descrição;
    }

    @Override
    public String toString() {
        return "Alertas{" + "idAlertas=" + idAlertas + ", log=" + fkLog + ", categoria=" + categoria + ", Descri\u00e7\u00e3o=" + Descrição + '}';
    }

}
