package org.example;

import java.util.ArrayList;
import java.util.List;

public class ControleImposto {
    private List<Imposto> impostos;

    public ControleImposto(List<Imposto> impostos) {
        this.impostos = new ArrayList<>();
    }

    public List<Imposto> getImpostos(){
        return impostos;
    }

    public void adicionarImposto(Imposto i){
        impostos.add(i);

        System.out.println("Imposto Adicionado");
    }
}
