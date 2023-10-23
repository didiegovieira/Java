package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String[] turma1 = new String[10];
        String[] turma2 = new String[10];
        int cont = 0;
        int cont2 = 0;

        Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Digite o nome do aluno:");
            String nome = leitor.nextLine();
            System.out.println("Digite de qual turma ele é:");
            String turma = leitor.nextLine();

            if (turma.equals("turma1")) {
                turma1[cont++] = nome;
            } else {
                turma2[cont2++] = nome;
            }

        }

        System.out.println("Temos " + cont + " alunos na turma1");
        System.out.println("Temos " + cont2 + " alunos na turma2");

        System.out.println("Alunos na turma1:");
        for (int j = 0; j < cont; j++) {
            System.out.println(turma1[j]);
        }

        System.out.println("Alunos na turma2:");
        for (int j = 0; j < cont2; j++) {
            System.out.println(turma2[j]);
        }


    }
}