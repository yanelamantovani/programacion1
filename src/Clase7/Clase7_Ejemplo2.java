package Clase7;

/*
 * Hacer un programa que cargue en un arreglo de enteros 10 valores aleatorios y lo imprima.
 */

import java.util.Random;

public class Clase7_Ejemplo2 {
    public static final int MAX = 10;
    public static final int MINVALOR = 0;
    public static final int MAXVALOR = 9;

    public static void main (String [] args) {
        int [] arrenteros = new int [MAX];
        cargar_arreglo(arrenteros);
        imprimir_arreglo(arrenteros);
    }

    public static void cargar_arreglo(int [] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
        }
    }

    public static void imprimir_arreglo(int [] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}
