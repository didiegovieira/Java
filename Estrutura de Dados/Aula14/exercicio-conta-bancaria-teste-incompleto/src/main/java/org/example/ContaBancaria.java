package org.example;
public class ContaBancaria {

    // Atributos
    private Integer numero;
    private Double saldo;

    // Construtor
    public ContaBancaria(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    // Métodos

    /* Método debitar - recebe o valor a ser debitado
       Se o valor for inválido, deve lançar IllegalArgumentException
       Se o saldo for insuficiente para o débito, retorna false
       Senão, atualiza o saldo e retorna true
     */
    public Boolean debitar(Double valor){
        if (valor < 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        if (valor > saldo) {
            return false;
        }

        saldo -= valor;
        System.out.println("Debitado: " + valor + "\nSaldo da Conta: " + saldo);
        return true;
    }

    /* Método creditar - recebe o valor a ser depositado
       Se o valor for inválido, deve lançar IllegalArgumentException
       Senão, atualiza o saldo
     */
    public void creditar(Double valor){
        if (valor < 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        saldo += valor;
        System.out.println("Creditado: " + valor + "\nSaldo da Conta: " + saldo);
    }


    /* Método toString() - retorna uma String formatada com o número e o saldo da conta. */
    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }

    // Getters
    public Integer getNumero() {
        return this.numero;
    }

    public Double getSaldo() {
        return this.saldo;
    }

}
