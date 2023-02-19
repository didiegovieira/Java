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
public class Login {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        String loginTest = "";
        String passwordTest = "";
        
        System.out.println("Diga seu nome de usuario e senha: ");
        System.out.println("Login:");
        loginTest = read.nextLine();
        System.out.println("Senha:");
        passwordTest = read.nextLine();
        
        Boolean validation = (loginTest.equals("admin")) && (passwordTest.equals("#SPtech2022"));
        
        if(!validation){
            do {
                System.out.println("Login e/ou Senha inválidos! \ndigite novamente:");
                System.out.println("Login:");
                loginTest = read.nextLine();
                System.out.println("Senha:");
                passwordTest = read.nextLine();
            } while (validation);
        }
        
        System.out.println("Login realizado com sucesso");
    }
}

// Crie uma classe chamada Login que simule a autenticação de um usuário em um sistema:
// • Use como parâmetro de validação o login “admin” e a senha “#SPtech2022” 
// • Solicite o nome de usuário e senha.
// • Exiba: “Login e/ou senha inválidos” caso os valores digitados sejam diferentes e 
// solicite novamente.
// • Caso o usuário digite os campos corretamente, exiba: “Login realizado com sucesso”
