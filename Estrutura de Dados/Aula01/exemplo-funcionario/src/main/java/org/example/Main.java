package org.example;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Engenheiro eng = new Engenheiro("47643238855", "Diego", 2000.00);
        Vendedor ven = new Vendedor("47643238855", "Diego", 2000.00, 10.0);
        Horista hor = new Horista("47643238855", "Diego", 160, 20.0);

        System.out.println(eng);
        System.out.println(ven);
        System.out.println(hor);

        Empresa emp = new Empresa(new ArrayList<Funcionario>());

        emp.adicionarFunc(eng);
        emp.adicionarFunc(ven);
        emp.adicionarFunc(hor);

        emp.exibeTodos();

        emp.exibeTotalSalario();

        emp.exibeHoristas();
    }

}