package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PilhaObj<Operacao> pilha = new PilhaObj<>(10);
        FilaObj<Operacao> fila = new FilaObj<>(10);
        Scanner scanner = new Scanner(System.in);

        int contadorDeOperacoes = 0;

        ContaBancaria conta1 = new ContaBancaria(1, 100.0);
        ContaBancaria conta2 = new ContaBancaria(2, 200.0);

        int opcao = 0;
        do {
            System.out.println("\nMenu:");
            System.out.println("1- Debitar valor");
            System.out.println("2- Creditar (Depositar) valor");
            System.out.println("3- Desfazer operação");
            System.out.println("4- Agendar operação");
            System.out.println("5- Executar operações agendadas");
            System.out.println("6- Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Informe o valor a ser debitado: ");
                    Double valorDebito = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Informe o número da conta: ");
                    Integer numeroConta = scanner.nextInt();
                    scanner.nextLine();

                    if (numeroConta == 1) {
                        if (conta1.debitar(valorDebito)) {
                            pilha.push(new Operacao(conta1, "Débito", valorDebito));
                            contadorDeOperacoes++;
                        } else {
                            System.out.println("Saldo insuficiente!");
                        }
                    } else if (numeroConta == 2) {
                        if (conta2.debitar(valorDebito)) {
                            pilha.push(new Operacao(conta2, "Débito", valorDebito));
                            contadorDeOperacoes++;
                        } else {
                            System.out.println("Saldo insuficiente!");
                        }
                    } else {
                        System.out.println("Conta não encontrada!");
                    }

                    break;
                case 2:
                    System.out.print("Informe o valor a ser creditado: ");
                    Double valorCredito = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Informe o número da conta: ");
                    Integer numeroContaCredito = scanner.nextInt();
                    scanner.nextLine();

                    if (numeroContaCredito == 1) {
                        conta1.creditar(valorCredito);
                        pilha.push(new Operacao(conta1, "Crédito", valorCredito));
                        contadorDeOperacoes++;
                    } else if (numeroContaCredito == 2) {
                        conta2.creditar(valorCredito);
                        pilha.push(new Operacao(conta2, "Crédito", valorCredito));
                        contadorDeOperacoes++;
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                case 3:
                    if (contadorDeOperacoes > 0) {
                        Operacao op = pilha.pop();
                        if (op.getTipoOperacao().equals("Débito")) {
                            op.getObjConta().creditar(op.getValor());
                        } else {
                            op.getObjConta().debitar(op.getValor());
                        }
                        contadorDeOperacoes--;
                    } else {
                        System.out.println("Não há operações a serem desfeitas!");
                    }
                    break;
                case 4:
                    System.out.print("Informe o tipo de operação (Débito/Crédito): ");
                    String tipoOperacao = scanner.nextLine();

                    System.out.print("Informe o valor: ");
                    Double valorOperacao = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Informe o número da conta: ");
                    Integer numeroContaOperacao = scanner.nextInt();
                    scanner.nextLine();

                    if (numeroContaOperacao == 1) {
                        fila.insert(new Operacao(conta1, tipoOperacao, valorOperacao));
                    } else if (numeroContaOperacao == 2) {
                        fila.insert(new Operacao(conta2, tipoOperacao, valorOperacao));
                    } else {
                        System.out.println("Conta não encontrada!");
                    }
                    break;
                case 5:
                    if (!fila.isEmpty()) {
                        while (!fila.isEmpty()) {
                            Operacao op = fila.poll();
                            if (op.getTipoOperacao().equals("Débito")) {
                                op.getObjConta().debitar(op.getValor());
                            } else {
                                op.getObjConta().creditar(op.getValor());
                            }
                        }
                    } else {
                        System.out.println("Não há operações agendadas!");
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 6);

            System.out.println("Programa encerrado.");
        }
    }
}