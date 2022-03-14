package br.com.sptech.projeto.individual.leticia;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Batalha {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorNumerico = new Scanner(System.in);
        String nomeTreinador;
        Integer tipoPokemon;
        String pokemonEscolhido = "Planta";
        Integer opcaoMenu;
        Integer moedas = 0;
        Integer vitoria = 0;
        Integer derrota = 0;
        Integer empate = 0;
        Integer nivelVida = 100;
        Integer inimigoSorteado;
        String tipoInimigo = "Planta";

        System.out.println(
                "Bem vindo ao Pokemón!\nAqui você pode escolher um tipo de "
                + "pokemon e batalhar contra alguns inimigos. \n"
                + "Você começa o jogo com 100 pontos de vida:\n"
                + "Se você vencer a batalha, ganha 3 moedas\n"
                + "Se empatar ganha 1 moeda e a vida do seu pokemon cai 10 pontos\n"
                + "Se perder a batalha, a vida de seu pokemon cai 20 pontos.\n"
                + "Mas, você vai ter a oportunidade de comprar mais vida pro seu pokemon"
                + " utilizando as moedas que você ganha"
                + "Mas vamos começar?\n");

        System.out.println("Mas primeiro digite seu nome:");
        nomeTreinador = leitor.nextLine();

        System.out.println("\nEscolha a opção referente o tipo de pokemon que "
                + "você deseja iniciar suas batalhas:");
        System.out.println(
                "1) Planta\n"
                + "2) Fogo\n"
                + "3) Água");
        tipoPokemon = leitorNumerico.nextInt();

        while (tipoPokemon < 1 || tipoPokemon > 3) {
            System.out.println("Ops!! Tipo de pokemon inválido, tente novamente.\n"
                    + "Os números aceitáveis são:\n"
                    + "1) Planta\n"
                    + "2) Fogo\n"
                    + "3) Água");
            tipoPokemon = leitorNumerico.nextInt();
        }

        switch (tipoPokemon) {
            case 1:
                pokemonEscolhido = "Planta";
                break;
            case 2:
                pokemonEscolhido = "Fogo";
                break;
            case 3:
                pokemonEscolhido = "Água";
                break;
        }

        System.out.println(String.format("Bem vindo(a) treinador(a) %s!\n"
                + "Agora que você tem seu companheiro de batalhas do tipo %s.\n\n"
                + "Escolha no menu a opção de 1 a 4, onde:", nomeTreinador, pokemonEscolhido));

        System.out.println(
                "1) Comprar vida\n"
                + "2) Batalhar\n"
                + "3) Avaliação de desempenho\n"
                + "4) Sair do jogo");
        opcaoMenu = leitorNumerico.nextInt();

        while (opcaoMenu < 1 || opcaoMenu > 4) {
            System.out.println("Ops! Opção inválida. Escolha novamente um item do menu de 1 a 4");
            System.out.println(
                    "1) Comprar vida\n"
                    + "2) Batalhar\n"
                    + "3) Avaliação de desempenho\n"
                    + "4) Sair do jogo");
            opcaoMenu = leitorNumerico.nextInt();
        }

        while (opcaoMenu != 4) {
            if (opcaoMenu < 1 || opcaoMenu > 3) {
                System.out.println("Ops! Opção inválida. Escolha novamente um item do menu de 1 a 4");
                System.out.println(
                        "1) Comprar vida\n"
                        + "2) Batalhar\n"
                        + "3) Avaliação de desempenho\n"
                        + "4) Sair do jogo");
                opcaoMenu = leitorNumerico.nextInt();
            } else {

                switch (opcaoMenu) {
                    case 1:
                        if (nivelVida == 100) {
                            System.out.println("Seu nível de vida está no máximo!\n"
                                    + "Batalhe com seu pokemón e depois volte para conseguir "
                                    + "recuperar sua vida");
                            System.out.println("\nEscolha um novo item do menu:");
                            System.out.println(
                                    "1) Comprar vida\n"
                                    + "2) Batalhar\n"
                                    + "3) Avaliação de desempenho\n"
                                    + "4) Sair do jogo");
                            opcaoMenu = leitorNumerico.nextInt();
                        } else {

                            System.out.println(String.format("Seu nível de vida é: %d", nivelVida));
                            System.out.println(String.format("Sua quantidade de moedas é: %d", moedas));

                            System.out.println("\n1 moeda = 10 pontos de vida.\n"
                                    + "A vida do seu pokemon só vai até 100 pontos de vida");
                            System.out.println("Quantas moedas você deseja usar?");
                            Double trocaMoedas = leitorNumerico.nextDouble();

                            Double porcentagemGasto = (trocaMoedas * 100) / moedas.doubleValue();

                            while (trocaMoedas > moedas) {
                                System.out.println("Ops! Quantidades de moedas insuficientes.\n"
                                        + "Quantas moedas que você possui, você deseja usar?");
                                trocaMoedas = leitorNumerico.nextDouble();
                            }

                            while (((trocaMoedas * 10) + nivelVida) > 100) {
                                System.out.println("Ops! Quantidades de moedas excede a quantidade"
                                        + " de pontos de vida máxima.\n"
                                        + "Quantas moedas você deseja usar?");
                                trocaMoedas = leitorNumerico.nextDouble();
                            }

                            nivelVida = nivelVida + (trocaMoedas.intValue() * 10);
                            moedas -= trocaMoedas.intValue();

                            System.out.println(String.format(
                                    "\nVocê pediu para trocar %.0f moedas.\nVocê gastou %.2f" + "%%"
                                    + " das suas moedas para alcançar %d pontos de "
                                    + "vida", trocaMoedas, porcentagemGasto, nivelVida));

                            System.out.println("\nEscolha um novo item do menu:");
                            System.out.println(
                                    "1) Comprar vida\n"
                                    + "2) Batalhar\n"
                                    + "3) Avaliação de desempenho\n"
                                    + "4) Sair do jogo");
                            opcaoMenu = leitorNumerico.nextInt();
                        }
                        break;

                    case 2:
                        if (nivelVida > 10) {
                            inimigoSorteado = ThreadLocalRandom.current().nextInt(1, 4);
                            switch (inimigoSorteado) {
                                case 1:
                                    tipoInimigo = "Planta";
                                    break;
                                case 2:
                                    tipoInimigo = "Fogo";
                                    break;
                                case 3:
                                    tipoInimigo = "Água";
                                    break;
                            }

                            if (tipoInimigo.equals("Planta") && pokemonEscolhido.equals("Planta")
                                    || tipoInimigo.equals("Fogo") && pokemonEscolhido.equals("Fogo")
                                    || tipoInimigo.equals("Água") && pokemonEscolhido.equals("Água")) {
                                moedas++;
                                empate++;
                                nivelVida = nivelVida - 10;
                                System.out.println(String.format("Seu pokemon do tipo %s lutou "
                                        + "contra um pokemon do tipo %s", pokemonEscolhido, tipoInimigo));
                                System.out.println("Olha só!! Você empatou a batalha, por isso seus pontos de vida "
                                        + "só cairam 10 unidades e você conquistou 1 moeda");
                            } else if (tipoInimigo.equals("Planta") && pokemonEscolhido.equals("Fogo")
                                    || tipoInimigo.equals("Fogo") && pokemonEscolhido.equals("Água")
                                    || tipoInimigo.equals("Água") && pokemonEscolhido.equals("Planta")) {
                                moedas = moedas + 3;
                                vitoria++;
                                System.out.println(String.format("Seu pokemon do tipo %s lutou "
                                        + "contra um pokemon do tipo %s", pokemonEscolhido, tipoInimigo));
                                System.out.println("Parabéns!! Você venceu a batalha e conquistou 3 moedas");
                            } else {
                                derrota++;
                                nivelVida = nivelVida - 20;
                                System.out.println(String.format("Seu pokemon do tipo %s lutou "
                                        + "contra um pokemon do tipo %s", pokemonEscolhido, tipoInimigo));
                                System.out.println("Puxa, que pena!! Você perdeu e seus pontos de vida"
                                        + " cairam 20 unidades. Mas tente novamente!");
                            }
                        } else {
                            System.out.println("Ops! A vida do seu pokemon está se esgotando."
                                    + "\nUse suas moedas para comprar pontos de vida e volte a jogar");
                        }

                        System.out.println("\nEscolha um novo item do menu:");
                        System.out.println(
                                "1) Comprar vida\n"
                                + "2) Batalhar\n"
                                + "3) Avaliação de desempenho\n"
                                + "4) Sair do jogo");
                        opcaoMenu = leitorNumerico.nextInt();
                        break;

                    case 3:
                        System.out.println(String.format("Nível de vida: %d", nivelVida));
                        System.out.println(String.format("Quantidade de moedas: %d", moedas));
                        System.out.println(String.format("Quantidade de vitórias: %d", vitoria));
                        System.out.println(String.format("Quantidade de derrotas: %d", derrota));
                        System.out.println(String.format("Quantidade de empates: %d", empate));

                        System.out.println("\nEscolha um novo item do menu:");
                        System.out.println(
                                "1) Comprar vida\n"
                                + "2) Batalhar\n"
                                + "3) Avaliação de desempenho\n"
                                + "4) Sair do jogo");
                        opcaoMenu = leitorNumerico.nextInt();
                        break;
                }
            }
        }

        System.out.println("Obrigada por jogar!");
    }
}
