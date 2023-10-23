package org.example;

abstract public class Produto implements Tributavel{
    //Atributos
    private int codigo;
    private String descricao;
    private double preco;

    //Construtor
    public Produto(int codigo, String descricao, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    //Metodos
    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }

    //getPreco()

    public double getPreco() {
        return preco;
    }
}
