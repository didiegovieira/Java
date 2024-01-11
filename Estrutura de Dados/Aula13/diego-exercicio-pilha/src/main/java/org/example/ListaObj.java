package org.example;

public class ListaObj <T> {

    private T[] vetor;

    private int nroElem;

    public ListaObj(int tamanho) {
        this.vetor = (T[]) new Object[tamanho];
        nroElem = 0;
    }

    public boolean verificaIndex(int indice){
        return indice >= 0 && indice < nroElem;
    }

    public void adiciona(T elemento) {
        if(nroElem == vetor.length){
            System.out.println("Lista está cheia");
            throw new IllegalStateException("Lista está cheia");
        }else{
            vetor[nroElem] = elemento;
            nroElem++;
            System.out.println("elemento adicionado com sucesso");
        }
    }

    public int busca(T elementoBuscado) {
        int indiceEncontrado = -1;
        for (int i = 0; i < nroElem; i++){
            T elemento = vetor[i];
            if(elementoBuscado == elemento){
                indiceEncontrado = i;
                break;
            }
        }
        return indiceEncontrado;
    }

    public boolean removePeloIndice(int indice) {
        if(verificaIndex(indice)){
            for (int i = indice; i < nroElem -1; i++){
                vetor[i] = vetor[i+1];
            }
            nroElem--;
            return true;
        }else{
            return false;
        }
    }

    public boolean removeElemento(T elementoARemover) {
        return removePeloIndice(busca(elementoARemover));
    }

    public int getTamanho() {
        return nroElem;
    }

    public T getElemento(int indice) {
        if(verificaIndex(indice)){
            return vetor[indice];
        }else{
            return null;
        }

    }

    public void limpa() {
        nroElem = 0;
    }

    public void exibe() {
        for (T elementoDaVez : vetor) {
            System.out.println(elementoDaVez);
        }
    }

    public T[] getVetor() {
        return vetor;
    }

    public boolean isEmpty() {
        return nroElem == 0;
    }

}