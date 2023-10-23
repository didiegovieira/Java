package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CSV {
    public void gravaArquivoCsv(ListaObj<Paciente> l, String nomeArq){
        FileWriter arq = null;
        Formatter saida = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        try {
            arq = new FileWriter(nomeArq, false);
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        try {
            for (int i = 0; i < l.getTamanho(); i++) {
                Paciente paciente = l.getElemento(i);

                saida.format("%d;%s;%s;%b;%.2f;%d\n",
                        paciente.getId(), paciente.getNome(),
                        paciente.getSintomas(), paciente.getPrioritario(),
                        paciente.getPeso(), paciente.getIdade());
            }
        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
            deuRuim = true;
        }
        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                erro.printStackTrace();
                deuRuim = true;
            }
        }
    }

    public void leExibeArquivoCsv(String nomeArq) {
        FileReader arq = null;
        Scanner entrada = null;
        Boolean deuRuim = false;

        nomeArq += ".csv";

        try {
            arq = new FileReader(nomeArq);
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        }
        catch (FileNotFoundException erro) {
            System.out.println("Arquivo inexistente");
            System.exit(1);
        }

        try {
            System.out.printf("%-4S %-16S %-15S %-11S %-5S %-6S \n", "id", "nome", "sintomas", "prioritario", "peso", "idade");
            while (entrada.hasNext()) {
                int id = entrada.nextInt();
                String nome = entrada.next();
                String sintomas = entrada.next();
                boolean prioritario = entrada.nextBoolean();
                double peso = entrada.nextDouble();
                int idade = entrada.nextInt();

                System.out.printf("%04d %-16s %-15s %-11s %5.2f %5d \n", id, nome, sintomas, prioritario, peso, idade);

            }

        }
        catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            erro.printStackTrace();
            deuRuim = true;
        }
        catch (IllegalStateException erro) {
            System.out.println("Erro na leitura do arquivo");
            erro.printStackTrace();
            deuRuim = true;
        }
        finally {
            entrada.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                erro.printStackTrace();
                deuRuim = true;
            }
        }
    }

}
