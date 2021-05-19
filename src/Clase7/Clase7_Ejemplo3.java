package Clase7;

/*Hacer un programa que dado un arreglo de enteros de tamano 10 que se encuentra precargado,
imprima por pantalla el promedio de la suma de sus valores. */

import java.util.Random;

public class Clase7_Ejemplo3 {
    public static final int max = 10;
    public static final int maxValor = 10;
    public static final int minValor = 1;

    public static void main(String[] args) {
        int [] intArray = new int[max];
        int promedio;
        fillRandomIntArray(intArray);
        printIntArray(intArray);
        promedio = calculateAverage(intArray);
        System.out.println("El promedio de la suma de los valores del arreglo es: " + promedio);
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

    public static int calculateAverage(int [] array) {
        int suma = 0;
        for (int i = 0; i < max; i++) {
            suma += array[i];
        }
        return (suma / max);
    }
}
