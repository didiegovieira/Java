package org.example;

public class PilhaObj<T> {
    private T[] pilha;
    private int topo;

    public PilhaObj(int capacidade) {
        this.pilha = (T[]) new Object[capacidade];
        topo = -1;
    }

    public Boolean isEmpty() {
        return topo == -1;
    }

    public Boolean isFull() {
        if (isEmpty()) {
            return false;
        }

        return pilha.length == topo + 1;
    }

    public void push(T info) {
        if (isFull()) {
            throw new IllegalStateException("Pilha cheia");
        }
        pilha[++topo] = info;
    }

    public T pop() {
        return pilha[topo--];
    }

    public T peek() {
        isEmpty();
        return pilha[topo];
    }

    public void exibe() {
        for (int i = 0; i <= topo; i++) {
            System.out.println(pilha[i]);
        }
    }

    public int getTopo() {
        return topo;
    }
}
