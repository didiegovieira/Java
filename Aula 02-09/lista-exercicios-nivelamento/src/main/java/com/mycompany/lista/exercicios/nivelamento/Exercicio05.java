/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lista.exercicios.nivelamento;

import java.util.Scanner;

/**
 *
 * @author maiar
 */
public class Exercicio05 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Diga um numero: ");
        Integer numero1 = leitor.nextInt();
        
        System.out.println("Diga outro numero: ");
        Integer numero2 = leitor.nextInt();
        
        System.out.println(" Resultado da soma: " + (numero1 + numero2) 
                + "\n Resultado da subtração: " + (numero1 - numero2) 
                + "\n Resultado da multiplicação: " + (numero1 * numero2) 
                + "\n Resultado da divisão: " + (numero1 / numero2));
    }
}
