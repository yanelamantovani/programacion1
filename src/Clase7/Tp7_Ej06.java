package Clase7;

/* Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado,
solicite al usuario un numero entero y elimine todas las ocurrencia de numero en el arreglo si existe.
Mientras exista (en cada iteración tiene que buscar la posición dentro del arreglo) tendrá que usar la
posición para realizar un corrimiento a izquierda (quedarán tantas copias de la última posición del arreglo
como cantidad de ocurrencias del número). */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp7_Ej06 {
    public static final int max = 10;
    public static final int maxValor = 9;
    public static final int minValor = 0;

    public static void main(String[] args) {
        int [] intArray = new int[max];
        int number, position;
        int i = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            fillRandomIntArray(intArray);
            printIntArray(intArray);
            System.out.println("Ingrese el número que quiere eliminar del arreglo:");
            number = Integer.valueOf(entrada.readLine());
            do {
                i++;
                position = getPositionArray(intArray, number);
                if (position < max) {
                    shiftLeft(intArray, position);
                }
            } while (position < max - 1 && i < max); //Esta condicion es para evitar que entre en un bucle infinito cuando el nro ingresado es igual al último del arreglo
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

    public static int getPositionArray(int [] array, int number) {
        int position = 0;
        while ((position < max) && (array[position] != number)) {
            position++;
        }
        return position;
    }

    public static void shiftLeft(int [] array, int position) {
        int i = position;
        while (i < max - 1) {
            array[i] = array[i + 1];
            i++;
        }
    }
}
