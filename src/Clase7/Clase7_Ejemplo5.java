package Clase7;

/*Hacer un programa que dado un arreglo de enteros de tamano 8 que se encuentra precargado,
solicite al usuario una posicion y realice un corrimiento a derecha o hacia la mayor posicion
del arreglo. Ademas imprima el arreglo antes y despues del corrimiento. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Clase7_Ejemplo5 {
    public static final int max = 8;
    public static final int maxValor = 10;
    public static final int minValor = 1;

    public static void main(String[] args) {
        int [] intArray = new int[max];
        int position;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            fillRandomIntArray(intArray);
            printIntArray(intArray);
            System.out.println("Ingresar una posición:");
            position = Integer.valueOf(entrada.readLine());
            moveToRight(intArray, position);
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

    public static void moveToRight(int [] array, int position) {
        int i = max - 1; // Ultima posicion del vector
        while (i > position) {
            array[i] = array[i - 1]; // Desplazo desde el final hasta la posición
            i--;
        }
    }
}
