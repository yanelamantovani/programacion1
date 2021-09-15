/*
 * Hacer un programa que dada la matriz de secuencias de caracteres definida y precargada elimine todas
 * las secuencias que tienen orden descendente entre sus elementos.
 */

package Clase8;

import java.util.Random;

public class Tp8_Ej15 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 20;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[] args) {
        char [][] matchar = new char[MAXFILA][MAXCOLUMNA];
        cargar_matriz_secuencias_char(matchar);
        System.out.println("Matriz inicial");
        imprimir_matriz_char(matchar);
        eliminar_secuencias_orden_descendente_matriz(matchar);
        System.out.println("Matriz sin secuencias descendentes");
        imprimir_matriz_char(matchar);
    }

    public static void eliminar_secuencias_orden_descendente_matriz(char[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            eliminar_secuencias_orden_descendente_arreglo(mat[fila]);
        }
    }


    public static void eliminar_secuencias_orden_descendente_arreglo(char[] arr) {
        int fin = -1;
        int inicio = obtener_inicio_secuencia(arr, fin + 1);
        while (inicio < MAXCOLUMNA - 1) {
            fin = obtener_fin_secuencia(arr, inicio);
            if (es_descendente(arr, inicio, fin)) {
                eliminar_secuencia(arr, inicio, fin);
            }
            inicio = obtener_inicio_secuencia(arr, fin + 1);
        }
    }

    public static boolean es_descendente(char[] arr, int inicio, int fin) {
        for(int pos = inicio; pos <= fin; pos++) {
            if ((arr[pos] <= arr[pos + 1]) || (inicio == fin)){
                return false;
            }
        }
        return true;
    }

    public static void eliminar_secuencia(char[] arr, int inicio, int fin) {
        for(int i = inicio; i <= fin; i++) {
            corrimientoIzq(arr, inicio);
        }
    }

    public static void corrimientoIzq(char[] arr, int inicio) {
        for(int i = inicio; i < MAXCOLUMNA - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public static int obtener_inicio_secuencia(char [ ] arr, int pos) {
        while ((pos < MAXCOLUMNA) && (arr[pos] == ' ')) {
            pos++;
        }
        return pos;
    }

    public static int obtener_fin_secuencia(char [ ] arr, int pos) {
        while ((pos < MAXCOLUMNA) && (arr[pos] != ' ')) {
            pos++;
        }
        return pos - 1;
    }

    public static void cargar_matriz_secuencias_char(char [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo_secuencias_char(mat[fila]);
        }
        System.out.println(" ");
    }

    public static void cargar_arreglo_secuencias_char(char [ ] arr) {
        Random r = new Random();
        arr[0] = ' ';
        arr[MAXCOLUMNA - 1] = ' ';
        for (int pos = 1; pos < MAXCOLUMNA - 1; pos++) {
            if (r.nextDouble() > PROBABILIDAD) {
                arr[pos] = (char) (r.nextInt(26) + 'a');
            } else {
                arr[pos] = ' ';
            }
        }
    }

    public static void imprimir_matriz_char(char [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            imprimir_arreglo_char(mat[fila]);
        }
    }

    public static void imprimir_arreglo_char(char [] arr) {
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}
