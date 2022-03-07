package br.com.sptech.guilherme.carneiro.g4.adsc;

import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    
    public static void main(String[] args) {
        
        Inicializacao();
    }
    
    private static void Inicializacao() {
        
        Scanner leitor = new Scanner(System.in);
        System.out.println("=======================================");
        System.out.println("++++++++++++++ BOM DIA ++++++++++++++");
        System.out.println("+++++++++ QUAL O SEU NOME? +++++++++");
        String nome = leitor.nextLine();
        
        Inicio(nome, 0.0);
        
    }
    
    private static void Inicio(String nome, Double transferencia) {
        Double saldo = 500 - transferencia;
        Scanner leitor = new Scanner(System.in);
        System.out.println(String.format("===================== OLÁ, %s! =====================", nome));
        System.out.println("+++++++++++ BEM-VINDO AO CAIXA 24 HORAS +++++++++++");
        System.out.println("+++++++++++++++ O QUE VOCÊ DESEJA? +++++++++++++++");
        System.out.println(" 1- TRANSFERIR \n 2- RECEBER \n 3- CONSULTAR SALDO \n 4- SAIR \n");
        Integer escolha = leitor.nextInt();
        
        switch (escolha) {
            case 1:
                Transferir(nome);
                Inicio(nome, 0.0);
                break;
            case 2:
                Receber(nome);
                Inicio(nome, 0.0);
                
                break;
            case 3:
                Consultar(nome, saldo);
                Inicio(nome, 0.0);
                
                break;
            case 4:
                System.out.println("Encerrando...");
                System.exit(0);
                
                break;
            default:
                System.out.println("Escolha inválida! \nReinicando...");
                Inicio(nome, 0.0);
                break;
        }
    }
    
    private static void Transferir(String nome) {
        Scanner leitorTransferencia = new Scanner(System.in);
        System.out.println("===================== TRANSFERIR =====================");
        System.out.println("+++++ PARA QUAL CONTA VOCÊ DESEJA TRANSFERIR? +++++");
        Integer conta = leitorTransferencia.nextInt();
        
        System.out.println("+++++ DIGITE O DIGITO +++++");
        Integer digito = leitorTransferencia.nextInt();
        
        System.out.println("+++++ QUANTO DESEJA TRANSFERIR? +++++");
        Double transferencia = leitorTransferencia.nextDouble();
        
        System.out.println(String.format("%s, VOCÊ DESEJA REALIZAR UMA TRANSFERÊNCIA DE R$%, .2f PARA A CONTA %d - %d? true/false", nome, transferencia, conta, digito));
        Boolean confirmar = leitorTransferencia.nextBoolean();
        
        if (confirmar) {
            System.out.println("Realizando opreção.....");
            System.out.println("Transferência realizada com sucesso!");
            Inicio(nome, transferencia);
        } else {
            System.out.println("Cancelando operação......");
            Inicio(nome, 0.0);
        }
    }
    
    private static void Receber(String nome) {
        Scanner leitorReceber = new Scanner(System.in);
        System.out.println("===================== RECEBER =====================");
        System.out.println("+++++ O QUE VOCÊ DESEJA? +++++");
        System.out.println(" 1- CHAVE PIX ALEATÓRIA \n 2- TRANSFERÊNCIA BANCÁRIA \n 3- SAIR");
        Integer resposta = leitorReceber.nextInt();
        
        switch (resposta) {
            case 1:
                
                Integer chavePix1 = 0;
                Integer chavePix2 = 0;
                for (int i = 0; i < 1000; i++) {
                    chavePix1 += ThreadLocalRandom.current().nextInt(50000000, 100000000);
                    chavePix2 += ThreadLocalRandom.current().nextInt(50000000, 100000000);
                }
                
                System.out.println("===== RECEBA PELA SUA CHAVE PIX =====\n" + chavePix1 + "ABANK" + chavePix2);
                Boolean resposta1 = false;
                while (resposta1 != true) {
                    System.out.println("VOLTAR? true|false");
                    resposta1 = leitorReceber.nextBoolean();
                }
                Inicio(nome, 0.0);
                
                break;
            case 2:
                System.out.println("SUA CONTA: 192929 - 9");
                Boolean resposta2 = false;
                while (resposta2 != true) {
                    System.out.println("VOLTAR? true|false");
                    resposta2 = leitorReceber.nextBoolean();
                }
                Inicio(nome, 0.0);
                break;
            case 3:
                System.out.println("Voltando......");
                Inicio(nome, 0.0);
                break;
            default:
                System.out.println("Escolha inválida! \nReinicando...");
                Receber(nome);
        }
    }
    
    private static void Consultar(String nome, Double saldo) {
        Scanner leitorConsultar = new Scanner(System.in);
        System.out.println("===================== SALDO =====================");
        System.out.println("++++++++++ ENTRANDO... ++++++++++");
        System.out.println("++++++++++ SALDO ++++++++++\nR$" + saldo);
        
        Boolean resposta = false;
        while (resposta != true) {
            System.out.println("VOLTAR? true|false");
            resposta = leitorConsultar.nextBoolean();
        }
        Inicio(nome, 0.0);
    }
}
