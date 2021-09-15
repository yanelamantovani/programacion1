package Clase7;

/*
 * Hacer un programa que dado un arreglo de enteros de tamano 10 que se encuentra precargado,
 * imprima por pantalla el promedio de la suma de sus valores.
 */

import java.util.Random;

public class Clase7_Ejemplo3 {
    public static final int MAX = 10;
    public static final int MINVALOR = 0;
    public static final int MAXVALOR = 9;

    public static void main (String [ ] args) {
        int [ ] arrenteros = new int[MAX];
        cargar_arreglo(arrenteros);
        int promedio = promedio_arreglo(arrenteros);
        System.out.println("El promedio del arreglo es " + promedio);
    }

    public static int promedio_arreglo(int [ ] arr) {
        int suma = 0;
        for (int pos = 0; pos < MAX; pos++) {
            suma += arr[pos];
        }
        return suma / MAX;
    }

    public static void cargar_arreglo(int [] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
        }
    }
}
