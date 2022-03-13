/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto.individual;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author vpvergilio
 */
public class BankCase {
        public static void main(String[] args) {
             
             System.out.println("Bank "
                + "\nCase");
             Scanner resposta = new Scanner(System.in);
         for(Integer resposta1 =5;resposta1>=5 || resposta1<=0;){
               System.out.println("Escolha uma das opcao"
                + "\n 1-Calculo de juros do parcelamento"
                + "\n 2-Cadastro"
                + "\n 3-Pagar conta"
                + "\n 4-Sair"
                + "\n Digite o numero correspondente a sua escolha:");
        resposta1 = resposta.nextInt();

        switch (resposta1) {
            case 1:
                System.out.println("\n Preencha os dados para calcularmos seu juros em R$");
                System.out.println("\n Em quantos meses sera parcelado?");
                Double tempo = resposta.nextDouble();
                System.out.println("\n Quanto de taxa de juros sera cobrado em %?");
                Double taxaJuros = resposta.nextDouble();
                System.out.println("\n Qual o valor inteiro que sera parcelado");
                Double valorInteiro = resposta.nextDouble();
                Double juros = taxaJuros / 100;
                Double calculadora = tempo * juros * valorInteiro;
                System.out.println(String.format("\n Voce vai pagar R$%.2f de "
                        + "juros", calculadora));
                resposta1=0;
                break;
            case 2:
 
                Scanner cadastro = new Scanner(System.in);
                System.out.println("Bem vindo ao nosso cadastro.Vamos começar uma parceria juntos!");
                System.out.println("1-Digite o seu nome:");
                String nomeDoUsuario = cadastro.nextLine();
                System.out.println("2-Digite a sua senha(Atenção só senhas numericas são permetidas):");
                Integer senhaDoUsuario = cadastro.nextInt();
                System.out.println("3-vamos confirmar sua senha, basta digitar sua senha novamente");
                Integer confirmarSenha = cadastro.nextInt();
               
                   if (Objects.equals(confirmarSenha, senhaDoUsuario)) {
                        System.out.println(String.format("Parabéns vc agora faz parte da nossa familia!"
                            + "aproveite seus benefícios como cliente do nosso sistema %s"
                                ,nomeDoUsuario));
                    }else{
                       System.out.println("senha incorreta tente novamente mais tarde");
                   }    
                resposta1=0;
                break;
            case 3:
                System.out.println("Qual seu saldo na conta");
                Double banco = resposta.nextDouble();
                Scanner res = new Scanner(System.in);
                for (Integer resposta2 =5;resposta2>=3 || resposta2<=0;) {
                      
                Double contaParaPagarNu = 548.50;
                           System.out.println(String.format("Você tem uma fatura de R$%.2f "
                                   ,contaParaPagarNu));
                System.out.println("Escolha uma das opcao"
                + "\n 1-Pagar conta"
                + "\n 2-Pagar mais tarde"
                + "\n Digite o numero correspondente a sua escolha:");
                resposta2= res.nextInt();
                
                   switch (resposta2) {
                       case 1:
                           Double contaPaga = banco - contaParaPagarNu;
                           if (contaPaga >=0) {
                               System.out.println(String.format("Conta paga com sucesso\n"));
                           }else if (contaPaga <=0){
                               System.out.println(String.format("Sua Faturanãonão pode ser paga "
                                       + "pois seu "
                                       + "saldo é menor que a fatura de R$%.2f, "
                                       + "entre em contato com o gerente de sua agência para fazer um"
                                       + " parcelamento\n"
                                       ,contaParaPagarNu));
                           }
                           resposta1=0;
                           break;
                       case 2:
                           System.err.println("Se você não pagar sera cobrado um juros de 9% ao mês\n");
                         
                           break;
                   }  
                    
                }
                resposta1=0;
                break;
               
            case 4:
                System.out.println("Agradecemos por usar nossos serviços");
                break;
            default:
                break;
        }
         }
    }
}
