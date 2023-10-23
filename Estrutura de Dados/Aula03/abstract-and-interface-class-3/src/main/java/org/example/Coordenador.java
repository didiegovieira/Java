package org.example;

public class Coordenador extends Funcionario implements Bonus{
    private double qtdHoraCoordenador;
    private double valorHoraCoordenacao;

    public Coordenador(String nome, double qtdHoraCoordenador, double valorHoraCoordenacao) {
        super(nome);
        this.qtdHoraCoordenador = qtdHoraCoordenador;
        this.valorHoraCoordenacao = valorHoraCoordenacao;
    }

    @Override
    public double getValorBonus() {
        return qtdHoraCoordenador * valorHoraCoordenacao * 4.5 * 0.2;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "qtdHoraCoordenador=" + qtdHoraCoordenador +
                ", valorHoraCoordenacao=" + valorHoraCoordenacao +
                ", nome='" + nome + '\'' +
                "} " + super.toString();
    }
}
