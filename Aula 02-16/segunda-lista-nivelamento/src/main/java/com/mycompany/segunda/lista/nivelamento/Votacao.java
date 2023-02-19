/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.segunda.lista.nivelamento;

import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Votacao {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        Integer mussarela = 0;
        Integer calabresa = 0;
        Integer queijos = 0;
        Integer voto;
        
        for (int i = 0; i < 10; i++){
            System.out.println("Digite o voto do " + i + " aluno.");
            voto = read.nextInt();
            
            switch (voto) {
                case 5:
                    mussarela++;
                    break;
                case 25:
                    calabresa++;
                    break;
                case 50:
                    queijos++;
                    break;
                default:
                    System.out.println("Voto inválido!");
            }
        }
        
        System.out.println("Quantos votos obteve cada valor: ");
        System.out.println("Mussarela: " + mussarela);
        System.out.println("Calabresa: " + calabresa);
        System.out.println("Quatro Queijos: " + queijos);
        
        if (mussarela > calabresa && mussarela > queijos){
            System.out.println("O sabor favorito é Mussarela!");
        }else if (calabresa > mussarela && calabresa > queijos){
            System.out.println("O sabor favorito é Calabresa!");
        }else if (queijos > calabresa && queijos > mussarela){
            System.out.println("O sabor favorito é Quatro Queijos!");
        } else {
            System.out.println("Os sabores empataram!");
        }
    }
}

// Foi feita uma pesquisa para saber qual o sabor de pizza favorito entre os alunos da Faculdade:
// • Para votar no sabor mussarela, deve-se digitar o valor 5.
// • Para votar no sabor calabresa, deve-se digitar o valor 25.
// • Para votar no sabor quatro queijos, deve- se digitar o valor 50. 
// Leia os votos de 10 alunos diferentes (sem usar vetor) e exiba:
// • Quantos votos obteve cada sabor.
// • Qual o sabor favorito segundo a pesquisa