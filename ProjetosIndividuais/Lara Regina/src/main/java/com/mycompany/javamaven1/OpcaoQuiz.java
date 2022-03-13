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
public class OpcaoQuiz {

    public String quiz() {

        Scanner leitor = new Scanner(System.in);

        String perguntaUm = "One Piece";

        System.out.println("Bem-vindo ao quiz de Anime");
        System.out.println("1)Qual anime tem 1000 episódios?");
        String nomeDigitado = leitor.nextLine();
        if (perguntaUm.equalsIgnoreCase(nomeDigitado)) {
            System.out.println("Você acertou " + nomeDigitado + " tem 1000 episódios");
        } else {
            System.out.println("2)Você errou tente novamemte!!");
        }

        String perguntaDois = "Naruto";

        System.out.println("Qual anime tem alguém chamado Sasuke");
        String nomeDigitado = leitor.nextLine();

        if (perguntaDois.equalsIgnoreCase(nomeDigitado)) {
            System.out.println("Você acertou " + nomeDigitado + " tem um personagem com esse nome ");
        } else {
            System.out.println("Você errou tente novamemte!!");
        }

    }

}
