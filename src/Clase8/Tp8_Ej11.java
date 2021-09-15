/*
 * Hacer un programa que dada la matriz de secuencias de enteros definida y precargada permita encontrar por
 * cada fila la posición de inicio y fin de la secuencia cuya suma de valores sea mayor.
 */

package Clase8;

import java.util.Random;

public class Tp8_Ej11 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[ ] args) {
        int [][] matint = new int[MAXFILA][MAXCOLUMNA];
        cargar_matriz_secuencias_int(matint);
        imprimir_matriz_int(matint);
        buscar_secuencias_suma_mayor_matriz(matint);
    }

    public static void buscar_secuencias_suma_mayor_matriz(int [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            System.out.println("Fila " + fila);
            buscar_secuencia_suma_mayor_arreglo(mat[fila]);
        }
    }

    public static void buscar_secuencia_suma_mayor_arreglo(int [] arr) {
        int suma;
        int inicio = 0;
        int fin = -1;
        int sumaMayor = 0;
        int sumaMayorInicio = 0;
        int sumaMayorFin = 0;
        while (inicio < MAXCOLUMNA) {
            inicio = obtener_inicio_secuencia(arr, fin + 1);
            if (inicio < MAXCOLUMNA) {
                fin = obtener_fin_secuencia(arr, inicio);
                suma = obtener_suma_secuencia(arr, inicio, fin);
                if (suma > sumaMayor) {
                    sumaMayor = suma;
                    sumaMayorInicio = inicio;
                    sumaMayorFin = fin;
                }
            }
        }
        System.out.println("La secuencia cuya suma de sus valores es mayor comienza en la posicion " + sumaMayorInicio + " y termina en la posición " + sumaMayorFin);
    }

    public static int obtener_suma_secuencia(int [ ] arr, int inicio, int fin) {
        int suma = 0;
        while (inicio <= fin) {
            suma += arr[inicio];
            inicio++;
        }
        return suma;
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
