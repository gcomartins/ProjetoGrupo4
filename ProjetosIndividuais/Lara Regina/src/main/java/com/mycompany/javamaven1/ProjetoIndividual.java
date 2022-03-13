/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javamaven1;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author me
 */
public class ProjetoIndividual {

    public static void main(String[] args) {

        OpcaoQuestionario primeiroQuestionario = new OpcaoQuestionario();
        OpcaoCalculadora primeiraCalculadora = new OpcaoCalculadora();
        OpcaoQuiz primeiroQuiz = new OpcaoQuiz();

        Scanner menu = new Scanner(System.in);

        System.out.println("1 - Calculadora");
        System.out.println("2 - Quiz");
        System.out.println("3 - Sobre você");
        System.out.println("4 - Sair");
        System.out.println("Digite aqui");
        Integer opcaoDigitada = menu.nextInt();

        while (!Objects.equals(opcaoDigitada, menu)) {
            System.out.println("Errou :( ... Tente novamente:");
            opcaoDigitada = menu.nextInt();

            switch (opcaoDigitada) {
                case 1:
                    System.out.println(primeiraCalculadora.calculadora());
                    break;
                case 2:
                    System.out.println(primeiroQuiz.quiz());
                    break;
                case 3:
                    System.out.println(primeiroQuestionario.questionario());
                    break;
                case 4:
                    System.out.println("Programa encerrado");
                    break;

            }
        }

    }
}
