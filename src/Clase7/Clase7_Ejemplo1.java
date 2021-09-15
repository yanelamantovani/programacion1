package Clase7;

/* Hacer un programa que cargue en un arreglo de enteros 5 valores desde teclado y lo imprima. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase7_Ejemplo1 {
    public static final int MAX = 5;

    public static void main (String [] args) {
        int [] arrenteros = new int [MAX];
        cargar_arreglo(arrenteros);
        imprimir_arreglo(arrenteros);
    }

    public static void cargar_arreglo(int [] arr) {
        BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
        try {
            for (int pos = 0; pos < MAX; pos++) {
                System.out.println("Ingrese un valor entero para la posición " + pos);
                arr[pos] = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void imprimir_arreglo(int [] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}
