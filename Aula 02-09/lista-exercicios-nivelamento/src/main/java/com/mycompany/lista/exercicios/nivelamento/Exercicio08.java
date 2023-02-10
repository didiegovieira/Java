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
public class Exercicio08 {
    public static void main(String[] args) {
       Scanner leitor = new Scanner(System.in);
       
        System.out.println("Diga o nome do usuario: ");
        String nome = leitor.nextLine();
        
        System.out.println("Diga a primeira nota: ");
        Integer nota1 = leitor.nextInt();
        
        System.out.println("Diga a segunda nota: ");
        Integer nota2 = leitor.nextInt();
        
        Integer media = (nota1 + nota2)/2;
        
        System.out.println("Olá, " + nome + ". Sua média foi de " + media);
    }
}
