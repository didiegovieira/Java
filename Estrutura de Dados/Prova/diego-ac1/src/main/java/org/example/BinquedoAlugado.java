package org.example;

public class BinquedoAlugado extends Brinquedo implements Imposto{

    private Double valorHora;
    private int qtdHoraAlugada;

    public BinquedoAlugado(int codigo, String nome, Double valorHora, int qtdHoraAlugada) {
        super(codigo, nome);
        this.valorHora = valorHora;
        this.qtdHoraAlugada = qtdHoraAlugada;
    }

    @Override
    public Double getRenda() {
        return null;
    }

    @Override
    public Double getValorImposto() {
        return null;
    }
}
