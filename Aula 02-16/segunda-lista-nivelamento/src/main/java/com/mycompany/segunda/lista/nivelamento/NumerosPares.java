/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segunda.lista.nivelamento;

/**
 *
 * @author diego
 */
public class NumerosPares {
    public static void main(String[] args) {
        int i = 0;
        
        while (i <= 40) {            
            if(i % 2 == 0){
                System.out.println(i);
            }
            
            i++;
        }
    }
}

// Crie uma classe chamada NumerosImpares que: 
// • Exiba todos os números pares de 0 a 40 usando while