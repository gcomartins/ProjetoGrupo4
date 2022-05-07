/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.modal;

/**
 *
 * @author lmmelo1
 */
public class Maquina {

    private Long idMaquina;
    private String indentPessoal;
    private String hostName;
    private String grupo;
    private Long fkEmpresa;

    public Maquina() {
    }

    public Maquina(Long idMaquina, String indentPessoal, String hostName, String grupo, Long empresa) {
        this.idMaquina = idMaquina;
        this.indentPessoal = indentPessoal;
        this.hostName = hostName;
        this.grupo = grupo;
        this.fkEmpresa = empresa;
    }

    public Long getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Long idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getIndentPessoal() {
        return indentPessoal;
    }

    public void setIndentPessoal(String indentPessoal) {
        this.indentPessoal = indentPessoal;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Long getEmpresa() {
        return fkEmpresa;
    }

    public void setEmpresa(Long empresa) {
        this.fkEmpresa = empresa;
    }

    @Override
    public String toString() {
        return "Maquina{" + "idMaquina=" + idMaquina + ", indentPessoal=" + indentPessoal + ", hostName=" + hostName + ", grupo=" + grupo + ", empresa=" + fkEmpresa + '}';
    }

}
