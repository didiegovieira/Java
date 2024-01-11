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

        gravaArquivoTxt(lista, "alunos.txt");
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

        //  Bloco try-catch para abrir o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo!");
        }

        //  Bloco try-catch para ler o arquivo
    }


}