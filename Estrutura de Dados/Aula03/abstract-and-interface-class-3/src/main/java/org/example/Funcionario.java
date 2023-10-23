package org.example;

abstract public class Funcionario {
    protected String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
