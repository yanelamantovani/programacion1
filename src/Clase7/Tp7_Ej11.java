/*
Hacer un programa que dado el arreglo definido y precargado permita encontrar la posición de inicio y
fin de la secuencia cuya suma de valores sea mayor.
 */

package Clase7;

import java.util.Random;

public class Tp7_Ej11 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilityNumber = 0.4;

    public static void main(String[] args) {
        int [] intArray;
        intArray = new int[MAX];
        fillRandomIntSequenceArray(intArray);
        printIntArray(intArray);
        getSumSequenceArray(intArray);
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

    public static int getStartingPositionSequenceArray(int [] array, int position) {
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

    public static void getSumSequenceArray(int [] array) {
        int higherSum = 0;
        int start = 0;
        int fin = 0;
        int position = 0;
        int startingPosition = getStartingPositionSequenceArray(array,position);
        while (startingPosition < MAX) {
            int finalPosition = getFinalPositionSequenceArray(array,startingPosition);
            int sum = 0;
            for (int i = startingPosition; i <= finalPosition; i++){
                sum+= array[i];
            }
            if (sum > higherSum) {
                higherSum = sum;
                start = startingPosition;
                fin = finalPosition;
            }
            System.out.println("La suma de la secuencia de " + startingPosition + " hasta " + finalPosition + " es: " + sum);
            position = finalPosition + 1;
            if (position < MAX - 1) {
                startingPosition = getStartingPositionSequenceArray(array,position);
            } else {
                break;
            }
        }
        System.out.println("La suma de los valores de la secuencia entre posiciones " + start + " y " + fin + " es la más grande.");
    }
}
