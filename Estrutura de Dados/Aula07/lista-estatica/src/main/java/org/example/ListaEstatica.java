package org.example;

public class ListaEstatica {
    private Integer[] vetor;
    private Integer nroElem;

    public ListaEstatica(Integer tam) {
        this.vetor = new Integer[tam];
        this.nroElem = 0;
    }

    public void adiciona(Integer num) {
        if (vetor.length == nroElem+1) {
            System.out.println("Vetor cheio!");
        } else {
            vetor[nroElem++] = num;
            System.out.println("Numero adicionado!");
        }

    }

    public void exibe() {
        System.out.println("Elementos dentro da lista:");
        for (int i = 0; i < nroElem; i++){
            System.out.println(vetor[i]);
        }
    }

    public int busca(Integer num) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i] == num) {
                return i;
            }
        }

        return -1;
    }

    public boolean removePeloIndice(Integer indice) {
        if (indice < 0 || indice > nroElem) {
            return false;
        }

        for (int i = indice; i < nroElem-1; i++) {
            vetor[i] = vetor[i+1];
        }

        nroElem--;
        return true;
    }

    public boolean removeElemento(Integer num) {
        int indice = 0;

        for (int i = 0; i < nroElem; i++) {
            if (vetor[i] == num) {
                indice = i;
                for (int j = indice; j < nroElem-1; j++) {
                    vetor[j] = vetor[j+1];
                }

                nroElem--;
                return true;
            }
        }

        return false;
    }

}
