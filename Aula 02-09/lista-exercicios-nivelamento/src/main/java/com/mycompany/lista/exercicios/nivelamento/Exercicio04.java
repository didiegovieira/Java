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
public class Exercicio04 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Diga o valor de um produto: ");
        Integer valor = leitor.nextInt();
        
        System.out.println("Digita a quantidade vendida: ");
        Integer quant = leitor.nextInt();
        
        System.out.println("Diga o valor pago pelo cliente: ");
        Integer pago = leitor.nextInt();
        
        System.out.println("Seu troco será de R$ " + (pago - (valor * quant)));
    }
}
