package Clase7;

/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado,
 * encuentre la posición de un numero entero ingresado por el usuario. Si existe, muestre esa posición
 * por pantalla, o indique que no existe.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Clase7_Ejemplo4 {
    public static final int MAX = 10;
    public static final int MINVALOR = 0;
    public static final int MAXVALOR = 9;

    public static void main (String [ ] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int [ ] arrenteros = new int[MAX];
        try {
            cargar_arreglo(arrenteros);
            imprimir_arreglo(arrenteros);
            System.out.println("Ingrese un numero entero:");
            int numero = Integer.valueOf(entrada.readLine());
            int pos = obtener_pos_arreglo(arrenteros, numero);
            if (pos < MAX) {
                System.out.println(numero + " está en la posición " + pos);
            } else {
                System.out.println(numero + " no existe.");
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static int obtener_pos_arreglo(int [ ] arr, int numero) {
        int posicion = 0;
        while ((posicion < MAX) && (arr[posicion] != numero)) { // While porque se desconoce la posición y hay una doble condición
            posicion++;
        }
        return posicion;
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
