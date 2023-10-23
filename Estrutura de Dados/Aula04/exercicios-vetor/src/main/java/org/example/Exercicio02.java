package org.example;

import java.util.Scanner;

public class Exercicio02 {
    public static void averageCalculation(int[] v){
        System.out.println("\nCalculando a média:\n");
        int media = 0;
        for (int i = 0; i < v.length; i++) {
            media += v[i];
        }

        media = media / 10;
        System.out.println("A média é: " + media + "\nE os números acima dela são:");

        for (int i = 0; i < v.length; i++) {
            if (v[i] > media){
                System.out.println("\n[ " + v[i] + " ]");
            }
        }
    }

    public static void main(String[] args) {
        int[] vetor = new int[10];

        Scanner leitor = new Scanner(System.in);

        System.out.println("Escreva 10 número aleátorios:\n");
        for (int i = 0; i < vetor.length; i++){
            System.out.println("\nDigite o número " + (i+1) + ":");
            vetor[i] = leitor.nextInt();
        }

        averageCalculation(vetor);
    }
}
