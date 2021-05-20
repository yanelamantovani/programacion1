/*
Hacer un programa que dado el arreglo definido y precargado permita encontrar la posición de inicio y
fin de la anteúltima secuencia (considerar comenzar a buscarla a partir de la ultima posición del arreglo).
 */

package Clase7;

import java.util.Random;

public class Tp7_Ej12 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilityNumber = 0.4;

    public static void main(String[] args) {
        int [] intArray;
        intArray = new int[MAX];
        fillRandomIntSequenceArray(intArray);
        printIntArray(intArray);
        getBeforeLastSequenceArray(intArray);
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
        array [MAX - 2] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR); // Evito que el anteúltimo número sea un 0 y me de error al buscar la última secuencia
    }

    public static void printIntArray(int [] array) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println("");
    }

    public static int getFinalPositionSequenceArray(int [] array) {
        int position = MAX - 1;
        while (array[position] == 0) {
            position--;
        }
        int finalPosition = position;
        return finalPosition;
    }

    public static int getStartingPositionSequenceArray(int [] array, int finalPosition) {
        while (array[finalPosition] != 0) {
            finalPosition--;
        }
        int startingPosition = finalPosition + 1;
        return startingPosition;
    }

    public static void getBeforeLastSequenceArray(int [] array) {
        int finalPosition = getFinalPositionSequenceArray(array);
        int startingPosition = getStartingPositionSequenceArray(array,finalPosition);
        int beforeLastFinalPosition = startingPosition - 1;
        while (array[beforeLastFinalPosition] == 0) {
            beforeLastFinalPosition--;
        }
        int beforeLastStartingPosition = getStartingPositionSequenceArray(array,beforeLastFinalPosition);
        System.out.println("La anteúltima secuencia empieza en la posición: " + beforeLastStartingPosition);
        System.out.println("Y termina en la posición: " + beforeLastFinalPosition);
    }
}