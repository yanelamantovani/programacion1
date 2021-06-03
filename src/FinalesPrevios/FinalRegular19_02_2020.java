/*
Final regular Programación 1 – TUDAI 19/2/2020
Dado un arreglo ARR de tamaño N de secuencias de enteros separadas por uno o más ceros, hacer un programa que
extraiga todas las secuencias con cantidad par de elementos y las copie en un arreglo PAR de enteros de tamaño N
(quedando separadas por un 0).
Observaciones generales:
_ARR está cargado inicialmente y PAR está inicializado con ceros.
_No se pueden utilizar estructuras auxiliares.
_Puede haber uno o más ceros al principio y al final del arreglo.
_Realizar el programa completo bien modularizado.
 */

package FinalesPrevios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class FinalRegular19_02_2020 {
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilityNumber = 0.4;

    public static void main(String[] args) {

        int max = solicitarTamanioArreglo();
        int [] arr = new int[max];
        int [] par = new int[max];

        System.out.println("Array inicial:");
        cargarSecuenciasEnterosRandomArray(arr, max);
        // int [] arr = {0, 1, 2, 0, 1, 2, 3, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 5, 0, 0};
        imprimirArrayEnteros(arr, max);

        System.out.println("Array par:");
        incializarArrayPar(par, max);
        extraerSecuenciasCantidadPar(arr, par, max);
        imprimirArrayEnteros(par, max);
    }

    // Solicito al usuario que ingrese el tamanio del arreglo
    public static int solicitarTamanioArreglo() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        try {
            System.out.println("Ingrese el tamaño del arreglo:");
            max = Integer.valueOf(entrada.readLine());
        } catch (Exception exc) {
            System.out.println(exc);
        }
        return max;
    }

    // Cargo un array con secuencias de enteros random
    public static void cargarSecuenciasEnterosRandomArray(int [] array, int max) {
        Random r = new Random();
        array[0] = 0;
        array[max - 1] = 0;
        for (int i = 1; i < max - 1; i++) {
            if (r.nextDouble() > probabilityNumber) {
                array[i] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                array[i] = 0;
            }
        }
    }

    // Imprimo array de enteros
    public static void imprimirArrayEnteros(int [] array, int max) {
        for (int i = 0; i < max; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println("");
    }

    // Inicializo con ceros el array "par"
    public static void incializarArrayPar(int [] array, int max) {
        for (int i = 0; i < max; i++) {
            array[i] = 0;
        }
    }

    // Extraigo las secuencias con cantidad par de elementos y las copio en el arreglo par
    public static void extraerSecuenciasCantidadPar(int [] array, int [] par, int max) {
        int inicio = 0;
        int indicePares = 0;
        while (existeSecuencia(array, inicio)) {
            inicio = buscarPosicionInicioSecuencia(array, inicio);
            int fin = buscarPosicionFinSecuencia(array, inicio);
            if (esPar(inicio, fin)) {
                for (int i = inicio; i <= fin; i++) {
                    indicePares++;
                    par[indicePares] = array[i];
                }
            }
            inicio = fin;
        }
    }

    // Retorno true si la secuencia tiene cantidad de elementos par
    private static boolean esPar(int inicio, int fin) {
        return (fin - inicio) % 2 == 0;
    }

    // Retorno true si existe una secuencia a partir de la posicion
    public static boolean existeSecuencia(int[] array, int posicionInicio) {
        for (int i = posicionInicio; i < array.length; i++) {
            if (array[i] != 0) {
                return true;
            }
        }
        return false;
    }

    // Busco posicion de inicio de una secuencia
    public static int buscarPosicionInicioSecuencia(int[] array, int posicion) {
        while (array[posicion] == 0 && posicion < array.length - 1) {
            posicion++;
        }
        return posicion;
    }

    // Busco posicion final de una secuencia
    public static int buscarPosicionFinSecuencia(int[] array, int posicion) {
        while (array[posicion] != 0 && posicion < array.length - 1) {
            posicion++;
        }
        return posicion;
    }
}
