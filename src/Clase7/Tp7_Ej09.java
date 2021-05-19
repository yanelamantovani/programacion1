package Clase7;

/*
Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado, solicite
al usuario el ingreso de dos números enteros (posiciones del arreglo) y ordene de forma creciente el
arreglo entre dos posiciones correspondientes a los números ingresados.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp7_Ej09 {
    public static final int MAX = 10; // Dimensión de los arreglos
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 0;

    public static void main(String[] args) {
        int [] intArray;
        intArray = new int[MAX];
        int position1, position2;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            fillRandomIntArray(intArray);
            printIntArray(intArray);
            System.out.println("Ingrese la primer posición:");
            position1 = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese la segunda posición:");
            position2 = Integer.valueOf(entrada.readLine());
            sortArraySeleccion(intArray, position1, position2);
            printIntArray(intArray);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void fillRandomIntArray(int [] array) {
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            array[i] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
        }
    }

    public static void printIntArray(int [] array) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println(" ");
    }

    public static void sortArraySeleccion(int [] array, int position1, int position2) {
        int posMenor, aux;
        for (int i = position1; i <= position2; i++) {
            posMenor = i;
            for (int j = i + 1; j <= position2; j++) {
                if (array[j] < array[posMenor]) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                aux = array[i];
                array[i] = array[posMenor];
                array[posMenor] = aux;
            }
        }
    }
}
