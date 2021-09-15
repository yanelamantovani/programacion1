/*
 * Hacer un programa que dado una matriz de enteros de tamanio 4*5 que se encuentra precargada,
 * imprima por pantalla el promedio de cada una de sus filas.
 */

package Clase8;

import java.util.Random;

public class Clase8_Ejemplo3 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 5;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main (String [] args) {
        int [][] matint = new int [MAXFILA][MAXCOLUMNA];
        cargar_matriz(matint);
        imprimir_matriz(matint);
        imprimir_promedios_filas(matint);
    }

    public static void imprimir_promedios_filas(int [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            System.out.println("El promedio de la fila " + fila + " es: " + obtener_promedio_arreglo(mat[fila]));
        }
    }

    public static int obtener_promedio_arreglo(int [ ] arr) {
        int suma = 0;
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            suma += arr[pos];
        }
        return suma / MAXCOLUMNA;
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
