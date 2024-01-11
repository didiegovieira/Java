package org.example;

public class PilhaObj<T> {

    // Atributos
    private T[] pilha;
    private int topo;

    // Construtor
    public PilhaObj(int capacidade) {
        this.pilha = (T[]) new Object[capacidade];
        topo = -1;
    }

    // Métodos

    // Retorna true se a pilha estiver vazia e false caso contrário
    public Boolean isEmpty() {
        return topo == -1;
    }

    // Retorna true se a pilha estiver cheia e false caso contrário
    public Boolean isFull() {
        if (isEmpty()) {
            return false;
        }

        return pilha.length == topo + 1;
    }

    // Se a pilha estiver cheia, deve lançar IllegalStateException
    // Se a pilha não estiver cheia, empilha info
    public void push(T info) {
        if (isFull()) {
            throw new IllegalStateException("Pilha cheia");
        }
        pilha[++topo] = info;
    }

    // Desempilha e retorna o elemento do topo da pilha
    public T pop() {
        return pilha[topo--];
    }

    // Retorna o elemento do topo da pilha, sem desempilhar
    public T peek() {
        isEmpty();
        return pilha[topo];
    }

    // Exibe o conteúdo da pilha
    public void exibe() {
        for (int i = 0; i <= topo; i++) {
            System.out.println(pilha[i]);
        }
    }

}