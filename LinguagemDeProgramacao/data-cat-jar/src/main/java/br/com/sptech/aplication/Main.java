package br.com.sptech.aplication;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        Looca looca = new Looca();
        List<Disco> discos = looca.getGrupoDeDiscos().getDiscos();
        
        looca.getProcessador().getNome();
        System.out.println("--------Uso de Memória--------");
        Double memoriaEmUso = looca.getMemoria().getEmUso().doubleValue();
        Double memoriaTotal = looca.getMemoria().getTotal().doubleValue();
        System.out.println(memoriaEmUso*100/memoriaTotal);
        System.out.println("--------Processador Uso--------");
        Double usoProcessador = looca.getProcessador().getUso().doubleValue();
        System.out.println(usoProcessador);
        System.out.println("--------Discos--------");
        discos.forEach(e -> {
            System.out.println(e);
            System.out.println("------------------------");
        });
    }
    
}