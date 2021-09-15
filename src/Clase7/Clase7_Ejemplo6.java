package Clase7;

/*
 * Hacer un programa que dado un arreglo de enteros ordenado creciente de tamano 10 que se encuentra
 * precargado, encuentre la posicion donde se encuentra un numero entero ingresado por el usuario. Si existe,
 * muestre esa posicion por pantalla, o indique que no existe.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase7_Ejemplo6 {
    public static final int MAX = 10;
    public static void main (String [ ] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int [ ] arrenteros = new int[MAX];
        try {
            cargar_arreglo(arrenteros);
            imprimir_arreglo(arrenteros);
            System.out.println("Ingrese un numero entero:");
            int num = Integer.valueOf(entrada.readLine());
            int pos = obtener_pos_ord_crec(arrenteros, num);
            if ((pos < MAX) && (arrenteros[pos] == num)) {
                System.out.println(num + " está en la posicion " + pos);
            } else {
                System.out.println(num + " no existe en el arreglo.");
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static int obtener_pos_ord_crec(int [ ] arr, int num) {
        int pos = 0;
        while ((pos < MAX) && (arr[pos] < num)) { // Por estar ordenado en forma creciente
            pos++;
        }
        return pos; // No implica que el número esté en esa posición
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

