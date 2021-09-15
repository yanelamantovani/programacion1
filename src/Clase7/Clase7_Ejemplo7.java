package Clase7;

/*
 * Cargar arreglo de secuencias aleatorias de enteros y caracteres.
 */

import java.util.Random;

public class Clase7_Ejemplo7 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4;

    public static void main (String [ ] args) {
        int [] arrenteros = new int[MAX];
        cargar_secuencias_int(arrenteros);
        imprimir_arreglo_int(arrenteros);
        char [] arrchar = new char[MAX];
        cargar_secuencias_char(arrchar);
        imprimir_arreglo_char(arrchar);
    }

    public static void cargar_secuencias_int(int [ ] arr) {
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

    public static void cargar_secuencias_char(char [] arr) {
        Random r = new Random();
        arr[0] = ' ';
        arr[MAX - 1] = ' ';
        for (int pos = 1; pos < MAX - 1; pos++) {
            if (r.nextDouble() > PROBABILIDAD) {
                arr[pos] = (char) (r.nextInt(26) + 'a');
            } else {
                arr[pos] = ' ';
            }
        }
    }

    public static void imprimir_arreglo_int(int [] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }

    public static void imprimir_arreglo_char(char [] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}

