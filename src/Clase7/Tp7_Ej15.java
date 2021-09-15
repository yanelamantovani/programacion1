/*
 * Hacer un programa que dado el arreglo definido y precargado elimine del arreglo todas
 * las ocurrencias de una secuencia patrón dada por otro arreglo de iguales características
 * (solo tiene esa secuencia). Al eliminar se pierden los valores haciendo los corrimientos.
 */

package Clase7;

import java.util.Random;

public class Tp7_Ej15 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4;
    public static final int TAMANIOPATRON = 4;

    public static void main(String[ ] args) {
        int [ ] arrEnteros = new int[MAX];
        int [ ] arrPatron = new int[MAX];
        cargar_secuencias(arrEnteros);
        System.out.println("Arreglo inicial");
        imprimir_arreglo(arrEnteros);
        cargar_patron(arrPatron);
        System.out.println("Arreglo patron");
        imprimir_arreglo(arrPatron);
        eliminar_secuencias_patron(arrEnteros, arrPatron);
        System.out.println("Arreglo con patron eliminado");
        imprimir_arreglo(arrEnteros);
    }

    public static void eliminar_secuencias_patron (int [ ] arrInicial, int [ ] arrPatron) {
        int fin = -1;
        int inicio = obtener_inicio_secuencia(arrInicial, fin + 1);
        while (inicio < MAX - 1) {
            fin = obtener_fin_secuencia(arrInicial, inicio);
            if (son_iguales(arrInicial, arrPatron, inicio, fin)) {
                eliminar_secuencia(arrInicial, inicio, fin);
                fin = inicio - 1;
            }
            inicio = obtener_inicio_secuencia(arrInicial, fin + 1);
        }
    }

    public static boolean son_iguales(int [ ] arrInicial, int [ ] arrPatron, int inicio, int fin) {
        int posPatron = 1;
        int tamanioArr = fin - inicio + 1;
        while (inicio <= fin) {
            if ((arrInicial[inicio] == arrPatron[posPatron]) && (tamanioArr == TAMANIOPATRON)) {
                inicio++;
                posPatron++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void eliminar_secuencia(int [ ] arr, int inicio, int fin) {
        for(int i = inicio; i <= fin; i++) {
            corrimientoIzq(arr, inicio);
        }
    }

    public static void corrimientoIzq(int[] arr, int inicio) {
        for(int i = inicio; i < MAX - 1; i++) {
            arr[i] = arr[i + 1];
        }
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

    // Carga secuencia patrón “1234” al principio del arreglo
    public static void cargar_patron(int [ ] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            if ((pos > 0) && (pos < 5)) {
                arr[pos] = pos;
            } else {
                arr[pos] = 0;
            }
        }
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

        // Test:
        arr[5] = 0;
        arr[6] = 1;
        arr[7] = 2;
        arr[8] = 3;
        arr[9] = 4;
        arr[10] = 0;
    }

    public static void imprimir_arreglo(int [] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}
