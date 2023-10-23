package exemplos;

import java.util.Scanner;

public class ExemploThrow {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        try {
            System.out.println("Digite a nota 1 (entre 0 e 10):");
            Double nota01 = leitor.nextDouble();
            if(nota01 < 0 || nota01 > 10){
                throw new Exception("Valor inválido da nota1");
            }
            System.out.println("Digite a nota 2 (entre 0 e 10)");
            Double nota02 = leitor.nextDouble();
            if(nota02 < 0 || nota02 > 10){
                throw new Exception("Valor inválido da nota2");
            }
            System.out.println("Média = " + (nota01+nota02)/2);
        }
        catch (Exception erro){
            erro.printStackTrace();
        }
    }
}
