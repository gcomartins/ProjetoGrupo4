/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.javamaven1;

import java.util.Scanner;

/**
 *
 * @author me
 */
public class OpcaoCalculadora {

    public  Integer calculadora() {
        char operador;
        Double numeroUm, numeroDois, resultado;

        Scanner calcular = new Scanner(System.in);

        System.out.println("Bora calcular!");
        System.out.println("Digite o operador: +, -, *, ou /:");
        operador = calcular.next().charAt(0);

        System.out.println("Digite um número");
        numeroUm = calcular.nextDouble();

        numeroDois = calcular.nextDouble();
        System.out.println("Digite um número");
    
        switch (operador) {

            case '+':
                resultado = numeroUm + numeroDois;
                System.out.println(numeroUm + " + " + numeroDois + " = " + resultado);
                break;

            case '-':
                resultado = numeroUm - numeroDois;
                System.out.println(numeroUm + " - " + numeroDois + " = " + resultado);
                break;

            case '*':
                resultado = numeroUm * numeroDois;
                System.out.println(numeroUm + " * " + numeroDois + " = " + resultado);
                break;

            case '/':
                resultado = numeroUm / numeroDois;
                System.out.println(numeroUm + " / " + numeroDois + " = " + resultado);
                break;

            default:
                System.out.println("Operador inválido!");
                break;
        }
    }
}