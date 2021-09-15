/*
 * Hacer un programa que dado una matriz de enteros de tamaño 4*5 que se encuentra precargada,
 * solicite al usuario el ingreso de una fila y dos números enteros (columnas de la matriz),
 * y ordene de forma creciente la matriz en la fila indicada entre las dos posiciones columnas ingresadas.
 */

package Clase8;

import java.io.BufferedReader;
import java.util.Random;
import java.io.InputStreamReader;

public class Tp8_Ej09 {
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
            System.out.println("Ingrese una fila (entre 0 y 3):");
            int fila = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese la posición inicial (entre 0 y 4):");
            int posInicio = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese la posición final (entre 0 y 4):");
            int posFin = Integer.valueOf(entrada.readLine());
            ordenar_entre_pos(matint[fila], posInicio, posFin);
            imprimir_matriz(matint);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void ordenar_entre_pos(int [ ] arr, int posInicio, int posFin) {
        int posMenor, aux;
        for (int i = posInicio; i <= posFin; i++) {
            posMenor = i;
            for (int j = i + 1; j <= posFin; j++) {
                if (arr[j] < arr[posMenor]) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                aux = arr[i];
                arr[i] = arr[posMenor];
                arr[posMenor] = aux;
            }
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
