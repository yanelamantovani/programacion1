/*
Hacer un programa que dado el arreglo definido y precargado elimine del arreglo todas
las ocurrencias de una secuencia patrón dada por otro arreglo de iguales características
(solo tiene esa secuencia). Al eliminar se pierden los valores haciendo los corrimientos.
 */

package Clase7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp7_Ej15 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilityNumber = 0.4;

    public static void main(String[] args) {
        int[] intArray;
        intArray = new int[MAX];
        int[] patternArray;
        patternArray = new int[MAX];

        fillRandomIntSequenceArray(intArray);
        System.out.println("Array inicial:");
        intArray[4] = 0; // PRUEBA
        intArray[5] = 2;
        intArray[6] = 5;
        intArray[7] = 0;
        printIntArray(intArray);
        System.out.println("Array con secuencia patrón");
        fillPatternArray(patternArray);
        printIntArray(patternArray);
        System.out.println("Array final sin secuencia patrón:");
        intArray = deletePatternSequence(intArray,patternArray);
        printIntArray(intArray);
    }

    public static void fillRandomIntSequenceArray(int[] array) {
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
        array[MAX - 2] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR); // Evito que el anteúltimo número sea un 0 y me de error al buscar la última secuencia
    }

    public static void fillPatternArray(int[] array) {
        array[0] = 0;
        array[1] = 2;
        array[2] = 5;
        for (int i = 3; i < MAX - 1; i++) {
            array[i] = 0;
        }
    }

    public static void printIntArray(int[] array) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println("");
    }

    public static int getStartingPositionSequenceArray(int[] array, int position) {
        while (array[position] == 0 && position < MAX) {
            position++;
        }
        int startingPosition = position;
        return startingPosition;
    }

    public static int getFinalPositionSequenceArray(int[] array, int startingPosition) {
        while (array[startingPosition] != 0) {
            startingPosition++;
        }
        int finalPosition = startingPosition - 1;
        return finalPosition;
    }

    public static int[] deletePatternSequence(int[] array, int[] patternArray) {
        int position = 0;
        int startingPosition = getStartingPositionSequenceArray(array, position);
        int startingPattern = getStartingPositionSequenceArray(patternArray, position);
        int finalPattern = getFinalPositionSequenceArray(patternArray, startingPattern);
        while (startingPosition < MAX) {
            int finalPosition = getFinalPositionSequenceArray(array, startingPosition);
            if ((array[startingPosition] == patternArray[startingPattern]) && (array[startingPosition + 1] == patternArray[finalPattern]) && (array[startingPosition + 2] == 0)) {
                int i = startingPosition;
                while (i < MAX - 3) {
                    array[i] = array[i + 2];
                    i++;
                }
                array[17] = 0;
                array[18] = 0;
                position = startingPosition;
            } else {
                position = finalPosition + 1;
            }
            if (position < MAX - 3) {
                startingPosition = getStartingPositionSequenceArray(array, position);
            } else {
                break;
            }
        }
        return array;
    }
}
