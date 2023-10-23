package org.example;

import java.util.ArrayList;
import java.util.List;

public class ControleBonus {
    private List<Bonus> list;

    public ControleBonus(List<Bonus> list) {
        this.list = new ArrayList<>();
    }

    public List<Bonus> listar() {
        return list;
    }

    public void add (Bonus funcionario){
        list.add(funcionario);
    }

    public double total() {
        double total = 0.0;
        for (Bonus bonus : list){
            total += bonus.getValorBonus();
        }
        return total;
    }
}
