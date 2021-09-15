package Clase7;

/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado,
 * solicite al usuario un numero entero y lo agregue al principio del arreglo (posición 0). Para ello
 * tendrá que realizar un corrimiento a derecha (se pierde el último valor del arreglo) y colocar el
 * numero en el arreglo en la posición indicada.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp7_Ej04 {
    public static final int MAX = 10;
    public static final int INICIO = 0;
    public static final int MINVALOR = 0;
    public static final int MAXVALOR = 9;

    public static void main (String [ ] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int [ ] arrenteros = new int[MAX];
        try {
            cargar_arreglo(arrenteros);
            imprimir_arreglo(arrenteros);
            System.out.println("Ingrese un numero a insertar en la primer posicion del arreglo:");
            int num = Integer.valueOf(entrada.readLine());
            insertar_num_inicio(arrenteros, num);
            imprimir_arreglo(arrenteros);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void insertar_num_inicio(int [ ] arr, int num) {
        corrimiento_der(arr, INICIO);
        arr[INICIO] = num;
    }

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
