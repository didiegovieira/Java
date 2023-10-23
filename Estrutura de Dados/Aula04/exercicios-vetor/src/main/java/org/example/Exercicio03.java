package org.example;

import java.util.Scanner;

public class Exercicio03 {
    public static String searchName(String[] v, String name) {
        for (int i = 0; i < v.length; i++) {
            if (name.equals(v[i])) {
                return "\nNome encontrado!";
            }
        }

        return "\nNome não encontrado!";
    }

    public static void main(String[] args) {
        String[] vetor = new String[10];

        Scanner leitor = new Scanner(System.in);

        System.out.println("Escreva 10 nomes aleátorios:\n");
        for (int i = 0; i < vetor.length; i++){
            System.out.println("\nDigite o nome " + (i+1) + ":");
            vetor[i] = leitor.nextLine();
        }

        System.out.println("\nDigite um nome que queira procurar:");
        String name = leitor.nextLine();
        System.out.println(searchName(vetor, name));

    }
}
