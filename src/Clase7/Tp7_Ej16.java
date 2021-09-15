/*
 * Hacer un programa que dado el arreglo definido y precargado elimine todas
 * las secuencias que tienen orden descendente entre sus elementos.
 */

package Clase7;

import java.util.Random;

public class Tp7_Ej16 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4D;

    public static void main(String[] args) {
        int[] arrenteros = new int[MAX];
        cargar_secuencias(arrenteros);
        imprimir_arreglo(arrenteros);
        eliminar_secuencias_orden_descendente(arrenteros);
        imprimir_arreglo(arrenteros);
    }

    public static void eliminar_secuencias_orden_descendente(int[] arr) {
        int fin = -1;
        int inicio = obtener_inicio_secuencia(arr, fin + 1);
        while (inicio < MAX - 1) {
            fin = obtener_fin_secuencia(arr, inicio);
            if (es_descendente(arr, inicio, fin)) {
                eliminar_secuencia(arr, inicio, fin);
                fin = inicio - 1;
            }
            inicio = obtener_inicio_secuencia(arr, fin + 1);
        }
    }

    public static boolean es_descendente(int[] arr, int inicio, int fin) {
        for(int pos = inicio; pos <= fin; pos++) {
            if ((arr[pos] <= arr[pos + 1]) || (inicio == fin)){
                return false;
            }
        }
        return true;
    }

    public static void eliminar_secuencia(int[] arr, int inicio, int fin) {
        for(int i = inicio; i <= fin; i++) {
            corrimientoIzq(arr, inicio);
        }
    }

    public static void corrimientoIzq(int[] arr, int inicio) {
        for(int i = inicio; i < MAX - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public static int obtener_inicio_secuencia(int [ ] arr, int pos) {
        while ((pos < MAX) && (arr[pos] == 0)) {
            pos++;
        }
        return pos;
    }

    public static int obtener_fin_secuencia(int [ ] arr, int pos) {
        while ((pos < MAX) && (arr[pos] != 0)) {
            pos++;
        }
        return pos - 1;
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
