package com.mycompany.lista.exercicios.nivelamento;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author maiar
 */
public class Exercicio02 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite quantos filhos de 0 a 3 anos"
                + " voce possui: ");
        Integer filhos01 = leitor.nextInt();
        
        System.out.println("Digite quantos filhos de 4 a 16 anos"
                + " voce possui: ");
        Integer filhos02 = leitor.nextInt();
        
        System.out.println("Digite quantos filhos de 17 a 18 anos"
                + " voce possui: ");
        Integer filhos03 = leitor.nextInt();
        
        // R$25,12 por filhos com menos de 4 anos
        // R$15,88 por filhos entre 4 e 16 anos
        // R$12,44 por filhos entre 17 e 18 anos
        
        System.out.println("Você tem um total de " + (filhos01 + filhos02 
                + filhos03)+ " e vai receber R$" + ((filhos01 * 25.12) 
                + (filhos02 * 15.88) + (filhos03 * 12.44)));
        
    } 
    
}
