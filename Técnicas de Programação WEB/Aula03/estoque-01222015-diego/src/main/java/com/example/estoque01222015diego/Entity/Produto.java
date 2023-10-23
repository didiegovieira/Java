package com.example.estoque01222015diego.Entity;

public class Produto {
    private String nome;
    private Double preco;
    private Integer qtdEstoque;
    private Double valorTotalEstoque;

    public Produto(){

    }

    public Produto(String nome, Double preco, Integer qtdEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.valorTotalEstoque = this.preco * this.qtdEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Double getValorTotalEstoque() {
        return this.qtdEstoque * this.preco;
    }

    public void setValorTotalEstoque(Double valorTotalEstoque) {
        this.valorTotalEstoque = valorTotalEstoque;
    }
}
