package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(10);

        lista.adiciona(10);
        lista.adiciona(20);

        lista.exibe();

        lista.adiciona(30);
        lista.adiciona(40);

        lista.exibe();

        lista.removePeloIndice(1);
        lista.removeElemento(30);
        lista.exibe();
    }
}