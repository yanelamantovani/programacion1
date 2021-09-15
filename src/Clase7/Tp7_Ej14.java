/*
 * Hacer un programa que dado el arreglo definido y precargado, y un número entero ingresado
 * por el usuario, copie de forma continua las secuencias de tamaño igual al número ingresado
 * en otro arreglo de iguales características e inicializado con 0. La copia en este último arreglo
 * deben comenzar desde el principio del mismo.
 */

package Clase7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp7_Ej14 {
    public static final int MAX = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[ ] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int [ ] arrenteros = new int[MAX];
        int [ ] arrcopia = new int[MAX];
        try {
            cargar_secuencias(arrenteros);
            imprimir_arreglo(arrenteros);
            cargar_arreglo_ceros(arrcopia);
            System.out.println("Ingrese un numero entero:");
            int num = Integer.valueOf(entrada.readLine());
            copiar_secuencias_tamanio(arrenteros, arrcopia, num);
            imprimir_arreglo(arrcopia);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void copiar_secuencias_tamanio (int [ ] arrInicial, int [ ] arrCopia, int num) {
        int tamanio;
        int inicio = 0;
        int fin = -1;
        int posCopia = 0;
        while (inicio < MAX) {
            inicio = obtener_inicio_secuencia(arrInicial, fin + 1);
            if (inicio < MAX) {
                fin = obtener_fin_secuencia(arrInicial, inicio);
                tamanio = fin - inicio + 1;
                if (num == tamanio) {
                    copiar_secuencia(arrInicial, inicio, fin, arrCopia, posCopia);
                    posCopia += tamanio;
                }
            }
        }
    }

    public static void copiar_secuencia(int [ ] arrInicial, int inicio, int fin, int [ ] arrCopia, int pos) {
        while (inicio <= fin) {
            arrCopia[pos] = arrInicial[inicio];
            inicio++;
            pos++;
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

    public static void cargar_arreglo_ceros(int [ ] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            arr[pos] = 0;
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
    }

    public static void imprimir_arreglo(int [] arr) {
        for (int pos = 0; pos < MAX; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println("");
    }
}
