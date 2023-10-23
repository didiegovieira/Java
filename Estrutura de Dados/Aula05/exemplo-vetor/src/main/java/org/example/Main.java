package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /* Método exibeVetor - recebe um vetor de inteiros e
       exibe o seu conteúdo
    */
    public static void exibeVetor(int[] v) {
        for (int i=0; i < v.length; i++) {
            System.out.print("v[" + i + "]=" + v[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {

//        // Criação do objeto leitor
//        Scanner leitor = new Scanner(System.in);
//
//        // Declaração e criação de um vetor de tamanho 5
//        int[] vetor = new int[5];
//
//        // Declaração e criação de um vetor já inicializado com valores
//        int[] vet2 = { 100, 200, 300, 400, 500, 600, 700 };
//
//        // Declaração e criação de um vetor de Strings
//        String[] vet3 = new String[4];
//
//        // Preencher os valores do vetor
//        for (int i=0; i < vetor.length; i++) {
//            vetor[i] = i * 10;
//        }
//
//        // Exibir o vetor
//        System.out.println("Valores do vetor:");
//        exibeVetor(vetor);
//
//        // Outra forma de exibir os dados do vetor
//        System.out.println(Arrays.toString(vetor));
//
//        // Preenchendo o vetor com valores digitados pelo usuário
//        for (int i=0; i < vetor.length; i++) {
//            System.out.println("Digite o valor de vetor["+i+"]");
//            vetor[i] = leitor.nextInt();
//        }
//
//        // Exibir o vetor
//        System.out.println("\nValores do vetor:");
//        exibeVetor(vetor);
//
//        // Exibir o vet2
//        System.out.println("\nValores do vet2:");
//        exibeVetor(vet2);
//
//        // Preenchendo o vet3 com valores digitados pelo usuário
//        for (int i=0; i < vet3.length; i++) {
//            System.out.println("Digite o valor de vet3["+i+"]");
//            vet3[i] = leitor.next();
//        }
//
//        // Exibindo vet3
//        System.out.println("\nValores de vet3:");
//        for (String s : vet3) {
//            System.out.print(s + "\t");
//        }
//        System.out.println();
//
//        //Desafio 1
//        //Exibir a soma dos valores do vetor
//        int soma = 0;
//        for (int i = 0; i < vetor.length; i++) {
//            soma += vetor[i];
//        }
//        System.out.println("Quantidade dos valores somados: " + soma);
//
//        //Desafio 2
//        //Exibir a quantidade de valores pares do vetor
//        int cont = 0;
//        for (int i = 0; i < vetor.length; i++) {
//            if (vetor[i] % 2 == 0) {
//                cont++;
//            }
//        }
//        System.out.println("Quantidade de valores de valores pares: " + cont);

        //Desafio 3
        //Criar um vetor de Strings inicializado com os nomes dos dias da
        //semana: "Domingo", "Segunda", etc
        //Solicitar que o usuario digite um numero de 1 a 7
        //Enqato o usuario nao digitar um valor valido, ficar em loop
        //solicitando novamente
        //Exibir o dia da semana correspondente, sendo 1 para Domingo,
        //2 para Segunda

        String[] semana = new String[]{"Domingo" , "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado"};
        Scanner leitor = new Scanner(System.in);
        boolean bool = true;
        do{
            System.out.print("Digite um número de 1 a 7 e receba um dia da semana: \n");
            int choice = leitor.nextInt();
            if (choice > 0 && choice < 8) bool = false;
            switch (choice) {
                case 1:
                    System.out.println("Primeiro dia da semana: " + semana[0]);
                    break;
                case 2:
                    System.out.println("Segundo dia da semana: " + semana[1]);
                    break;
                case 3:
                    System.out.println("Terceiro dia da semana: " + semana[2]);
                    break;
                case 4:
                    System.out.println("Quarto dia da semana: " + semana[3]);
                    break;
                case 5:
                    System.out.println("Quinto dia da semana: " + semana[4]);
                    break;
                case 6:
                    System.out.println("Sexto dia da semana: " + semana[5]);
                    break;
                case 7:
                    System.out.println("Setimo dia da semana: " + semana[6]);
                    break;
                default:
                    System.out.println("Escolha Invalida!");
                    break;
            }
        }
        while(bool != false);

    }

}