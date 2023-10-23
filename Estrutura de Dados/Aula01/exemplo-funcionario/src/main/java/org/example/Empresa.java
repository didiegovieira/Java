package org.example;

import java.util.ArrayList;
import java.util.List;

public class Empresa{
    private List<Funcionario> funcionarios;

    public Empresa(List<Funcionario> funcionarios) {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFunc(Funcionario f){
        funcionarios.add(f);
    }

    public void exibeTodos() {
        System.out.println(funcionarios);
    }

    public void exibeTotalSalario() {
        Double total = 0.0;
        for (int i = 0 ; i < funcionarios.size(); i++){
            total += funcionarios.get(i).calcSalario();
        }
        System.out.println(total);
    }

    public void exibeHoristas() {
        for (int i =0 ; i < funcionarios.size(); i++){
            if (funcionarios.get(i) instanceof Horista) {
                System.out.println(funcionarios.get(i));
            }
        }
    }
}
