package org.example;

import org.example.PersonagemLivro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //criar objeto repositorio
        Repositorio repositorio = new Repositorio(10);
        ListaObj<PersonagemLivro> lista = new ListaObj<>(5);
        CSV csv = new CSV();

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar um Personagem");
            System.out.println("2 - Exibir Relatório");
            System.out.println("3 - Sair");
            System.out.println("4 - Gravar arquivo .csv");
            System.out.println("5 - Ler arquivo .csv");
            System.out.println("6 - Gravar arquivo .txt");
            System.out.println("7 - Ler arquivo .txt");
            System.out.println("8 - Deletar personagem");
            System.out.println("9 - Desfazer");
            System.out.println("10 - Agendar salvar");
            System.out.println("11 - Executar agendado");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.println("Opção 1 - Adicionar um personagem na lista (cadastro)");

                    System.out.print("Digite o Identificador: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do teclado

                    System.out.print("Digite o Nome do Personagem: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o Nome da Habilidade dele: ");
                    String habilidade = scanner.nextLine();

                    System.out.print("Digite a Força (Exemplo: 10,0): ");
                    double forca = scanner.nextDouble();
                    scanner.nextLine(); // Limpa o buffer do teclado

                    System.out.print("Digite a Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do teclado

                    System.out.print("Digite o Nome do Reino dele: ");
                    String reino = scanner.nextLine();

                    System.out.print("Ele é Protagonista? (Y/N): ");
                    String protagonistaInput = scanner.nextLine();
                    boolean protagonista = protagonistaInput.equalsIgnoreCase("Y");

                    PersonagemLivro personagem = new PersonagemLivro(id, nome, habilidade, forca, idade, reino, protagonista);
                    //lista.adiciona(personagem);
                    repositorio.salvar(personagem);
                    break;
                case 2:
                    System.out.println("Opção 2 - Exibir os personagens cadastrados (relatório)");
                    //exibirPersonagens(lista);
                    repositorio.exibir();
                    break;
                case 3:
                    System.out.println("Opção 3 - Fim do programa (encerrar)");
                    break;
                case 4:
                    if (lista.isEmpty()) {
                        System.out.println("Lista vazia. Não há nada a gravar");
                    } else {
                        csv.gravaArquivoCsv(lista, "personagens");
                        System.out.println("Arquivo .csv gravado com sucesso.");
                    }
                    break;
                case 5:
                    if (lista.isEmpty()) {
                        System.out.println("Lista vazia. Não há nada a gravar");
                    } else {
                        csv.leExibeArquivoCsv("personagens");
                    }
                    break;
                case 6:
                    if (lista.isEmpty()) {
                        System.out.println("Lista vazia. Não há nada a gravar");
                    } else {
                        TXT.gravaArquivoTxt(lista, "personagens");
                        System.out.println("Arquivo .txt gravado com sucesso.");
                    }
                    break;
                case 7:
                    if (lista.isEmpty()) {
                        System.out.println("Lista vazia. Não há nada a gravar");
                    } else {
                        TXT.leArquivoTxt("personagens");
                    }
                    break;
                case 8:
                    System.out.println("Opção 8 - Deletar personagem");
                    System.out.print("Digite o ID do personagem que deseja deletar: ");
                    int idDeletar = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do teclado
                    repositorio.deletar(idDeletar);
                    break;
                case 9:
                    System.out.println("Opção 9 - Desfazer");
                    repositorio.desfazer();
                    break;
                case 10:
                    System.out.println("Opção 10 - Agendar salvar");
                    System.out.print("Digite o Identificador: ");
                    int idAgendar = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do teclado

                    System.out.print("Digite o Nome do Personagem: ");
                    String nomeAgendar = scanner.nextLine();

                    System.out.print("Digite o Nome da Habilidade dele: ");
                    String habilidadeAgendar = scanner.nextLine();

                    System.out.print("Digite a Força (Exemplo: 10,0): ");
                    double forcaAgendar = scanner.nextDouble();

                    System.out.print("Digite a Idade: ");
                    int idadeAgendar = scanner.nextInt();

                    System.out.print("Digite o Nome do Reino dele: ");
                    String reinoAgendar = scanner.nextLine();

                    System.out.print("Ele é Protagonista? (Y/N): ");
                    String protagonistaInputAgendar = scanner.nextLine();

                    boolean protagonistaAgendar = protagonistaInputAgendar.equalsIgnoreCase("Y");

                    PersonagemLivro personagemAgendar = new PersonagemLivro(idAgendar, nomeAgendar, habilidadeAgendar, forcaAgendar, idadeAgendar, reinoAgendar, protagonistaAgendar);
                    repositorio.agendarSalvar(personagemAgendar);
                    break;
                case 11:
                    System.out.println("Opção 11 - Executar agendado");
                    System.out.print("Digite a quantidade de operações agendadas a serem executadas: ");
                    int qtdOperacoes = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do teclado
                    repositorio.executarAgendado(qtdOperacoes);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);

        System.out.println("Programa encerrado.");
    }

    public static void exibirPersonagens(ListaObj<PersonagemLivro> lista) {
        PersonagemLivro[] personagens = new PersonagemLivro[lista.getTamanho()];
        for (int i = 0; i < lista.getTamanho(); i++) {
            personagens[i] = lista.getElemento(i);
        }

        int n = personagens.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (personagens[i - 1].getId() > personagens[i].getId()) {
                    PersonagemLivro temp = personagens[i - 1];
                    personagens[i - 1] = personagens[i];
                    personagens[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);

        System.out.println("\n--- Relatório de Personagens ---");
        System.out.printf("%-6s %-20s %-20s %-10s %-5s %-20s %-12s\n", "CÓDIGO", "Nome", "Habilidade", "Força", "Idade", "Reino", "Protagonista");
        for (PersonagemLivro personagem : personagens) {
            System.out.printf("%06d %-20s %-20s %-10.1f %-5d %-20s %-12s\n",
                    personagem.getId(), personagem.getNome(), personagem.getHabilidade(),
                    personagem.getForca(), personagem.getIdade(), personagem.getReino(),
                    personagem.isProtagonista() ? "Sim" : "Não");
        }
    }

}
