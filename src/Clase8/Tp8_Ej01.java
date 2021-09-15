/*
 * Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra precargada,
 * invierta el orden del contenido por fila. Este intercambio no se debe realizar de manera explícita,
 * hay que hacer un método que incluya una iteración de intercambio.
 */

package Clase8;

import java.util.Random;

public class Tp8_Ej01 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main(String[ ] args) {
        int [ ][ ] matint = new int[MAXFILA][MAXCOLUMNA];
        cargar_matriz(matint);
        System.out.println("Matriz inicial:");
        imprimir_matriz(matint);
        invertir_matriz(matint);
        System.out.println("Matriz invertida:");
        imprimir_matriz(matint);
    }

    public static void invertir_matriz(int [ ][ ] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            invertir_arreglo(mat[fila]);
        }
    }

    public static void invertir_arreglo(int [ ] arr) {
        int aux;
        for (int pos = 0; pos < MAXCOLUMNA / 2; pos++) {
            aux = arr[MAXCOLUMNA -  1 - pos];
            arr[MAXCOLUMNA -  1 - pos] = arr [pos];
            arr[pos] = aux;
        }
    }

    public static void cargar_matriz (int [][] mat) {
        Random r = new Random();
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo(mat[fila]);
        }
    }

    public static void cargar_arreglo(int [] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
        }
    }

    public static void imprimir_matriz(int [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            imprimir_arreglo(mat[fila]);
        }
    }

    public static void imprimir_arreglo(int [] arr) {
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}
