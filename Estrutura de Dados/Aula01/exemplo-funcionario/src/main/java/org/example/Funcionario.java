package org.example;

abstract public class Funcionario{
    // Atributos
    private String cpf;
    private String nome;

    // Construtor

    public Funcionario(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // Metodos
    /* Método abstrato calcSalario */
    public abstract Double calcSalario();

    // Getters and Setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //ToString

    @Override
    public String toString() {
        return "Funcionario{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", salario='" + calcSalario() + '\'' +
                '}';
    }
}
