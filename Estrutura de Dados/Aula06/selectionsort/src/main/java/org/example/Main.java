package org.example;

import java.util.Arrays;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int[] v = {4, 7, 5, 2, 8, 1, 6, 3, 9};
        selectionSort(v);
        selectionSortOtimizado(v);
        bubbleSort(v);

    }

    public static void selectionSort(int[] v) {
        int comparacao = 0;
        int troca = 0;

        for (int i = 0; i < v.length-1; i++) {
            for (int j = i+1; j < v.length; j++) {
                comparacao++;
                if (v[j] < v[i]) {
                    troca++;
                    int aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                }
            }
        }

        System.out.println(Arrays.toString(v));
        System.out.println(comparacao);
        System.out.println(troca);

        int cont = 0;
        for (int k = 0; k < v.length; k++){
            cont++;
            if (v[k] == 7){
                System.out.println("Achei em: " + cont);
            }
        }
        binarySearch(v, 7);

    }

    public static void selectionSortOtimizado(int[] v) {
        for (int i = 0; i < v.length-1; i++) {
            int indMenor = i;
            for (int j = i+1; j < v.length; j++) {
                if (v[j] < v[indMenor]) {
                    indMenor = j;
                }
            }
            v[i] = indMenor;
        }

        System.out.println(Arrays.toString(v));
    }

    public static void bubbleSort(int[] v) {
        int comparacao = 0;
        int troca = 0;

        for (int i = 0; i < v.length-1; i++) {
            comparacao++;
            for (int j = 1; j < v.length; j++) {
                if (v[j-1] > v[j]) {
                    troca++;
                    v[j] = v[j-1];
                }
            }
        }

        System.out.println(comparacao);
        System.out.println(troca);
        System.out.println(Arrays.toString(v));

    }

    public static void binarySearch(int arr[], int key) {
        int cont = 0;
        int first = arr[0];
        int last = arr[arr.length-1];
        int mid = (first + last)/2;

        while( first <= last ){
            cont++;
            if ( arr[mid] < key ){
                first = mid + 1;
            }else if ( arr[mid] == key ){
                System.out.println("Element is found at index: " + mid + "\nContador: " + cont);
                break;
            }else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }
        if ( first > last ){
            System.out.println("Element is not found!");
        }
    }
}