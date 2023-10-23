package org.example;

public class Professor extends Funcionario implements Bonus{
    private double qtdAulaSemana;
    private double valorAulaSemana;

    public Professor(String nome, double qtdAulaSemana, double valorAulaSemana) {
        super(nome);
        this.qtdAulaSemana = qtdAulaSemana;
        this.valorAulaSemana = valorAulaSemana;
    }


    @Override
    public double getValorBonus() {
        return qtdAulaSemana * valorAulaSemana * 4.5 * 0.15;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "qtdAulaSemana=" + qtdAulaSemana +
                ", valorAulaSemana=" + valorAulaSemana +
                ", nome='" + nome + '\'' +
                "} " + super.toString();
    }
}
