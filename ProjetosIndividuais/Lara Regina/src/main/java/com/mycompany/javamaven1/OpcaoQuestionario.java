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
public class OpcaoQuestionario {

    public String questionario() {

        Scanner leitorTexto = new Scanner(System.in);
        Scanner leitorNumeros = new Scanner(System.in);

        System.err.println("Bem-Vindo ao Questionário");
        System.out.println("Digite seu nome:");
        String nomeDigitado = leitorTexto.nextLine();

        System.out.println("Digite sua idade:");
        Integer idadeDigitada = leitorNumeros.nextInt();

        System.out.println("Digite quantos jogos você já jogou:");
        Integer jogosJogados = leitorNumeros.nextInt();

        System.out.println("Digita sua cor favorita:");
        String corFavorita = leitorTexto.nextLine();

        System.out.println("Digita seu anime preferido:");
        String animalFavorito = leitorTexto.nextLine();

        String frase = String.format("Seu nome é %s, tem %d anos, você já jogou %d jogos, sua cor favorita é %s, seu animal favorito é %s .",
                nomeDigitado, idadeDigitada, jogosJogados, corFavorita, animalFavorito);

        System.out.println(frase);
    }
}
