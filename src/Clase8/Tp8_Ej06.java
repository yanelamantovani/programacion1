/*
 * Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra precargada,
 * solicite al usuario un numero entero y elimine todas las ocurrencia de numero en la matriz si existe.
 * Mientras exista (en cada iteración tiene que buscar la posición fila y columna) tendrá que usar dicha
 * posición para realizar un corrimiento a izquierda.
 */

package Clase8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp8_Ej06 {
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
            System.out.println("Ingrese un numero:");
            int num = Integer.valueOf(entrada.readLine());
            buscar_num_eliminar_todos(matint, num);
            imprimir_matriz(matint);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void buscar_num_eliminar_todos(int [ ][ ] mat, int num) {
        int columna;
        for (int fila = 0; fila < MAXFILA; fila++) {
            columna = obtener_pos_arreglo(mat[fila], num);
            int indice = 0;
            while ((columna < MAXCOLUMNA - 1) && (indice < MAXCOLUMNA - 1)) {
                corrimiento_izq(mat[fila], columna);
                columna = obtener_pos_arreglo(mat[fila], num);
                indice++;
            }
        }
    }

    public static int obtener_pos_arreglo(int [ ] arr, int num) {
        int pos = 0;
        while ((pos < MAXCOLUMNA) && (arr[pos] != num)) {
            pos++;
        }
        return pos;
    }

    public static void corrimiento_izq(int [ ] arr, int pos) {
        while (pos < MAXCOLUMNA - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
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
