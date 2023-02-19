/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segunda.lista.nivelamento;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author diego
 */
public class Sorteio {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        Integer number;
        
        do {            
            System.out.println("Escreva um número de 1 a 100: ");
            number = read.nextInt();
            
        } while (number < 1 || number > 100);
        
        Integer par = 0;
        Integer impar = 0;
        Integer save = 0;
        
        for (int i = 0; i < 200; i++) {
            Integer random = ThreadLocalRandom.current().nextInt(1, 100);
            
            if (i % 2 == 0){
                par++;
            }else {
                impar++;
            }
            
            if (random == number){
                save = i;
                break;
            }
        }
        
        System.out.println("Seu número foi sorteado pela 1a vez na posiçao: " 
        + save + ".\nForam sorteados " + par + " numeros par.\nForam sorteados "
         + impar + " numeros impar.");
        
        
    }
}

// Crie uma classe chamada Sorteio que: 
// • Solicite um número de 1 a 100 apenas uma vez.
// • Realize 200 sorteios. 
// Ao final, exibir:
// • Quando o número foi sorteado pela 1ª vez (apresente a posição do sorteio)
// • Quantos números pares foram sorteados.
// • Quantos números ímpares foram sorteados