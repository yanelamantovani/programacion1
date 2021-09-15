package Clase7;

/*
 * Hacer un programa que dado un arreglo de enteros de tamanio 8 que se encuentra precargado,
 * solicite al usuario una posicion y realice un corrimiento a derecha o hacia la mayor posicion
 * del arreglo. Ademas imprima el arreglo antes y despues del corrimiento.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Clase7_Ejemplo5 {
    public static final int MAX = 8;
    public static final int MINVALOR = 0;
    public static final int MAXVALOR = 9;

    public static void main (String [ ] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int [ ] arrenteros = new int[MAX];
        try {
            cargar_arreglo(arrenteros);
            imprimir_arreglo(arrenteros);
            System.out.println("Ingrese una posicion:");
            int pos = Integer.valueOf(entrada.readLine());
            corrimiento_der(arrenteros, pos);
            imprimir_arreglo(arrenteros);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    /*
     * Corrimiento a derecha: se recorre el arreglo de derecha a izquierda, copiando en pos el valor de pos -1.
     * Se pierde el último valor y queda repetido el que está en la posición inicial.
     */
    public static void corrimiento_der(int [ ] arr, int pos) {
        int indice = MAX - 1;
        while (indice > pos) {
            arr[indice] = arr[indice - 1];
            indice--;
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
