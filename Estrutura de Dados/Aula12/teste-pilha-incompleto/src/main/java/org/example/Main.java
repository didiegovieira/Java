package org.example;

public class Main {
    public static Boolean ehPalindromo(PilhaObj lista){
        PilhaObj p = new PilhaObj(lista.getTopo() + 1);

        for (int i = 0; i < lista.getTopo(); i++) {
            p.push(lista.pop());
        }

        for (int i = 0; i < lista.getTopo(); i++) {
            if (p.pop() != lista.pop()) {
                return false;
            }
        }

        return true;
    }

    public static Boolean ehPalindromoString(String frase) {
        PilhaObj<Character> pilha = new PilhaObj(frase.length());

        for (int i = 0; i < frase.length(); i++) {
            char caractere = frase.charAt(i);
            pilha.push(caractere);
        }

        for (int i = 0; i < frase.length(); i++) {
            if (pilha.pop() != frase.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void converteParaBinario(int numero) {
        Pilha p = new Pilha(8);

        while (numero > 0) {
            p.push(numero % 2);
            numero = numero / 2;
        }

        while (!p.isEmpty()) {
            System.out.print(p.pop());
        }
    }

    public static String inverterFrase(String frase) {
        frase = frase.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        PilhaObj<Character> pilha = new PilhaObj(frase.length());

        for (int i = 0; i < frase.length(); i++) {
            char caractere = frase.charAt(i);
            pilha.push(caractere);
        }

        StringBuilder fraseInvertida = new StringBuilder();
        while (!pilha.isEmpty()) {
            fraseInvertida.append(pilha.pop());
        }

        return fraseInvertida.toString();
    }

    public static void main(String[] args) {
        PilhaObj lista = new PilhaObj(7);
        lista.push(10);
        lista.push(20);
        lista.push(30);
        lista.push(40);
        lista.push(30);
        lista.push(20);
        lista.push(10);

        if (ehPalindromo(lista)) {
            System.out.println("É palíndromo");
        } else {
            System.out.println("Não é palíndromo");
        }

        converteParaBinario(20);

        PilhaObj<String> pilha = new PilhaObj<>(5);

        pilha.push("A");
        pilha.push("B");
        pilha.push("C");
        pilha.push("D");
        pilha.push("E");

        pilha.exibe();

        while (!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }

        inverterFrase("Frase invertida");

        if (ehPalindromoString("frase esarf")) {
            System.out.println("É palíndromo");
        } else {
            System.out.println("Não é palíndromo");
        }
    }
}