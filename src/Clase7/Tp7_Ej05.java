package Clase7;

/* Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado,
solicite al usuario un numero entero y elimine la primer ocurrencia de numero (un número igual)
en el arreglo si existe. Para ello tendrá que buscar la posición y si está, realizar un corrimiento
a izquierda (queda una copia de la última posición del arreglo en la anteúltima posición). */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp7_Ej05 {
    public static final int max = 10;
    public static final int maxValor = 9;
    public static final int minValor = 0;

    public static void main(String[] args) {
        int [] intArray = new int[max];
        int number, position;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            fillRandomIntArray(intArray);
            printIntArray(intArray);
            System.out.println("Ingrese el número que quiere eliminar del arreglo:");
            number = Integer.valueOf(entrada.readLine());
            position = getPositionArray(intArray, number);
            if (position < max) {
                System.out.println(number + " está en la posición " + position);
                moveToLeft(intArray, position);
                printIntArray(intArray);
            } else {
                System.out.println(number + " no existe");
            }
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

    public static int getPositionArray(int [] array, int number) {
        int position = 0;
        while ((position < max) && (array[position] != number)) {
            position++;
        }
        return position;
    }

    public static void moveToLeft(int [] array, int position) {
        int i = position;
        while (i < max - 1) {
            array[i] = array[i + 1];
            i++;
        }
    }
}
