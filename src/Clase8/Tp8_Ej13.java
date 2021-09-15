/*
 * Hacer un programa que dada la matriz de secuencias de enteros definida y precargada, y un número entero
 * ingresado por el usuario, elimine de cada fila las secuencias de tamaño igual al número ingresado.
 */

package Clase8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp8_Ej13 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[ ] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int [][] matint = new int[MAXFILA][MAXCOLUMNA];
        cargar_matriz_secuencias_int(matint);
        imprimir_matriz_int(matint);
        try {
            System.out.println("Ingrese un numero entero:");
            int num = Integer.valueOf(entrada.readLine());
            eliminar_secuencias_tamanio_matriz(matint, num);
            imprimir_matriz_int(matint);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void eliminar_secuencias_tamanio_matriz(int [][] mat, int num) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            eliminar_secuencias_tamanio_arreglo(mat[fila], num);
        }
    }

    public static void eliminar_secuencias_tamanio_arreglo(int [ ] arr, int num) {
        int fin = -1;
        int inicio = obtener_inicio_secuencia(arr, fin + 1);
        while ((inicio < MAXCOLUMNA)) {
            fin = obtener_fin_secuencia(arr, inicio);
            if (num == (fin - inicio + 1)) {
                eliminar_secuencia(arr, inicio, fin);
                fin = inicio - 1;
            }
            inicio = obtener_inicio_secuencia(arr, fin + 1);
        }
    }

    public static void eliminar_secuencia(int [ ] arr, int inicio, int fin) {
        for(int i = inicio; i <= fin; i++) {
            corrimientoIzq(arr, inicio);
        }
    }

    public static void corrimientoIzq(int[] arr, int inicio) {
        for(int i = inicio; i < MAXCOLUMNA - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public static int obtener_inicio_secuencia(int [ ] arr, int pos) {
        while ((pos < MAXCOLUMNA) && (arr[pos] == 0)) {
            pos++;
        }
        return pos;
    }

    public static int obtener_fin_secuencia(int [ ] arr, int pos) {
        while ((pos < MAXCOLUMNA) && (arr[pos] != 0)) {
            pos++;
        }
        return pos - 1;
    }

    public static void cargar_matriz_secuencias_int(int [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo_secuencias_int(mat[fila]);
        }
        System.out.println(" ");
    }

    public static void cargar_arreglo_secuencias_int(int [ ] arr) {
        Random r = new Random();
        arr[0] = 0;
        arr[MAXCOLUMNA - 1] = 0;
        for (int pos = 1; pos < MAXCOLUMNA - 1; pos++) {
            if (r.nextDouble() > PROBABILIDAD) {
                arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                arr[pos] = 0;
            }
        }
    }

    public static void imprimir_matriz_int(int [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            imprimir_arreglo_int(mat[fila]);
        }
    }

    public static void imprimir_arreglo_int(int [] arr) {
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}
