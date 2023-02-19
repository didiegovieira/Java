/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividade01.ac01;

import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Calculadora {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Integer num;
        Integer choice;
        
        do {
            String operator = "";
            
            do {                
                System.out.println("Digite o número correspondente a operação "
                        + "desejada: \n");
                System.out.println("1 - Soma\n" + "2 - Multiplicação\n" + 
                        "3 - Divisão\n" + "4 - Subtração\n" + "5 - Potência\n" +
                        "6 - Resto\n" + "0 - Sair\n");
                choice = read.nextInt();


                switch (choice) {
                    case 0:
                        System.out.println("Até logo!");
                        break;
                    case 1:
                        System.out.println("Você escolheu o operador de Soma!");
                        operator = "+";
                        break;
                    case 2:
                        System.out.println("Você escolheu o operador de Multiplicação!");
                        operator = "*";
                        break;
                    case 3:
                        System.out.println("Você escolheu o operador de Divisão!");
                        operator = "/";
                        break;
                    case 4:
                        System.out.println("Você escolheu o operador de Subtração!");
                        operator = "-";
                        break;
                    case 5:
                        System.out.println("Você escolheu o operador de Potência!");
                        operator = "**";
                        break;
                    case 6:
                        System.out.println("Você escolheu o operador de Resto!");
                        operator = "%";
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente");
                }
            } while (choice < 0 || choice > 6);
            
            if (choice == 0) {
                break;
            }
            
            System.out.println("Digite um número inteiro: ");
            num = read.nextInt();
            Integer result = 1;
            for (int i = 1; i <= 10; i++){
                if (choice == 1){
                    System.out.println(num + " + " + i + " = " + (num + i));
                }else if (choice == 2){
                    System.out.println(num + " * " + i + " = " + (num * i));
                }else if (choice == 3){
                    System.out.println(num + " / " + i + " = " + (num / i));
                }else if (choice == 4){
                    System.out.println(num + " - " + i + " = " + (num - i));
                }else if (choice == 5){
                    System.out.println(num + " ** " + i + " = " + (result *= num));
                }else if (choice == 6){
                    result = num % i;
                    System.out.println(num + " % " + i + " = " + result);
                }
            }
        } while (choice != 0);
    }
}
