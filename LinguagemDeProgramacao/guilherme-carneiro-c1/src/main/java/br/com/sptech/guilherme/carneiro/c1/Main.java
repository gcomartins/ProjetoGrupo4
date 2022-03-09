package br.com.sptech.guilherme.carneiro.c1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        GerenciadorTarefas(0, 0, true);
        
    }
    
    private static void GerenciadorTarefas(Integer tarefas, Integer metaDesenvolvimento, boolean isBool) {
        
        Scanner leitor = new Scanner(System.in);
        if (isBool) {
        System.out.println("===================== BEM-VINDO! =====================");
        System.out.println("+++++++++++++++ QUANTAS TAREFAS ESTÃO PENDENTES? +++++++++++++++");
        tarefas = leitor.nextInt();
        System.out.println("+++++++++++++++ QUAL A META DE DESENVOLVIMENTO? (%) +++++++++++++++");
        metaDesenvolvimento = leitor.nextInt();
        String resposta = String.format("Para atingir a meta, o time precisa fazer %d tarefas", tarefas*metaDesenvolvimento/100);
        System.out.println(resposta);
        }
        
        System.out.println("+++++++++++++++ ESCOLHA OS PRÓXIMOS PASSOS +++++++++++++++");
        System.out.println(" 1- FINALIZAR TAREFAS \n 2- SAIR \n");
        Integer escolha = leitor.nextInt();
        
        switch (escolha) {
            case 1:
                if (tarefas <= 0) {
                    System.out.println("Opção inválida - Não existem mais tarefas pendentes!");
                    GerenciadorTarefas(0, 0, false);
                }else{
                Finalizar(tarefas, metaDesenvolvimento);
                GerenciadorTarefas(tarefas, metaDesenvolvimento, false);
                }
                break;
            case 2:
                System.out.println("Até logo");
                System.exit(0);
                break;
            default:
                System.out.println("Número Inválido");
                GerenciadorTarefas(tarefas, metaDesenvolvimento, false);
                break;
        }
        
    }
     
     private static void Finalizar(Integer tarefas, Integer metaDesenvolvimento){
         Scanner leitor = new Scanner(System.in);
         Integer tarefasRealizadas = 0;
         System.out.println("+++++++++++++++ DIGITE A QUANTIDADE DE TAREFAS FINALIZADAS +++++++++++++++");
         tarefasRealizadas = leitor.nextInt();
         
         if (tarefasRealizadas > tarefas) {
             System.out.println("O time possui uma quantidade menor de tarefas pendentes!");
             System.out.println(String.format("Quantidade atual: %d", tarefas));
             Finalizar(tarefas, metaDesenvolvimento);             
         }else{
         for (int i = 0; i < tarefasRealizadas; i++) {
             System.out.println(String.format("Finalizando tarefa %d", i+1));
         }
         }
         System.out.println(String.format("Você acabou de finalizar %d!\n Quantidade de tarefas pendentes: %d\n Meta de desenvolvimento: %d", tarefasRealizadas, tarefas - tarefasRealizadas, metaDesenvolvimento));
         
         GerenciadorTarefas(tarefas - tarefasRealizadas, metaDesenvolvimento, false);
     }
}
