package org.example;

import java.util.ArrayList;

public class Tributo {
    //Atributos
    private ArrayList<Tributavel> list;

    //Construtor
    public Tributo(ArrayList<Tributavel> list) {
        this.list = new ArrayList<>();
    }

    //Metodos
    public void adicionarTributavel(Tributavel t){
        list.add(t);
    }

    public double calculaTotalTributo(){
        double total = 0;
        for (Tributavel t: list){
            total += t.getValorTributo();
        }

        return total;
    }
}
