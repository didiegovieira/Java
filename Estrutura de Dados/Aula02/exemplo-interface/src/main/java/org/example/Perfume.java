package org.example;

public class Perfume extends Produto{
    //Atributos
    private String fragrancia;

    //Construtor
    public Perfume(int codigo, String descricao, double preco) {
        super(codigo, descricao, preco);
    }

    //Metodos
    @Override
    public Double getValorTributo() {
        return getPreco() * 0.27;
    }

    @Override
    public String toString() {
        return "Perfume{" +
                "fragancia='" + fragrancia + '\'' +
                "} " + super.toString();
    }
}
