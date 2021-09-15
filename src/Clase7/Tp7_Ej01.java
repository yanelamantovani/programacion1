package Clase7;

/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado,
 * invierta el orden del contenido (por ejemplo: el que está en 0 se intercambia con el que está en 9,
 * el que está en 1 con el que está en 8...). Este intercambio no se debe realizar de manera explícita,
 * hay que hacer un método que incluya una iteración de intercambio.
 */

import java.util.Random;

public class Tp7_Ej01 {
    public static final int MAX = 10;
    public static final int MINVALOR = 0;
    public static final int MAXVALOR = 9;

    public static void main(String[ ] args) {
        int [ ] arrenteros = new int[MAX];
        cargar_arreglo(arrenteros);
        imprimir_arreglo(arrenteros);
        invertir_arreglo(arrenteros);
        imprimir_arreglo(arrenteros);
    }

    public static void invertir_arreglo(int [ ] arr) {
        int aux;
        for (int pos = 0; pos < MAX / 2; pos++) {
            aux = arr[MAX -  1 - pos];
            arr[MAX -  1 - pos] = arr [pos];
            arr[pos] = aux;
        }
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
