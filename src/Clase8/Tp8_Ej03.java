/*
 * Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra precargada,
 * solicite al usuario una posición fila, columna y realice un corrimiento a izquierda.
 */

package Clase8;

import java.io.BufferedReader;
import java.util.Random;
import java.io.InputStreamReader;

public class Tp8_Ej03 {
    public static final int MAXFILA = 5;
    public static final int MAXCOLUMNA = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main (String [ ] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int [ ][ ] matint = new int[MAXFILA][MAXCOLUMNA];
        cargar_matriz(matint);
        imprimir_matriz(matint);
        try {
            System.out.println("Ingrese una fila:");
            int fila = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese una columna:");
            int columna = Integer.valueOf(entrada.readLine());
            if ((fila >= 0) && (fila < MAXFILA) && (columna >= 0) && (columna < MAXCOLUMNA)) {
                corrimiento_izq(matint[fila], columna);
                imprimir_matriz(matint);
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void corrimiento_izq(int [ ] arr, int pos) {
        int indice = 0;
        while (indice < pos) {
            arr[indice] = arr[indice + 1];
            indice++;
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
