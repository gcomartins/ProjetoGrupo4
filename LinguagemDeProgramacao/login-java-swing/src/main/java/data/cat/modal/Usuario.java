/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.modal;

import java.util.List;

/**
 *
 * @author lmmelo1
 */
public class Usuario {
    
    
    private Integer idUsuario;
    private String nomeUsuario;
    private String sobreNome;
    private String email;
    private String senha;
    private String cargo;
    private Integer fkEmpresa;

    public Usuario() {
        
    }
    

    public Usuario(Integer idUsuario, String nomeUsuario, String sobreNome, String email, String senha, String cargo, Integer fkEmpresa) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.sobreNome = sobreNome;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.fkEmpresa = fkEmpresa;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario + ", sobreNome=" + sobreNome + ", email=" + email + ", senha=" + senha + ", cargo=" + cargo + ", fkEmpresa=" + fkEmpresa + '}';
    }
    
    
    
    
}
