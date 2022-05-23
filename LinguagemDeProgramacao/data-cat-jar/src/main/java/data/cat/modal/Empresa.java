/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.modal;

/**
 *
 * @author lmmelo1
 */
public class Empresa {

    private Integer idEmpresa;
    private String nomeEmpresa;
    private String cnpj;
    private String representante;
    private String email;
    private String senha;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa, String nomeEmpresa, String cnpj, String representante, String email, String senha) {
        this.idEmpresa = idEmpresa;
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.representante = representante;
        this.email = email;
        this.senha = senha;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Empresa{" + "idEmpresa=" + idEmpresa + ", nomeEmpresa=" + nomeEmpresa + ", cnpj=" + cnpj + ", representante=" + representante + ", email=" + email + ", senha=" + senha + '}';
    }

}
