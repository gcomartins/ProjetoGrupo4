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

    private int idComponentes;
    private String nome;
    private Double limiteAlerta;
    private int fkMaquina;

    public Componente() {
    }

    public Componente(int idComponentes, String nome, Double limiteAlerta,int IdMaquina) {
        this.idComponentes = idComponentes;
        this.nome = nome;
        this.limiteAlerta = limiteAlerta;
        this.fkMaquina = IdMaquina;
    }

    public int getidComponentes() {
        return idComponentes;
    }

    public void setidComponentes(int idComponentes) {
        this.idComponentes = idComponentes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getLimiteAlerta() {
        return limiteAlerta;
    }

    public void setLimiteAlerta(Double limiteAlerta) {
        this.limiteAlerta = limiteAlerta;
    }

    public int getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(int maquina) {
        this.fkMaquina = maquina;
    }

    @Override
    public String toString() {
        return "Componente{" + "idComponentes=" + idComponentes + ", nome=" + nome + ", limiteAlerta=" + limiteAlerta + ", maquina=" + fkMaquina + '}';
    }

}
