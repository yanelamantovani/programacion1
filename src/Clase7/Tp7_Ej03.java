package Clase7;

/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado,
 * solicite al usuario una posición y realice un corrimiento a izquierda o hacia la menor posición del arreglo.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp7_Ej03 {
    public static final int MAX = 10;
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
            corrimiento_izq(arrenteros, pos);
            imprimir_arreglo(arrenteros);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void corrimiento_izq(int [ ] arr, int pos) {
        int indice = 0;
        while (indice < pos) {
            arr[indice] = arr[indice + 1];
            indice++;
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
