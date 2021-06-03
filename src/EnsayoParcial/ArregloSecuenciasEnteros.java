package EnsayoParcial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ArregloSecuenciasEnteros {
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilidadNumeros = 0.4;

    public static void main(String[] args) {

        int max = solicitarTamanioArreglo();
        int [] arr = new int[max];

        cargarSecuenciasEnterosRandomArray(arr, max);
        imprimirArrayEnteros(arr, max);
        // DESARROLLAR EJERCICIO SECUENCIAS
        ejercicioSecuencias(arr, max);

    }

    // Solicita al usuario que ingrese el tamanio del arreglo
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

    // Carga un array con secuencias de enteros random
    public static void cargarSecuenciasEnterosRandomArray (int [] array, int max) {
        Random r = new Random();
        array[0] = 0;
        array[max - 1] = 0;
        for (int i = 1; i < max - 1; i++) {
            if (r.nextDouble() > probabilidadNumeros) {
                array[i] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                array[i] = 0;
            }
        }
    }

    // Imprime array de enteros
    public static void imprimirArrayEnteros(int [] array, int max) {
        for (int i = 0; i < max; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println("");
    }

    // DESARROLLAR EJERCICIO SECUENCIAS
    private static void ejercicioSecuencias(int[] array, int max) {
        int inicio = 0;
        while (existeSecuencia(array, inicio, max)) {
            inicio = buscarPosicionInicioSecuencia(array, inicio, max);
            int fin = buscarPosicionFinSecuencia(array, inicio, max);
            inicio = fin;
        }
    }

    // Retorna true si existe una secuencia a partir de la posicion
    public static boolean existeSecuencia(int[] array, int posicionInicio, int max) {
        for (int i = posicionInicio; i < max; i++) {
            if (array[i] != 0) {
                return true;
            }
        }
        return false;
    }

    // Busca posicion de inicio de una secuencia
    public static int buscarPosicionInicioSecuencia(int[] array, int posicion, int max) {
        while (array[posicion] == 0 && posicion < max - 1) {
            posicion++;
        }
        return posicion;
    }

    // Busca posicion final de una secuencia
    public static int buscarPosicionFinSecuencia(int[] array, int posicion, int max) {
        while (array[posicion] != 0 && posicion < max - 1) {
            posicion++;
        }
        return posicion;
    }
}