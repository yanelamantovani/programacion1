/*
 * Hacer un programa que dado la matriz definida y precargada, imprima lo que suma el
 * contenido de cada secuencia.
 */

package Clase8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Clase8_Ejemplo9 {
    public static final int MAX = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        int[] desordenado = new int[MAX];
        int[] ordenado = new int[MAX];
        try {
            // punto A
            cargar_arreglo_int(desordenado);
            imprimir_arreglo_int(desordenado);
            inicializar_arreglo_int(ordenado);
            cargar_arreglo_indices_ord(desordenado, ordenado);
            imprimir_arreglo_int(ordenado);
            // punto B
            System.out.println("Ingrese una posicion de un arreglo de tamanio " + MAX);
            int pos = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese un elemento entre " + MINVALOR + " y " + MAXVALOR);
            int elemento = Integer.valueOf(entrada.readLine());
            if ((elemento >= MINVALOR) && (elemento <= MAXVALOR) && ((elemento % 2) != 0) && (pos >= 0) && (pos <= MAX)) {
                insertar_elemento_arreglo_pos(desordenado, elemento, pos);
                actualizar_arreglo_indices(ordenado, pos);
                imprimir_arreglo_int(desordenado);
                imprimir_arreglo_int(ordenado);
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    // Inserta el numero ingresado en DESORDENADO en la posicion ingresada
    public static void insertar_elemento_arreglo_pos(int [] arrOriginal, int elemento, int pos) {
        corrimiento_der(arrOriginal, pos);
        arrOriginal[pos] = elemento;
    }

    // Solo desplaza (incrementa en 1) los valores en ORDENADO iguales o mayores a los de la posicion ingresada
    public static void actualizar_arreglo_indices(int [] arrIndices, int pos) {
        int posicion = 0;
        while ((posicion < MAX) && (arrIndices[posicion] != -1)) {
            if (arrIndices[posicion] >= pos) {
                arrIndices[posicion]++;
                if (arrIndices[posicion] >= MAX) {
                    corrimiento_izq(arrIndices, posicion);
                }
            }
            posicion++;
        }
    }

    public static void corrimiento_izq(int [ ] arr, int pos) {
        while (pos < MAX - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }

    // Carga los índices de valores pares de DESORDENADO en ORDENADO en forma ascendente según sus valores
    public static void cargar_arreglo_indices_ord(int[] arrOriginal, int[] arrIndices) {
        // Por cada pos de original ver si el arr[pos] es par
        for (int pos = 0; pos < MAX; pos++) {
            // Si es par insertarlo en forma ordenada ascendente en el otro arreglo
            if ((arrOriginal[pos] % 2) == 0) {
                insertar_ordenado_arreglo_pos(arrOriginal, arrIndices, pos);
            }
        }
    }

    // Inserta en forma ascendente en DESORDENADO los índices de valores pares
    public static void insertar_ordenado_arreglo_pos(int[] arrOriginal, int[] arrIndices, int pos) {
        // Buscar la posición en la que insertar el índice
        // pos = índice de DESORDENADO donde está el elemento
        // posicion = índice de ORDENADO (arrIndices) para recorrerlo
        int posicion = buscar_pos_arreglo_ord(arrOriginal, arrIndices, pos);
        if (posicion < MAX) {
            corrimiento_der(arrIndices, posicion);
            arrIndices[posicion] = pos;
        }
    }

    // Busca la posición en la que se debe ubicar un índice que hace referencia a un valor de otro arreglo
    public static int buscar_pos_arreglo_ord(int[] arrOriginal, int[] arrIndices, int pos) {
        int posicion = 0;
        while ((posicion < MAX) && (arrIndices[posicion] != -1) && (arrOriginal[arrIndices[posicion]] < arrOriginal[pos])) {
            posicion++;
        }
        return posicion;
    }

    public static void corrimiento_der(int[] arr, int pos) {
        int indice = MAX - 1;
        while (indice > pos) {
            arr[indice] = arr[indice - 1];
            indice--;
        }
    }

    public static void inicializar_arreglo_int(int[] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = -1;
        }
    }

    public static void imprimir_arreglo_int(int[] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println(" ");
    }

    public static void cargar_arreglo_int(int[] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
        }
    }
}