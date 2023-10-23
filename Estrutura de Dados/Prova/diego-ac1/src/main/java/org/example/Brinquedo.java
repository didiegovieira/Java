package org.example;

public abstract class Brinquedo {
    protected int codigo;
    protected String nome;

    public Brinquedo(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public abstract Double getRenda();
}
