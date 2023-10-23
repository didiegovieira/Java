package org.example;

public class App {
    public static void main(String[] args) {
        ListaEstatica lista1 = new ListaEstatica(7);
        lista1.adiciona(10);
        lista1.adiciona(20);
        lista1.adiciona(30);
        lista1.adicionaNoIndice(-1, 111);  // deve dar indice invalido
        lista1.adicionaNoIndice(4, 111);  // deve dar indice invalido
        lista1.adicionaNoIndice(3, 40);  // deve dar certo (exiba para conferir)
        lista1.adicionaNoIndice(0, 5);  // deve dar certo (exiba para conferir)
        lista1.adicionaNoIndice(2, 111);  // deve dar certo (exiba para conferir)
        lista1.exibe();  // deve exibir 5, 10, 111, 20, 30, 40, 111

        ListaEstatica lista2 = new ListaEstatica(10);
        lista2.adiciona(8);
        lista2.adiciona(5);
        lista2.adiciona(4);
        lista2.adiciona(7);
        lista2.adiciona(10);
        lista2.adiciona(2);
        lista2.exibe();
        lista2.ordena();
        lista2.exibe();
    }
}
