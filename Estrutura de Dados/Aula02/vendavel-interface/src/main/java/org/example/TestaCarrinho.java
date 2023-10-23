package org.example;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TestaCarrinho {
    public static void main(String[] args) {
        String choice;
        Integer choiceValue;

        Carrinho carrinho = new Carrinho(new ArrayList<>());
        Scanner console1 = new Scanner(System.in);
        Scanner console2 = new Scanner(System.in);

        do
        {
            System.out.print("Digite uma opção do menu: \n" +
                    "\n1. Adicionar livro,\n" +
                    "2. Adicionar DVD, \n" +
                    "3. Adicionar Serviço, \n" +
                    "4. Exibir itens do carrinho, \n" +
                    "5. Exibir total de venda, \n" +
                    "6. Fim\n");
            choiceValue = console1.nextInt();

            switch(choiceValue) {
                case 1:
                    System.out.println("Vamos cadastrar um livro!\n");
                    System.out.println("Digite o codigo:\n");
                    int codigo = console1.nextInt();
                    System.out.println("Digite o preco:\n");
                    double preco = console1.nextDouble();
                    System.out.println("Digite o nome:\n");
                    String nome = console2.nextLine();
                    System.out.println("Digite o autor:\n");
                    String autor = console2.nextLine();
                    System.out.println("Digite o autor:\n");
                    String isbn = console2.nextLine();

                    Livro livro = new Livro(codigo, preco, nome, autor, isbn);

                    carrinho.adicionarVendavel(livro);

                    System.out.println("Livro adicionado!");
                    break;
                case 2:
                    System.out.println("Vamos cadastrar um DVD!\n");
                    System.out.println("Digite o codigo:\n");
                     codigo = console1.nextInt();
                    System.out.println("Digite o preco:\n");
                     preco = console1.nextDouble();
                    System.out.println("Digite o nome:\n");
                     nome = console2.nextLine();
                    System.out.println("Digite o gravadora:\n");
                     String gravadora = console2.nextLine();

                    DVD dvd = new DVD(codigo, preco, nome, gravadora);

                    carrinho.adicionarVendavel(dvd);

                    System.out.println("Livro adicionado!");
                    break;
                case 3:
                    System.out.println("Vamos cadastrar um Servico!");
                    System.out.println("Digite a descrição:\n");
                    String descricao = console2.nextLine();
                    System.out.println("Digite o codigo:\n");
                    codigo = console1.nextInt();
                    System.out.println("Digite o quantidade de horas:\n");
                    int quantHoras = console1.nextInt();
                    System.out.println("Digite o valor da hora:\n");
                    int valorHora = console1.nextInt();

                    Servico servico = new Servico(descricao, codigo, quantHoras, valorHora);

                    carrinho.adicionarVendavel(servico);

                    System.out.println("Livro adicionado!");
                    break;
                case 4:
                    carrinho.exibeItensCarrinho();
                    break;
                case 5:
                    carrinho.calculaTotalVenda();
                    break;
                default:
                    System.out.println("Obrigado por participar!");
            }
        }
        while (choiceValue != 6);

    }
}