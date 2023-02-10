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
public class Exercicio09 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Diga o seu nome: ");
        String nome = leitor.nextLine();
        
        System.out.println("Olá, " + nome + "! Qual o ano de seu nascimento?");
        Integer idade = leitor.nextInt();
        
        System.out.println("Em 2030 você terá " + (2030 - idade) + " anos");
    }
}
