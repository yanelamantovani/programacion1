/*
 * Hacer un programa que dada la matriz de secuencias de caracteres definida y precargada, elimine de
 * cada fila todas las ocurrencias de una secuencia patrón dada por un arreglo de caracteres de tamaño
 * igual al tamaño de columnas de la matriz (solo tiene esa secuencia con separadores al inicio y al final).
 * Al eliminar en cada fila se pierden los valores haciendo los corrimientos.
 */

package Clase8;

import java.util.Random;

public class Tp8_Ej14 {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 20;
    public static final double PROBABILIDAD = 0.4;
    public static final int TAMANIOPATRON = 4;

    public static void main(String[ ] args) {
        char [][] matchar = new char[MAXFILA][MAXCOLUMNA];
        char [] arrPatron = new char[MAXCOLUMNA];
        cargar_matriz_secuencias_char(matchar);
        System.out.println("Matriz inicial:");
        imprimir_matriz_char(matchar);
        cargar_patron(arrPatron);
        System.out.println("Arreglo patron:");
        imprimir_arreglo_char(arrPatron);
        eliminar_secuencias_patron_matriz(matchar, arrPatron);
        System.out.println("Matriz con patron eliminado:");
        imprimir_matriz_char(matchar);
    }

    public static void eliminar_secuencias_patron_matriz (char [][] mat, char [] arrPatron) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            eliminar_secuencias_patron_arreglo(mat[fila], arrPatron);
        }
    }


    public static void eliminar_secuencias_patron_arreglo (char [] arr, char [] arrPatron) {
        int fin = -1;
        int inicio = obtener_inicio_secuencia(arr, fin + 1);
        while (inicio < MAXCOLUMNA - 1) {
            fin = obtener_fin_secuencia(arr, inicio);
            if (son_iguales(arr, arrPatron, inicio, fin)) {
                eliminar_secuencia(arr, inicio, fin);
            }
            inicio = obtener_inicio_secuencia(arr, fin + 1);
        }
    }

    public static boolean son_iguales(char [] arr, char [] arrPatron, int inicio, int fin) {
        int posPatron = 1;
        int tamanioArr = fin - inicio + 1;
        while (inicio <= fin) {
            if ((arr[inicio] == arrPatron[posPatron]) && (tamanioArr == TAMANIOPATRON)) {
                inicio++;
                posPatron++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void eliminar_secuencia(char [] arr, int inicio, int fin) {
        for(int i = inicio; i <= fin; i++) {
            corrimientoIzq(arr, inicio);
        }
    }

    public static void corrimientoIzq(char[] arr, int inicio) {
        for(int i = inicio; i < MAXCOLUMNA - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public static int obtener_inicio_secuencia(char [] arr, int pos) {
        while ((pos < MAXCOLUMNA) && (arr[pos] == ' ')) {
            pos++;
        }
        return pos;
    }

    public static int obtener_fin_secuencia(char [] arr, int pos) {
        while ((pos < MAXCOLUMNA) && (arr[pos] != ' ')) {
            pos++;
        }
        return pos - 1;
    }

    // Carga secuencia patrón “abcd” al principio del arreglo
    public static void cargar_patron(char [] arr) {
        arr[0] = ' ';
        arr[1] = 'a';
        arr[2] = 'b';
        arr[3] = 'c';
        arr[4] = 'd';
        for (int pos = 5; pos < MAXCOLUMNA; pos++) {
            arr[pos] = ' ';
        }
    }

    public static void cargar_matriz_secuencias_char(char [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo_secuencias_char(mat[fila]);
        }
        System.out.println(" ");
    }

    public static void cargar_arreglo_secuencias_char(char [] arr) {
        Random r = new Random();
        arr[0] = ' ';
        arr[MAXCOLUMNA - 1] = ' ';
        for (int pos = 1; pos < MAXCOLUMNA - 1; pos++) {
            if (r.nextDouble() > PROBABILIDAD) {
                arr[pos] = (char) (r.nextInt(26) + 'a');
            } else {
                arr[pos] = ' ';
            }
        }

        // Test
        arr[10] = ' ';
        arr[11] = 'a';
        arr[12] = 'b';
        arr[13] = 'c';
        arr[14] = 'd';
        arr[15] = ' ';
    }

    public static void imprimir_matriz_char(char [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            imprimir_arreglo_char(mat[fila]);
        }
    }

    public static void imprimir_arreglo_char(char [] arr) {
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}
