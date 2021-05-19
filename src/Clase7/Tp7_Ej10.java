/*
Se tiene un arreglo de enteros de tamaño 20 de secuencias de números entre 1 y 9, separadas por 0.
El arreglo esta precargado, y además empieza y termina con uno o más separadores 0. Considere para los
siguientes ejercicios este tipo de arreglo.
Hacer un programa que dado el arreglo definido y precargado permita obtener a través de métodos la
posición de inicio y la posición de fin de la secuencia ubicada a partir de una posición entera ingresada
por el usuario. Finalmente, si existen imprima por pantalla ambas posiciones obtenidas.
*/

package Clase7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp7_Ej10 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilityNumber = 0.4;

    public static void main(String[] args) {
        int [] intArray;
        intArray = new int[MAX];
        fillRandomIntSequenceArray(intArray);
        printIntArray(intArray);

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingresar una posición (número entero):");
            int position = Integer.valueOf(entrada.readLine());
            int startingPosition = getStartingPositionSequenceArray(intArray, position);
            System.out.println("La siguiente secuencia inicia en la posición: " + startingPosition);
            int finalPosition = getFinalPositionSequenceArray(intArray, startingPosition);
            System.out.println("Y termina en la posición: " + finalPosition);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void fillRandomIntSequenceArray(int [] array) {
        Random r = new Random();
        array[0] = 0;
        array[MAX - 1] = 0;
        for (int i = 1; i < MAX - 1; i++) {
            if (r.nextDouble() > probabilityNumber) {
                array[i] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                array[i] = 0;
            }
        }
    }

    public static void printIntArray(int [] array) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println("");
    }

    public static int getStartingPositionSequenceArray(int [] array, int position) {
        while (array[position] != 0) {
            position++;
        }
        while (array[position] == 0) {
            position++;
        }
        int startingPosition = position;
        return startingPosition;
    }

    public static int getFinalPositionSequenceArray(int [] array, int startingPosition) {
        while (array[startingPosition] != 0) {
            startingPosition++;
        }
        int finalPosition = startingPosition - 1;
        return finalPosition;
    }
}
