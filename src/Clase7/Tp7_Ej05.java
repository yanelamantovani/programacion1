package Clase7;

/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado,
 * solicite al usuario un numero entero y elimine la primer ocurrencia de numero (un número igual)
 * en el arreglo si existe. Para ello tendrá que buscar la posición y si está, realizar un corrimiento
 * a izquierda (queda una copia de la última posición del arreglo en la anteúltima posición).
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp7_Ej05 {
    public static final int MAX = 10;
    public static final int MINVALOR = 0;
    public static final int MAXVALOR = 9;

    public static void main (String [ ] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int [ ] arrenteros = new int[MAX];
        try {
            cargar_arreglo(arrenteros);
            imprimir_arreglo(arrenteros);
            System.out.println("Ingrese un numero:");
            int num = Integer.valueOf(entrada.readLine());
            int pos = obtener_pos_arreglo(arrenteros, num);
            if (pos < MAX) {
                corrimiento_izq(arrenteros, pos);
                imprimir_arreglo(arrenteros);
            } else {
                System.out.println(num + " no existe en el arreglo.");
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static int obtener_pos_arreglo(int [ ] arr, int num) {
        int pos = 0;
        while ((pos < MAX) && (arr[pos] != num)) {
            pos++;
        }
        return pos;
    }

    public static void corrimiento_izq(int [ ] arr, int pos) {
        while (pos < MAX - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
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
