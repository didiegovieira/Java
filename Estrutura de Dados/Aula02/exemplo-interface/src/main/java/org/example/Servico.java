package org.example;

public class Servico implements Tributavel{
    //Atributos
    private String descricao;
    private double preco;

    //Construtor
    public Servico(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    //Metodos


    @Override
    public String toString() {
        return "Servico{" +
                "descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }

    @Override
    public Double getValorTributo() {
        return preco * 0.12;
    }
}
