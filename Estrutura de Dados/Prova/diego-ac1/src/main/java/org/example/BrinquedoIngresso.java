package org.example;

public class BrinquedoIngresso extends Brinquedo implements Imposto{
    private double valorIngresso;
    private int qtdIngressoVendido;

    public BrinquedoIngresso(int codigo, String nome, double valorIngresso, int qtdIngressoVendido) {
        super(codigo, nome);
        this.valorIngresso = valorIngresso;
        this.qtdIngressoVendido = qtdIngressoVendido;
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
