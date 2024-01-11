package org.example;

public class FilaCircular {
    int tamanho, inicio, fim;
    String[] fila;

    // Construtor - Recebe a capacidade da fila (tamanho total do vetor)
    public FilaCircular(int capacidade) {
        // Cria o vetor para armazenar a fila e inicializa o tamanho
        fila = new String[capacidade];
        tamanho = 0;
        inicio = 0;
        fim = 0;
    }

    // Método isEmpty() - Retorna true se a fila está vazia e false caso contrário
    public boolean isEmpty() {
        if (tamanho == 0) {
            return true;
        }

        return false;
    }

    // Método isFull() - Retorna true se a fila está cheia e false caso contrário
    public boolean isFull() {
        if (tamanho == fila.length) {
            return true;
        }

        return false;
    }

    // Método insert - Recebe informação a ser inserida na fila
    public void insert(String info) {
        if (isFull()) {
            throw new IllegalStateException("Fila cheia");
        }

        fila[fim] = info;
        fim = (fim + 1) % fila.length;
        tamanho++;
    }

    // Método peek() - Retorna o primeiro da fila, sem remover
    public String peek() {
        return fila[inicio];
    }

    // Método poll() - Retorna o primeiro da fila, removendo-o
    public String poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }

        String info = fila[inicio];
        inicio = (inicio + 1) % fila.length;
        tamanho--;
        return info;
    }

    // Método exibe() - exibe os elementos da fila
    public void exibe() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }

        int i = inicio;
        for (int j = 0; j < tamanho; j++) {
            System.out.println(fila[i]);
            i = (i + 1) % fila.length;
        }
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public int getInicio() {
        return this.inicio;
    }

    public int getFim() {
        return this.fim;
    }

    // Cria um vetor e percorre a fila adicionando os elementos no vetor (
    // Retorna o vetor criado e não a fila
    // Esse método é equivalente ao exibe, mas em vez de exibir os elementos da fila na console,
    // copia os elementos da fila para um vetor, na ordem em que seriam exibidos
    public String[] getFila(){
        String[] vetor = new String[tamanho];

        int i = inicio;
        for (int j = 0; j < tamanho; j++) {
            vetor[j] = fila[i];
            i = (i + 1) % fila.length;
        }

        return vetor;
    }
}

