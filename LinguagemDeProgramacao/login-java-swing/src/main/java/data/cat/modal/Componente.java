/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.modal;

import data.cat.modal.Maquina;

/**
 *
 * @author lmmelo1
 */
public class Componente {

    private Long idComponente;
    private String nome;
    private Integer capacidade;
    private Integer limiteAlerta;
    private Long fkMaquina;

    public Componente() {
    }

    public Componente(Long idComponente, String nome, Integer capacidade, Integer limiteAlerta, Long maquina) {
        this.idComponente = idComponente;
        this.nome = nome;
        this.capacidade = capacidade;
        this.limiteAlerta = limiteAlerta;
        this.fkMaquina = maquina;
    }

    public Long getIdComponente() {
        return idComponente;
    }

    public void setIdComponente(Long idComponente) {
        this.idComponente = idComponente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Integer getLimiteAlerta() {
        return limiteAlerta;
    }

    public void setLimiteAlerta(Integer limiteAlerta) {
        this.limiteAlerta = limiteAlerta;
    }

    public Long getMaquina() {
        return fkMaquina;
    }

    public void setMaquina(Long maquina) {
        this.fkMaquina = maquina;
    }

    @Override
    public String toString() {
        return "Componente{" + "idComponente=" + idComponente + ", nome=" + nome + ", capacidade=" + capacidade + ", limiteAlerta=" + limiteAlerta + ", maquina=" + fkMaquina + '}';
    }

}
