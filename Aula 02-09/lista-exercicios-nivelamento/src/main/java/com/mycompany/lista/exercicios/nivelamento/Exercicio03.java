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
public class Exercicio03 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Diga o tempo em minutos que voce "
                + "passou aquecendo: ");
        Integer aquecendo = leitor.nextInt();
        
        System.out.println("Digite o tempo em minutos que voce "
                + "passou fazendo exercicios: ");
        Integer exercicio = leitor.nextInt();

        System.out.println("Digite em minutos o tempo que voce "
                + "passou fazendo musculação: ");
        Integer musculacao = leitor.nextInt();
        
        Integer calculo = (aquecendo * 12) + (exercicio * 20) 
                + (musculacao * 25);
        Integer minutos = aquecendo + exercicio + musculacao;
        
        
        System.out.println("Olá, Jorge. você fez um total de " + minutos 
                + " minutos de exercicio e perdeu cerca de " + calculo 
                + " calorias");
    }
        
}
