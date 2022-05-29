/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.cat.service;

import com.github.britooo.looca.api.core.Looca;

/**
 *
 * @author lmmelo1
 */
public class MedidasServices {

    Looca looca = new Looca();

    public Double getDiscoEmUso() {

        Double discoDisponivel = looca.getGrupoDeDiscos().getVolumes().stream().findAny().get().getDisponivel().doubleValue();
        Double discoTotal = looca.getGrupoDeDiscos().getVolumes().stream().findAny().get().getTotal().doubleValue();
        Double usoDisco = discoDisponivel * 100 / discoTotal;        

        
        return usoDisco;
    }

    public Double getRamEmUso() {
        Double memoriaEmUso = looca.getMemoria().getEmUso().doubleValue();
        Double memoriaTotal = looca.getMemoria().getTotal().doubleValue();
        Double memoriaUsada = memoriaEmUso * 100 / memoriaTotal;

        return memoriaUsada;
    }

    public Double getProcessadorEmUso() {
        Double usoProcessador = looca.getProcessador().getUso();
        return usoProcessador;
    }

}
