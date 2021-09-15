package Clase7;

/*
 * Hacer un programa que dado un arreglo ordenado creciente de enteros de tamaño 10 que se encuentra precargado,
 * solicite al usuario un numero entero y lo inserte en el arreglo manteniendo su orden. Para ello tendrá que
 * realizar un corrimiento a derecha (se pierde el último valor del arreglo) y colocar el numero en el arreglo
 * en la posición indicada.
 */

import java.io.BufferedReader;
import java.util.Random;
import java.io.InputStreamReader;

public class Tp7_Ej07 {
    public static final int MAX = 10;
    public static final int MINVALOR = 0;
    public static final int MAXVALOR = 9;

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int[] arrenteros = new int[MAX];
        try {
            cargar_arreglo(arrenteros);
            imprimir_arreglo(arrenteros);
            System.out.println("Ingrese un numero:");
            int num = Integer.valueOf(entrada.readLine());
            int pos = obtener_pos_ord_crec(arrenteros, num);
            if (pos < MAX) {
                insertar_num_pos(arrenteros, pos, num);
                imprimir_arreglo(arrenteros);
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static int obtener_pos_ord_crec(int[] arr, int num) {
        int pos = 0;
        while ((pos < MAX) && (arr[pos] < num)) {
            pos++;
        }
        return pos;
    }

    public static void insertar_num_pos(int [ ] arr, int pos, int num) {
        corrimiento_der(arr, pos);
        arr[pos] = num;
    }

    public static void corrimiento_der(int [ ] arr, int pos) {
        int indice = MAX - 1;
        while (indice > pos) {
            arr[indice] = arr[indice - 1];
            indice--;
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
