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
public class Exercicio07 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Diga o limite de peso do elevador: ");
        Double limitePeso = leitor.nextDouble();
        
        System.out.println("Diga o limite de pessoas no elevador: ");
        Integer limitePessoa = leitor.nextInt();
        
        System.out.println("Digite o peso da 1ª pessoa: ");
        Integer pessoa1 = leitor.nextInt();
        
        System.out.println("Digite o peso da 2ª pessoa: ");
        Integer pessoa2 = leitor.nextInt();
        
        System.out.println("Digite o peso da 4ª pessoa: ");
        Integer pessoa3 = leitor.nextInt();
        
        System.out.println("Entraram 3 pessoas no elevador, no qual "
                + "cabem " + limitePessoa + " pessoas. \nO peso total no elevador "
                + "é de " + (pessoa1 + pessoa2 + pessoa3) 
                + ", sendo que ele suporta " + limitePeso);
    }
}
