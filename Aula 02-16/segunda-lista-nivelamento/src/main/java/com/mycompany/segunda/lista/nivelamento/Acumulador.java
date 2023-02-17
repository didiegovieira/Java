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
public class Acumulador {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        Integer number;
        Integer total = 0;
        
        do {
            System.out.println("Digite um número, quando digitar 0 a soma acaba");
            number = read.nextInt();
            total = total + number;
            
        } while (number != 0);
        
        System.out.println(String.format("A soma dos números é: %d", total));
    }
}
