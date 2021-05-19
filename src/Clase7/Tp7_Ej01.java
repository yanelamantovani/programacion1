package Clase7;

/* Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado,
invierta el orden del contenido (por ejemplo: el que está en 0 se intercambia con el que está en 9,
el que está en 1 con el que está en 8...). Este intercambio no se debe realizar de manera explícita,
hay que hacer un método que incluya una iteración de intercambio. */

import java.util.Random;

public class Tp7_Ej01 {
    public static final int max = 10;
    public static final int maxValor = 9;
    public static final int minValor = 0;

    public static void main(String[] args) {
        int [] intArray = new int[max];
        try {
            fillRandomIntArray(intArray);
            printIntArray(intArray);
            reverseArray(intArray);
            printIntArray(intArray);
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

    public static void reverseArray(int [] array) {
        int aux;
        for (int i = 0; i < max / 2; i++) {
            aux = array[i];
            array[i] = array[max - 1 - i];
            array[max - 1 - i] = aux;
        }
    }
}
