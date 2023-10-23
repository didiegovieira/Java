package org.example;

import java.util.ArrayList;

public class TestaAtributo {
    public static void main(String[] args) {
        Alimento alimento = new Alimento(1,"salgadinho", 20.0, 20);
        Perfume perfume = new Perfume(2,"dior",10.0);
        Servico servico = new Servico("limpar", 15.0);
        Tributo tributo = new Tributo(new ArrayList<>());

        tributo.adicionarTributavel(alimento);
        tributo.adicionarTributavel(perfume);
        tributo.adicionarTributavel(servico);

        System.out.println(tributo.calculaTotalTributo());

    }
}
