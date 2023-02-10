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
public class Exercicio01 {
    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Diga o login: ");
        String login = leitor.nextLine();

        System.out.println("Diga a senha: ");
        Integer senha = leitor.nextInt();
        
        System.out.println("Diga até quantas vezes você quer parar: ");
        Integer vezes = leitor.nextInt();
        System.out.println("Seu login é " + login + " e sua senha é " + senha + 
                ". Você tem " + vezes + " tentativas antes de ser bloqueado");
        
        
    }
}
