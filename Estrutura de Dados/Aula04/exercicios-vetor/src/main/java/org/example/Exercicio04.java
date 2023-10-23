package org.example;

import java.util.Scanner;

public class Exercicio04 {
    public static String searchNum(int[] v, int num) {
        int cont = 0;

        for (int i = 0; i < v.length; i++) {
            if (num == v[i]) {
                cont++;
            }
        }

        if (cont > 0) {
            return "\nO número " + num + " ocorre " + cont + " vezes!";
        }

        return "\nO número " + num + " não ocorre nenhuma vez!";
    }

    public static void main(String[] args) {
        int[] vetor = new int[10];

        Scanner leitor = new Scanner(System.in);

        System.out.println("Escreva 10 número aleátorios:\n");
        for (int i = 0; i < vetor.length; i++){
            System.out.println("\nDigite o número " + (i+1) + ":");
            vetor[i] = leitor.nextInt();
        }

        System.out.println("\nDigite um nome que queira procurar:");
        int num = leitor.nextInt();
        System.out.println(searchNum(vetor, num));
    }
}
