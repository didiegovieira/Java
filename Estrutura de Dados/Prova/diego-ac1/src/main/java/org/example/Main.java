package org.example;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ControleImposto controleImposto = new ControleImposto(new ArrayList<>());

        BrinquedoIngresso brinquedoIngresso = new BrinquedoIngresso(
                1, "montanha russa", 20.0, 2);

        controleImposto.adicionarImposto(brinquedoIngresso);
        System.out.println(controleImposto.getImpostos());
    }
}