package org.example;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Vendavel> list;

    public Carrinho(List<Vendavel> list) {
        this.list = new ArrayList<>();
    }

    public void adicionarVendavel(Vendavel vendavel){
        list.add(vendavel);
    }

    public double calculaTotalVenda(){
        int total = 0;
        for (Vendavel v : list){
            total += v.getValorVenda();
        }
        return total;
    }

    public void exibeItensCarrinho(){
        for (Vendavel v : list){
            System.out.println(v + "\n");
        }
    }
}
