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

    public void adicionaNoIndice(int indice, int valor) {
        if (indice < 0 || indice > nroElem) {
            System.out.println("Indice invalido!");
        } else if (nroElem >= vetor.length) {
            System.out.println("Lista cheia");
        } else {
            for (int i = nroElem; i > indice; i--) {
                vetor[i] = vetor[i-1];
            }

            vetor[indice] = valor;
            nroElem++;
        }
    }

    public void ordena() {
        for (int x = 0; x < nroElem-1; x--) {
            for (int y = 1; y < nroElem-1; y++) {
                if (vetor[y-1] > vetor[y]) {
                    int aux = vetor[y-1];
                    vetor[y] = vetor[y-1];
                    vetor[y-1] = aux;
                }
            }
        }
    }

    public int pesquisaBinaria(int valor) {
        int indInf = 0;
        int indSup = nroElem-1;
        int meio;

        while (indInf <= indSup) {
            meio = (indInf + indSup) / 2;

            if (vetor[meio] == valor) {
                return meio;
            } else if (vetor[meio] < valor) {
                indInf = meio + 1;
            } else {
                indSup = meio - 1;
            }
        }

        return -1;
    }
}
