/*
 * Hacer un programa que dado el arreglo definido y precargado permita encontrar la posición de inicio y]
 * fin de la secuencia cuya suma de valores sea mayor.
 */

package Clase7;

import java.util.Random;

public class Tp7_Ej11 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[ ] args) {
        int [ ] arrenteros = new int[MAX];
        cargar_secuencias(arrenteros);
        imprimir_arreglo(arrenteros);
        buscar_secuencia_suma_mayor(arrenteros);
    }

    public static void buscar_secuencia_suma_mayor(int [ ] arr) {
        int suma;
        int inicio = 0;
        int fin = -1;
        int sumaMayor = 0;
        int sumaMayorInicio = 0;
        int sumaMayorFin = 0;
        while (inicio < MAX) {
            inicio = obtener_inicio_secuencia(arr, fin + 1);
            if (inicio < MAX) {
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
