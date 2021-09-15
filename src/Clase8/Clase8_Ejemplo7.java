/*
 * Ordenar por selección por filas y por columnas de la matriz.
 */

package Clase8;

import java.util.Random;

public class Clase8_Ejemplo7 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 5;
    public static final int MINVALOR = 1;
    public static final int MAXVALOR = 9;

    public static void main (String [ ] args) {
        int [ ][ ] matint = new int[MAXFILA][MAXCOLUMNA];
        cargar_matriz(matint);
        System.out.println("Matriz inicial");
        imprimir_matriz(matint);
        ordenar_filas(matint);
        System.out.println("Matriz ordenada por filas");
        imprimir_matriz(matint);
        ordenar_columnas(matint);
        System.out.println("Matriz ordenada por columnas");
        imprimir_matriz(matint);
    }

    public static void ordenar_columnas(int [ ][ ] mat) {
        int posMenor, temp;
        for (int columna = 0; columna < MAXCOLUMNA; columna++) {
            for (int i = 0; i < MAXFILA; i++) {
                posMenor = i;
                for (int j = i + 1; j < MAXFILA; j++) {
                    if (mat[j][columna] < mat[posMenor][columna]) {
                        posMenor = j;
                    }
                }
                if (posMenor != i) {
                    temp = mat[i][columna];
                    mat[i][columna] = mat[posMenor][columna];
                    mat[posMenor][columna] = temp;
                }
            }
        }
    }

    public static void ordenar_filas(int [ ][ ] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            ordenar_arreglo_seleccion(mat[fila]);
        }
    }

    public static void ordenar_arreglo_seleccion(int [ ] arr) {
        int posMenor, temp;
        for (int i = 0; i < MAXCOLUMNA; i++) {
            posMenor = i;
            for (int j = i + 1; j < MAXCOLUMNA; j++) {
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

    public static void cargar_matriz (int [][] mat) {
        Random r = new Random();
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo(mat[fila]);
        }
    }

    public static void cargar_arreglo(int [] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
        }
    }

    public static void imprimir_matriz(int [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            imprimir_arreglo(mat[fila]);
        }
    }

    public static void imprimir_arreglo(int [] arr) {
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}
