/*
 * Hacer un programa que dada la matriz de secuencias de caracteres definida y precargada, permita encontrar por
 * cada fila la posición de inicio y fin de la anteúltima secuencia (considerar comenzar a buscarla a partir de la ultima posición de la fila).
 */

package Clase8;

import java.util.Random;

public class Tp8_Ej12 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 20;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[ ] args) {
        char [][] matchar = new char[MAXFILA][MAXCOLUMNA];
        cargar_matriz_secuencias_char(matchar);
        imprimir_matriz_char(matchar);
        buscar_anteultimas_secuencias_matriz(matchar);
    }

    public static void buscar_anteultimas_secuencias_matriz(char [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            System.out.println("Fila " + fila);
            buscar_anteultima_secuencia_arreglo(mat[fila]);
        }
    }

    public static void buscar_anteultima_secuencia_arreglo(char [] arr) {
        int fin = obtener_fin_secuencia(arr, MAXCOLUMNA - 1);
        int inicio = obtener_inicio_secuencia(arr, fin);
        fin = obtener_fin_secuencia(arr, inicio - 1);
        inicio = obtener_inicio_secuencia(arr, fin);
        System.out.println("La anteultima secuencia comienza en la posicion " + inicio + " y termina en la posición " + fin);
    }

    public static int obtener_inicio_secuencia(char [ ] arr, int pos) {
        while (arr[pos] != ' ') {
            pos--;
        }
        return pos + 1;
    }

    public static int obtener_fin_secuencia(char [ ] arr, int pos) {
        while (arr[pos] == ' ') {
            pos--;
        }
        return pos;
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
