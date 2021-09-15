/*
 * Hacer un programa que dada la matriz de secuencias de enteros definida y precargada,
 * permita obtener a través de métodos la posición de inicio y la posición de fin de la
 * secuencia ubicada a partir de una posición entera y una fila, ambas ingresadas por el usuario.
 * Finalmente, si existen imprima por pantalla ambas posiciones obtenidas.
 */

package Clase8;

import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp8_Ej10 {
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
            System.out.println("Ingrese una fila:");
            int fila = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese una posicion:");
            int pos = Integer.valueOf(entrada.readLine());
            int posInicio = obtener_inicio_siguiente_secuencia(matint[fila], pos);
            int posFin = obtener_fin_secuencia(matint[fila], posInicio);
            if (posInicio < MAXCOLUMNA) {
                System.out.println("La siguiente secuencia inicia en la fila " + fila + " posicion " + posInicio + " y finaliza en la posicion " + posFin);
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