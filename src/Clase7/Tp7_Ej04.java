package Clase7;

/* Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado,
solicite al usuario un numero entero y lo agregue al principio del arreglo (posición 0). Para ello
tendrá que realizar un corrimiento a derecha (se pierde el último valor del arreglo) y colocar el
numero en el arreglo en la posición indicada. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp7_Ej04 {
    public static final int max = 10;
    public static final int maxValor = 9;
    public static final int minValor = 0;

    public static void main(String[] args) {
        int [] intArray = new int[max];
        int number;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            fillRandomIntArray(intArray);
            printIntArray(intArray);
            System.out.println("Ingresar un número que se agregará en la primera posición:");
            number = Integer.valueOf(entrada.readLine());
            moveToRight(intArray, number);
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

    public static void moveToRight(int [] array, int number) {
        int i = max - 1;
        while (i > 0) {
            array[i] = array[i - 1];
            i--;
        }
        array[0] = number;
    }
}
