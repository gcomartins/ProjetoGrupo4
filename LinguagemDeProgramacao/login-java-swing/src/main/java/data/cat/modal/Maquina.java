package data.cat.modal;

/**
 *
 * @author lmmelo1
 */
public class Maquina {

    private Integer idMaquina;
    private String indentPessoal;
    private String hostName;
    private String grupo;
    private Integer fkEmpresa;

    public Maquina() {
    }

    public Maquina(Integer idMaquina, String indentPessoal, String hostName, String grupo, Integer empresa) {
        this.idMaquina = idMaquina;
        this.indentPessoal = indentPessoal;
        this.hostName = hostName;
        this.grupo = grupo;
        this.fkEmpresa = empresa;
    }

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
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

    public Integer getEmpresa() {
        return fkEmpresa;
    }

    public void setEmpresa(Integer empresa) {
        this.fkEmpresa = empresa;
    }

    @Override
    public String toString() {
        return "Maquina{" + "idMaquina=" + idMaquina + ", indentPessoal=" + indentPessoal + ", hostName=" + hostName + ", grupo=" + grupo + ", empresa=" + fkEmpresa + '}';
    }

}
