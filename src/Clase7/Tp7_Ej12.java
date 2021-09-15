/*
 * Hacer un programa que dado el arreglo definido y precargado permita encontrar la posición de inicio y
 * fin de la anteúltima secuencia (considerar comenzar a buscarla a partir de la ultima posición del arreglo).
 */

package Clase7;

import java.util.Random;

public class Tp7_Ej12 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[ ] args) {
        int [ ] arrenteros = new int[MAX];
        cargar_secuencias(arrenteros);
        imprimir_arreglo(arrenteros);
        buscar_anteultima_secuencia(arrenteros);
    }

    public static void buscar_anteultima_secuencia(int [ ] arr) {
        int fin = obtener_fin_secuencia(arr, MAX - 1);
        int inicio = obtener_inicio_secuencia(arr, fin);
        fin = obtener_fin_secuencia(arr, inicio - 1);
        inicio = obtener_inicio_secuencia(arr, fin);
        System.out.println("La anteultima secuencia comienza en la posicion " + inicio + " y termina en la posición " + fin);
    }

    public static int obtener_inicio_secuencia(int [ ] arr, int pos) {
        while (arr[pos] != 0) {
            pos--;
        }
        return pos + 1;
    }

    public static int obtener_fin_secuencia(int [ ] arr, int pos) {
        while (arr[pos] == 0) {
            pos--;
        }
        return pos;
    }

    public static void cargar_secuencias(int [ ] arr) {
        Random r = new Random();
        arr[0] = 0;
        arr[MAX - 1] = 0;
        for (int pos = 1; pos < MAX - 1; pos++) {
            if (r.nextDouble() > PROBABILIDAD) {
                arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                arr[pos] = 0;
            }
        }
    }

    public static void imprimir_arreglo(int [] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}
