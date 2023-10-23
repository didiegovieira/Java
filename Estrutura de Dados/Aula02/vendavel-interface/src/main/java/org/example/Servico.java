package org.example;

public class Servico implements Vendavel{
    private String descricao;
    private int codigo;
    private int quantHoras;
    private double valorHora;

    public Servico(String descricao, int codigo, int quantHoras, double valorHora) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.quantHoras = quantHoras;
        this.valorHora = valorHora;
    }

    @Override
    public Double getValorVenda() {
        double total = quantHoras * valorHora;
        return total;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "descricao='" + descricao + '\'' +
                ", codigo=" + codigo +
                ", quantHoras=" + quantHoras +
                ", valorHora=" + valorHora +
                '}';
    }
}
