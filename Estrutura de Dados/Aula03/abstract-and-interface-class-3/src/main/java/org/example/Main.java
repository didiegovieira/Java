package org.example;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ControleBonus controle = new ControleBonus(new ArrayList<>());

        Professor prof = new Professor("Diego", 20.0, 10.0);
        Coordenador coord = new Coordenador("Zé", 15.0, 10.0);

        controle.add(prof);
        controle.add(coord);

        System.out.println(controle.listar());
        System.out.println(controle.total());


    }
}