package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TXT {
    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: ");
        }

        try {
            saida.append(registro + "\n");
            saida.close();
        } catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo: ");
        }
    }

    public static void gravaArquivoTxt(ListaObj<PersonagemLivro> lista, String nomeArq) {
        int contRegDadosGravados = 0;

        String header = "00NOTA20232";
        header += LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        header += "01";

        gravaRegistro(header, nomeArq);

        for (int i = 0; i < lista.getTamanho(); i++) {
            String corpo = "02";
            //fazer o corpo de acordo com a classe PersonagemLivro
            corpo += String.format("%-5.3s", lista.getElemento(i).getNome());
            corpo += String.format("%-8.8s", lista.getElemento(i).getHabilidade());
            corpo += String.format("%-50.50s", lista.getElemento(i).getForca());
            corpo += String.format("%-40.40s", lista.getElemento(i).getIdade());
            corpo += String.format("%05.2f", lista.getElemento(i).getReino());
            corpo += String.format("%03d", lista.getElemento(i).isProtagonista());

            gravaRegistro(corpo, nomeArq);
            contRegDadosGravados++;
        }

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

        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo!");
        }
    }
}
