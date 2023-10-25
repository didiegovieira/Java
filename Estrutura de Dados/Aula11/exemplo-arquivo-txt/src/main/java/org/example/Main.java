package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Aluno> lista = new ArrayList<>();

        lista.add(new Aluno("123", "João", "ADS", "POO", 8.0, 10));
        lista.add(new Aluno("456", "Maria", "ADS", "POO", 7.0, 5));
        lista.add(new Aluno("789", "José", "ADS", "POO", 6.0, 0));
        lista.add(new Aluno("101", "Ana", "ADS", "POO", 5.0, 15));
        lista.add(new Aluno("112", "Carlos", "ADS", "POO", 4.0, 20));

        //  Exibe a lista de alunos
        System.out.println("Lista original:");
        for (Aluno aluno : lista) {
            System.out.println(aluno);
        }

        //gravaArquivoTxt(lista, "alunos.txt");

        leArquivoTxt("alunos.txt");
    }

    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        //  Bloco try-catch para abrir o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: ");
        }

        //  Bloco try-catch para gravar o registro e fechar o arquivo
        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo: ");
        }
    }

    public static void gravaArquivoTxt(List<Aluno> lista, String nomeArq) {
        int contRegDadosGravados = 0;

        //  Monta o registro de header
        String header = "00NOTA20232";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        //  Grava o header no arquivo
        gravaRegistro(header, nomeArq);

        //  Monta e grava os registros de dados (registros de corpo)
        for (Aluno aluno : lista) {
            String corpo = "02";
            corpo += String.format("%-5.3s", aluno.getCurso());
            corpo += String.format("%-8.8s", aluno.getRa());
            corpo += String.format("%-50.50s", aluno.getNome());
            corpo += String.format("%-40.40s", aluno.getDisciplina());
            corpo += String.format("%05.2f", aluno.getMedia());
            corpo += String.format("%03d", aluno.getQtdFaltas());

            //  Grava o registro de corpo no arquivo
            gravaRegistro(corpo, nomeArq);
            //  Contabiliza a quantidade de reg de dados gravados
            contRegDadosGravados++;
        }

        //  Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%010d", contRegDadosGravados);
        gravaRegistro(trailer, nomeArq);
    }

    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String ra, nome, curso, disciplina;
        Double media;
        int qtdeFaltas;
        int contaRegDadosLidos = 0;
        int qtdRegDadosGravados;

        //  Cria uma listaLida para receber os objetos Alunos com os dados lidos do arquivo
        List<Aluno> listaLida = new ArrayList<>();

        //  Bloco try-catch para abrir o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo!");
        }

        //  Bloco try-catch para ler o arquivo
        try {
            //  Lê a primeira linha do arquivo
            registro = entrada.readLine();

            while (registro != null) {
                //  Obtem o tipo do registro que sao os 2 primeiros caracteres do registro
                //  0123456...
                //  00NOTA20232
                //  substring considera os indices iniciados de zero
                //  substring espera receber como 1o argumento o indice inicial do que se deseja
                //  e o 2o argumento eh o indice final do que se deseja MAIS UM
                //  O 2o argumento tem o mesmo valor da posicao final do campo no doc layout

                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("00")) {
                    System.out.println("Eh um registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2, 6));
                    System.out.println("Ano e semestre: " + registro.substring(6, 11));
                    System.out.println("Data e hora da geração do arquivo: " + registro.substring(11, 30));
                    System.out.println("Versão do documento: " + registro.substring(30, 32));
                } else if (tipoRegistro.equals("01")) {
                    System.out.println("Eh um registro de trailer");
                    qtdRegDadosGravados = Integer.parseInt(registro.substring(2, 12));
                    if (qtdRegDadosGravados == contaRegDadosLidos) {
                        System.out.println("Quantidade de reg de dados gravados é compatível com a " +
                                "quantidade de reg de dados lidos");
                    } else {
                        System.out.println("Quantidade de reg de dados gravados NÃO é compatível com a " +
                                "quantidade de reg de dados lidos");
                    }
                } else if (tipoRegistro.equals("02")) {
                    System.out.println("Eh um registro de corpo");
                    curso = registro.substring(2, 7).trim();
                    ra = registro.substring(7, 15).trim();
                    nome = registro.substring(15, 65).trim();
                    disciplina = registro.substring(65, 105).trim();
                    media = Double.valueOf(registro.substring(105, 110).replace(",", ".")); //  5.2f
                    qtdeFaltas = Integer.parseInt(registro.substring(110, 113).trim()); //  3da

                    // Contabiliza que leu mais um reg de dados
                    contaRegDadosLidos++;

                    // Cria um objeto Aluno com os dados lidos desse registro
                    Aluno aluno = new Aluno(ra, nome, curso, disciplina, media, qtdeFaltas);

                    // Para importar esse dado, podemos fazer
                    // repository.save(aluno);

                    //  No nosso caso, como não estamos conectados a bando de dados,
                    //  vamos add o objeto a uma listaLida
                    listaLida.add(aluno);
                } else {
                    System.out.println("Eh um registro inválido");
                }

                //  Lê o próximo registro do arquivo
                registro = entrada.readLine();

            }   // Fim do while
            //  Fecha o arquivo
            entrada.close();
        } catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo!");
        }
    }


}