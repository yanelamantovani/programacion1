/*
 * Hacer un programa que dado una matriz ordenada creciente por filas de enteros de tamaño 4*5 que se encuentra
 * precargada, solicite al usuario un numero entero y una fila, y elimine la primer ocurrencia de numero en la
 * fila indicada (un número igual) si existe.
 */

package Clase8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp8_Ej08 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 5;
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
            System.out.println("Ingrese un numero:");
            int fila = Integer.valueOf(entrada.readLine());
            int pos = obtener_pos_ord_crec(matint[fila], num);
            if ((pos < MAXCOLUMNA) && (matint[fila][pos] == num)) {
                corrimiento_izq(matint[fila], pos);
                imprimir_matriz(matint);
            } else {
                System.out.println(num + " no existe en la matriz.");
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static int obtener_pos_ord_crec(int [ ] arr, int num) {
        int pos = 0;
        while ((pos < MAXCOLUMNA) && (arr[pos] < num)) {
            pos++;
        }
        return pos;
    }

    public static void corrimiento_izq(int [ ] arr, int pos) {
        for(int i = pos; i < MAXCOLUMNA - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public static void cargar_matriz (int [][] mat) {
        Random r = new Random();
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo(mat[fila]);
        }
        ordenar_filas(mat);
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

    public static void ordenar_filas(int [ ][ ] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            ordenar_arreglo_seleccion(mat[fila]);
        }
    }

    public static void ordenar_arreglo_seleccion(int [ ] arr) {
        int posMenor, temp;
        for (int i = 0; i < MAXCOLUMNA; i++) {
            posMenor = i;
            for (int j = i + 1; j < MAXCOLUMNA; j++) {
                if (arr[j] < arr[posMenor]) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                temp = arr[i];
                arr[i] = arr[posMenor];
                arr[posMenor] = temp;
            }
        }
    }
}