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
public class Exercicio06 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("Digite o salario bruto: ");
        Double salario = leitor.nextDouble();
        
        Double inss = salario * .1;
        Double ir = salario * .2;
        
        System.out.println("Quanto custa a condução diario só de ida?: ");
        Double ida = leitor.nextDouble();
        
        Double desconto = ida * 2 * 22;
        
        System.out.println("Seu salário bruto é R$" + salario 
                + ", tem um total de R$" + desconto + " em descontos "
                + "e receberá um líquido de R$" 
                + ((salario - (inss + ir + desconto))));
        
    }
}
