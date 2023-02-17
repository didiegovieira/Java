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
        
        String login = "admin";
        String password = "#SPtech2022";
        String loginTest = "";
        String passwordTest = "";
        Boolean validation = (loginTest.equals(login)) || (passwordTest.equals(password));
        
        System.out.println("Diga seu nome de usuario e senha: ");
        System.out.println("Login:");
        loginTest = read.nextLine();
        System.out.println("Senha:");
        passwordTest = read.nextLine();
        
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
