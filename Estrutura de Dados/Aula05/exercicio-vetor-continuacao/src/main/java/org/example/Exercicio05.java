package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Exercicio05 {
    public static int rendimento(int[] l) {
        int rendimento = 0;
        int indice = 0;

        for (int i = 0; i < l.length; i++){
            if (l[i] > rendimento) {
                rendimento = l[i];
                indice = i;
            }
        }

        return indice;
    }

    public static void main(String[] args) {
        Scanner leitorTXT = new Scanner(System.in);
        Scanner leitorINT = new Scanner(System.in);

        String[] carro = new String[5];
        int[] litro = new int[5];

        System.out.println("Digite os nomes dos carros!\n");
        for (int i = 0; i < carro.length; i++) {
            System.out.println("O nome do carro "+ (i+1) +":");
            String nomeCarro = leitorTXT.nextLine();
            carro[i] = nomeCarro;
        }

        System.out.println("Digite os litros dos carros!\n");
        for (int i = 0; i < litro.length; i++) {
            System.out.println("Quantos litros o "+ carro[i] +" faz:");
            int litroCarro = leitorINT.nextInt();
            litro[i] = litroCarro;
        }


        String message = "";
        System.out.println("Carros e quantos litros fazem:\n");
        for (int i = 0; i < carro.length; i++) {
            message += carro[i] + " / ";
        }
        System.out.println(message);

        message = "";
        for (int i = 0; i < litro.length; i++) {
            message += litro[i] + " / ";
        }
        System.out.println(message);

        int rendimento = rendimento(litro);
        System.out.println("O carro com o maior rendimento é o: " + carro[rendimento]);
    }
}