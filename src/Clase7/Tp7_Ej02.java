package Clase7;

/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado,
 * obtenga la cantidad de números pares que tiene y la imprima.
 */

import java.util.Random;

public class Tp7_Ej02 {
    public static final int MAX = 10;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main(String[ ] args) {
        int [ ] arrenteros = new int[MAX];
        cargar_arreglo(arrenteros);
        imprimir_arreglo(arrenteros);
        System.out.println("La cantidad de números pares del arreglo es: " + obtener_cantidad_pares(arrenteros));
    }

    public static int obtener_cantidad_pares(int [ ] arr) {
        int cantPares = 0;
        for (int pos = 0; pos < MAX; pos++) {
            if (arr[pos] % 2 == 0) {
                cantPares++;
            }
        }
        return cantPares;
    }

    public static void cargar_arreglo(int [] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
        }
    }

    public static void imprimir_arreglo(int [] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}

