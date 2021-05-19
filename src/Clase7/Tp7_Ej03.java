package Clase7;

/* Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado,
solicite al usuario una posición y realice un corrimiento a izquierda o hacia la menor posición del arreglo. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp7_Ej03 {
    public static final int max = 10;
    public static final int maxValor = 9;
    public static final int minValor = 0;

    public static void main(String[] args) {
        int [] intArray = new int[max];
        int position;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            fillRandomIntArray(intArray);
            printIntArray(intArray);
            System.out.println("Ingresar una posición:");
            position = Integer.valueOf(entrada.readLine());
            moveToLeft(intArray, position);
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

    public static void moveToLeft(int [] array, int position) {
        int i = 0;
        while (i < position) {
            array[i] = array[i + 1];
            i++;
        }
    }
}
