/*
 * Hacer un programa que dado el arreglo definido y precargado, imprima lo que suma el contenido de cada secuencia.
 */

import java.util.Random;

public class Clase7_Ejemplo8 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD= 0.4;

    public static void main(String[ ] args) {
        int [ ] arrenteros = new int[MAX];
        cargar_secuencias(arrenteros);
        imprimir_arreglo(arrenteros);
        imprimir_suma_cada_secuencia(arrenteros);
    }

    public static void imprimir_suma_cada_secuencia(int [ ] arr) {
        int inicio, fin, suma;
        inicio = 0;
        fin = -1;
        while ((inicio < MAX)) { // Si no llegó al final de arreglo
            inicio = obtener_inicio_secuencia(arr, fin + 1); // Ubica el inicio de la siguiente secuencia considerando la posición de fin de la secuencia anterior y sumándole 1 (separador)
            if (inicio < MAX) { // Si no llegó al final de arreglo
                fin = obtener_fin_secuencia(arr, inicio); // Ubica el final de ese secuencia considerando su posición de inicio
                suma = obtener_suma_secuencia(arr, inicio, fin);
                System.out.println("La suma de la secuencia de " + inicio + " a " + fin + " es " + suma);
            }
        }
    }

    public static int obtener_suma_secuencia(int [ ] arr, int inicio, int fin) {
        int suma = 0;
        while (inicio <= fin) {
            suma += arr[inicio];
            inicio++;
        }
        return suma;
    }

    public static int obtener_inicio_secuencia(int [ ] arr, int pos) {
        while ((pos < MAX) && (arr[pos] == 0)) {
            pos++;
        }
        return pos;
    }

    public static int obtener_fin_secuencia(int [ ] arr, int pos) {
        while ((pos < MAX) && (arr[pos] != 0)) {
            pos++;
        }
        return pos - 1;
    }

    public static void cargar_secuencias(int [ ] arr) {
        Random r = new Random();
        arr[0] = 0;
        arr[MAX - 1] = 0;
        for (int pos = 1; pos < MAX - 1; pos++) {
            if (r.nextDouble() > PROBABILIDAD) {
                arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                arr[pos] = 0;
            }
        }
    }

    public static void imprimir_arreglo(int [] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}
