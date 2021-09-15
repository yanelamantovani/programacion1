/*
 * Se tiene una matriz de caracteres separadas por espacios, que tiene distinta cantidad de filas y columnas.
 * La matriz está precargada (no implementar el método de carga), y además cada fila empieza y termina con uno
 * o más separadores espacios. Se pide realizar un programa que:
 * _elimine de cada fila la secuencia previa (si hay) y la secuencia posterior (si hay) a la secuencia central
 * (central porque justo al medio del arreglo está parte de esa secuencia).
 */

package Recursos;

import java.util.Random;

public class Final {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 20;
    public static final double PROBABILIDAD = 0.4;
    public static final int CENTRO = MAXCOLUMNA / 2;

    public static void main (String[] args) {
        char [][] matchar = new char[MAXFILA][MAXCOLUMNA];
        System.out.println("Arreglo inicial");
        cargar_matriz_secuencias_char(matchar); // Metodo dado
        imprimir_matriz_char(matchar); // Metodo dado
        System.out.println("Arreglo sin las secuencias previa y posterior a la secuencia central");
        eliminar_secuencias_previa_posterior(matchar);
        imprimir_matriz_char (matchar); // Metodo dado
    }

    public static void eliminar_secuencias_previa_posterior(char [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            eliminar_secuencias_previa_posterior_fila(mat[fila]);
        }
    }

    public static void eliminar_secuencias_previa_posterior_fila(char [] arr) {
        if (arr[CENTRO] != ' ') {
            int inicio = obtener_inicio_secuencia_hacia_atras(arr, CENTRO);
            int fin = obtener_fin_secuencia(arr, CENTRO);
            if (existe_posterior(arr, fin)) {
                eliminar_secuencia_posterior(arr,fin);
            }
            if (existe_anterior(arr, inicio - 1)) {
                eliminar_secuencia_anterior(arr, inicio - 1);
            }
        }
    }

    public static void eliminar_secuencia_anterior(char [] arr, int pos) {
        int fin = obtener_fin_secuencia_hacia_atras(arr, pos);
        int inicio = obtener_inicio_secuencia_hacia_atras(arr, fin);
        for (int i = inicio; i <= fin; i++) {
            corrimiento_izq(arr, inicio);
        }
    }

    public static boolean existe_anterior(char [] arr, int pos) {
        return obtener_fin_secuencia_hacia_atras(arr, pos) < MAXCOLUMNA;
    }

    public static int obtener_fin_secuencia_hacia_atras(char [] arr, int pos) {
        while ((pos < MAXCOLUMNA) && (arr[pos] == ' ')) {
            pos--;
        }
        return pos;
    }

    public static void eliminar_secuencia_posterior(char [] arr, int pos) {
        int inicio = obtener_inicio_secuencia(arr, pos + 1);
        int fin = obtener_fin_secuencia(arr, inicio);
        for (int i = inicio; i <= fin; i++) {
            corrimiento_izq(arr, inicio);
        }
    }

    public static void corrimiento_izq(char [] arr, int pos) {
        while (pos < MAXCOLUMNA - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }

    public static boolean existe_posterior(char [] arr, int pos) {
        return obtener_inicio_secuencia(arr, pos + 1) < MAXCOLUMNA;
    }

    public static int obtener_inicio_secuencia(char [] arr, int pos) {
        while ((pos < MAXCOLUMNA) && (arr[pos] == ' ')) {
            pos++;
        }
        return pos;
    }

    public static int obtener_inicio_secuencia_hacia_atras(char [] arr, int pos) {
        while ((pos < MAXCOLUMNA) && (arr[pos] != ' ')) {
            pos--;
        }
        return pos + 1;
    }

    public static int obtener_fin_secuencia(char [] arr, int pos) {
        while((pos < MAXCOLUMNA) && (arr[pos] != ' ')) {
            pos++;
        }
        return pos - 1;
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
        System.out.println(" ");
    }
}
