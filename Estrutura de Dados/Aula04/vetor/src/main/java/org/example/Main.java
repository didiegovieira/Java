package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void exibeVetor(int[] v){
        // Exibir o vetor
        System.out.println("\nValores do vetor:");
        for (int i = 0; i < v.length; i++){
            System.out.println("vetor[" + i + "] = " + v[i]);
        }
    }

    public static void exibeVetor(String[] v){
        // Exibir o vetor
        System.out.println("\nValores do vetor:");
        for (int i = 0; i < v.length; i++){
            System.out.println("vetor[" + i + "] = " + v[i]);
        }
    }

    public static void main(String[] args) {

        // Criação do objeto leitor
        Scanner leitor = new Scanner(System.in);
        Scanner leitor2 = new Scanner(System.in);

        // Declaração e criação de um vetor
        int[] vetor = new int[5];

        // Declaração e criação de um vetor já inicializado com valores
        int[] vet2 = { 120, 23, 32, 230, 2314 };
        exibeVetor(vet2);

        // Declaração e criação de um vetor de String
        String[] vet3 = new String[4];

        // Preencher os valores do vetor
        for (int i = 0; i < vetor.length; i++){
            vetor[i] = i + 1;
        }
        exibeVetor(vetor);

        // Preenchendo o vetor com valores digitados pelo usuário
        for (int i = 0; i < vetor.length; i++){
            System.out.println("Digite o valor de vetor["+i+"]");
            vetor[i] = leitor.nextInt();
        }
        exibeVetor(vetor);

        // Preenchendo o vet3 com valores digitados pelo usuário
        for (int i = 0; i < vet3.length; i++){
            System.out.println("Digite o valor de vetor["+i+"]");
            vet3[i] = leitor2.nextLine();
        }
        exibeVetor(vet3);

    }
}