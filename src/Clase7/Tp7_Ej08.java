package Clase7;

/*
 * Hacer un programa que dado un arreglo ordenado creciente de enteros de tamaño 10 que se encuentra precargado,
 * solicite al usuario un numero entero y elimine la primer ocurrencia de numero (un número igual) en el arreglo
 * si existe.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp7_Ej08 {
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
            int pos = obtener_pos_ord_crec(arrenteros, num);
            if ((pos < MAX) && (arrenteros[pos] == num)) {
                corrimiento_izq(arrenteros, pos);
                imprimir_arreglo(arrenteros);
            } else {
                System.out.println(num + " no existe en el arreglo.");
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static int obtener_pos_ord_crec(int [ ] arr, int num) {
        int pos = 0;
        while ((pos < MAX) && (arr[pos] < num)) {
            pos++;
        }
        return pos;
    }

    public static void corrimiento_izq(int [ ] arr, int pos) {
        for(int i = pos; i < MAX - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public static void cargar_arreglo(int[] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
        }
        ordenar_arreglo(arr);
    }

    public static void ordenar_arreglo(int[] arr) {
        int posMenor, temp;
        for (int i = 0; i < MAX; i++) {
            posMenor = i;
            for (int j = i + 1; j < MAX; j++) {
                if (arr[j] < arr[posMenor]) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                temp = arr[i];
                arr[i] = arr[posMenor];
                arr[posMenor] = temp;
            }
        }
    }

    public static void imprimir_arreglo(int[] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}
