package Clase7;

/* Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado,
obtenga la cantidad de números pares que tiene y la imprima. */

import java.util.Random;

public class Tp7_Ej02 {
    public static final int max = 10;
    public static final int maxValor = 9;
    public static final int minValor = 0;

    public static void main(String[] args) {
        int [] intArray = new int[max];
        int totalEvenNumbers;
        try {
            fillRandomIntArray(intArray);
            printIntArray(intArray);
            totalEvenNumbers = findEvenNumbers(intArray);
            System.out.println("La cantidad de números pares del arreglo es de: " + totalEvenNumbers);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void fillRandomIntArray(int [] array) {
        Random r = new Random();
        for (int i = 0; i < max; i++) {
            array[i] = (r.nextInt(maxValor - minValor + 1) + minValor);
        }
    }

    public static void printIntArray(int [] array) {
        for (int i = 0; i < max; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println(" ");
    }

    public static int findEvenNumbers(int [] array) {
        int totalEvenNumbers = 0;
        for (int i = 0; i < max; i++) {
            if (array[i] % 2 == 0) {
                totalEvenNumbers++;
            }
        }
        return totalEvenNumbers;
    }
}
