package org.example;

import java.util.Scanner;

public class Exercicio01 {
    public static void ascendingOrder(int[] v){
        System.out.println("\nExibindo na ordem crescente:\n");
        for (int i = 0; i < v.length; i++) {
            System.out.println("\n[ " + v[i] + " ]");
        }
    }

    public static void descendingOrder(int[] v){
        System.out.println("\nExibindo na ordem decrescente:\n");
        for (int i = v.length-1; i >= 0; i--) {
            System.out.println("\n[ " + v[i] + " ]");
        }
    }

    public static void main(String[] args) {
        int[] vetor = new int[7];

        Scanner leitor = new Scanner(System.in);

        System.out.println("Escreva 7 número aleátorios:\n");
        for (int i = 0; i < vetor.length; i++){
            System.out.println("\nDigite o número " + (i+1) + ":");
            vetor[i] = leitor.nextInt();
        }

        ascendingOrder(vetor);
        descendingOrder(vetor);
    }
}
