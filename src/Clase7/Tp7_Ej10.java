/*
 * Se tiene un arreglo de enteros de tamaño 20 de secuencias de números entre 1 y 9, separadas por 0.
 * El arreglo esta precargado, y además empieza y termina con uno o más separadores 0. Considere para los
 * siguientes ejercicios este tipo de arreglo.
 * Hacer un programa que dado el arreglo definido y precargado permita obtener a través de métodos la
 * posición de inicio y la posición de fin de la secuencia ubicada a partir de una posición entera ingresada
 * por el usuario. Finalmente, si existen imprima por pantalla ambas posiciones obtenidas.
 */

package Clase7;

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp7_Ej10 {
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
            System.out.println("Ingrese una posicion (entre 0 y 19):");
            int pos = Integer.valueOf(entrada.readLine());
            int posInicio = obtener_inicio_siguiente_secuencia(arrenteros, pos);
            int posFin = obtener_fin_secuencia(arrenteros, posInicio);
            if (posInicio < MAX) {
                System.out.println("La siguiente secuencia inicia en la posicion " + posInicio + " y finaliza en la posicion " + posFin);
            } else {
                System.out.println("No hay una secuencia siguiente a la posición ingresada.");
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static int obtener_inicio_siguiente_secuencia(int [ ] arr, int pos) {
        if ((arr[pos] != 0)) {
            pos = obtener_fin_secuencia(arr, pos) + 1;
        }
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

