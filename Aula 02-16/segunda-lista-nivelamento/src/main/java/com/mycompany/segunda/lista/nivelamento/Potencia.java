/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segunda.lista.nivelamento;

import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Potencia {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        Integer base = 0;
        Integer exponent = 0;
        Integer result = 1;
        
        System.out.println("Digite a base da potencia:");
        base = read.nextInt();
        
        System.out.println("Digite o expoente da potencia:");
        exponent = read.nextInt();
        
        if(base >= 0 && exponent >= 0) {
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
            
            System.out.println("O valor de " + base + " elevado a " + exponent + " é: " + result);
        } else {
            
        }
    }
}

// Crie uma classe chamada Potencia que: 
// • Apresente como resultado o valor de uma potência de uma base qualquer elevada a um 
// expoente qualquer, ou seja, de BE, em que B é o valor da base e E o valor do expoente.
// • Considere apenas a entrada de valores inteiros e positivos.
// • Por exemplo: B = 2 e E = 5.
// • O programa deverá calcular e exibir o valor de 2 elevado a 5 = 32. (Não é para usar 
//métodos que calculam a potência diretamente).