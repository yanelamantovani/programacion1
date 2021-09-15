/*
 * Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra precargada,
 * obtenga la cantidad de números pares que tiene y la imprima.
 */

package Clase8;

import java.util.Random;

public class Tp8_Ej02 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main(String[ ] args) {
        int [ ][ ] matint = new int[MAXFILA][MAXCOLUMNA];
        cargar_matriz(matint);
        imprimir_matriz(matint);
        System.out.println("La cantidad de números pares del arreglo es: " + obtener_pares_matriz(matint));
    }

    public static int obtener_pares_matriz(int [][] mat) {
        int cantPares = 0;
        for (int fila = 0; fila < MAXFILA; fila++) {
            cantPares += obtener_pares_arreglo(mat[fila]);
        }
        return cantPares;
    }

    public static int obtener_pares_arreglo(int [ ] arr) {
        int cantPares = 0;
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            if (arr[pos] % 2 == 0) {
                cantPares++;
            }
        }
        return cantPares;
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
