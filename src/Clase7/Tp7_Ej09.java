package Clase7;

/*
 * Hacer un programa que dado un arreglo de enteros de tamaño 10 que se encuentra precargado, solicite
 * al usuario el ingreso de dos números enteros (posiciones del arreglo) y ordene de forma creciente el
 * arreglo entre dos posiciones correspondientes a los números ingresados.
 */

import java.io.BufferedReader;
import java.util.Random;
import java.io.InputStreamReader;

public class Tp7_Ej09 {
    public static final int MAX = 10;
    public static final int MINVALOR = 0;
    public static final int MAXVALOR = 9;

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int[] arrenteros = new int[MAX];
        try {
            cargar_arreglo(arrenteros);
            imprimir_arreglo(arrenteros);
            System.out.println("Ingrese la posición inicial (entre 0 y 9):");
            int posInicio = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese la posición final (entre 0 y 9):");
            int posFin = Integer.valueOf(entrada.readLine());
            ordenar_entre_pos(arrenteros, posInicio, posFin);
            imprimir_arreglo(arrenteros);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void ordenar_entre_pos(int[] arr, int posInicio, int posFin) {
        int posMenor, aux;
        for (int i = posInicio; i <= posFin; i++) {
            posMenor = i;
            for (int j = i + 1; j <= posFin; j++) {
                if (arr[j] < arr[posMenor]) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                aux = arr[i];
                arr[i] = arr[posMenor];
                arr[posMenor] = aux;
            }
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