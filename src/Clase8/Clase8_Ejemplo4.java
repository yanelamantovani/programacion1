/*
 * NO SE PUEDE RESOLVER CON ARREGLOS
 *  Hacer un programa que dado una matriz de enteros de tamanio 4*5 que se encuentra precargada,
 * imprima por pantalla el promedio de cada una de sus columnas.
 */

package Clase8;

import java.util.Random;

public class Clase8_Ejemplo4 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 5;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main (String [] args) {
        int [][] matint = new int [MAXFILA][MAXCOLUMNA];
        cargar_matriz(matint);
        imprimir_matriz(matint);
        imprimir_promedios_columnas(matint);
    }

    public static void imprimir_promedios_columnas(int [][] mat) {
        for (int columna = 0; columna < MAXCOLUMNA; columna++) {
            System.out.println("El promedio de la columna " + columna + " es: " + obtener_promedio_columna(mat, columna));
        }
    }

    public static int obtener_promedio_columna(int [][] mat, int columna) {
        int suma = 0;
        for (int fila = 0; fila < MAXFILA; fila++) {
            suma += mat[fila][columna];
        }
        return suma / MAXFILA;
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
