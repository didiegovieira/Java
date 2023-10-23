package org.example;

import java.util.Scanner;

public class Exercicio06 {
    public static int calc(int mes, int dia){
        int soma = 0;
        switch(mes) {
            case 1: // 31
                soma = dia;
                break;
            case 2: // 28
                soma = dia + 31;
                break;
            case 3: // 31
                soma = dia + 59;
                break;
            case 4: // 30
                soma = dia + 90;
                break;
            case 5: // 31
                soma = dia + 120;
                break;
            case 6:// 30
                soma = dia + 151;
                break;
            case 7: // 31
                soma = dia + 181;
                break;
            case 8: // 31
                soma = dia + 212;
                break;
            case 9: // 30
                soma = dia + 243;
                break;
            case 10: // 31
                soma = dia + 273;
                break;
            case 11: // 30
                soma = dia + 304;
                break;
            case 12: // 31
                soma = dia + 334;
                break;
            default:
                System.out.println("Errou o mês");
                break;
        }

        return soma;
    }

    public static boolean validate(int mes, int dia) {
        if (mes == 2 && dia > 28) {
            return false;
        }

        if (mes == 4 || mes == 6 || mes == 9 || mes == 11 && (dia > 30)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        int[] mes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        System.out.println("Digite um número do dia de 1 a 31");
        int diaDigitado = leitor.nextInt();
        System.out.println("Digite um mês de 1 a 12");
        int mesDigitado = leitor.nextInt();

        int result = diaDigitado;
        if (validate(mesDigitado, diaDigitado)) {
            for (int i = 0; i < mesDigitado-1; i++) {
                result += mes[i];
            }
        }

        System.out.println("O dia " + diaDigitado + "/" + mesDigitado + " corresponde ao dia " + result + " do ano.");
    }

}
