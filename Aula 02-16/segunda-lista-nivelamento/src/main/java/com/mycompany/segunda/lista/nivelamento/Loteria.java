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
public class Loteria {
    public static void main(String[] args) {
        
        Scanner read = new Scanner(System.in);
        
        Integer number;
        
        System.out.println("Digite um número entre 1 e 10");
        number = read.nextInt();
        Integer random = ThreadLocalRandom.current().nextInt(1, 10);
        int i = 0;
        
        if(number < 1 || number > 10) {
            do {
                random = ThreadLocalRandom.current().nextInt(1, 10);
                System.out.println("O número deve estar entre 1 e 10, digite denovo.");
                number = read.nextInt();
            } while (number < 0 || number > 10);
            
            do {
                System.out.println(String.format("O número sorteado foi: %d", random));
                System.out.println("Tente novamente:");
                random = ThreadLocalRandom.current().nextInt(1, 10);
                number = read.nextInt();
                
                i++;
            } while (number != random);
            
        }else {
            do {
                System.out.println(String.format("O número sorteado foi: %d", random));
                System.out.println("Tente novamente:");
                random = ThreadLocalRandom.current().nextInt(1, 10);
                number = read.nextInt();
                
                i++;
            } while (number != random);
        }
        
        if(number <= 3){
            System.out.println("Você é MUITO sortudo");
        } else if(number <= 10){
            System.out.println("Você é sortudo");
        } else {
            System.out.println("É melhor você parar de apostar e ir trabalhar");
        }
    }
}

// Crie uma classe chamada Loteria que:
// • Solicite apenas uma vez número entre 0 e 10 para o usuário.
// • Tente adivinhar o número digitado através de números randômicos.
// • A cada iteração exiba o número sorteado.
// • Quando acontecer o “acerto” se a quantidade de vezes necessárias for:
// Até 3: exiba "Você é MUITO sortudo"
// Entre 4 e 10: exiba "Você é sortudo"
// Mais de 10: exiba "É melhor você parar de apostar e ir trabalhar"