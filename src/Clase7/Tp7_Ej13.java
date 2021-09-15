/*
 * Hacer un programa que dado el arreglo definido y precargado, y un número entero
 * ingresado por el usuario, elimine las secuencias de tamaño igual al número ingresado.
 */

package Clase7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp7_Ej13 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[ ] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int [ ] arrenteros = new int[MAX];
        try {
            cargar_secuencias(arrenteros);
            imprimir_arreglo(arrenteros);
            System.out.println("Ingrese un numero entero:");
            int num = Integer.valueOf(entrada.readLine());
            eliminar_secuencias_tamanio(arrenteros, num);
            imprimir_arreglo(arrenteros);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void eliminar_secuencias_tamanio(int [ ] arr, int num) {
        int fin = -1;
        int inicio = obtener_inicio_secuencia(arr, fin + 1);
        while ((inicio < MAX)) {
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
