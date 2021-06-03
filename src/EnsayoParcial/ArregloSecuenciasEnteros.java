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
        array [max - 2] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR); // Evito que el anteúltimo número sea un 0 y me de error al buscar la última secuencia
    }

    // Imprimo array de enteros
    public static void imprimirArrayEnteros(int [] array, int max) {
        for (int i = 0; i < max; i++) {
            System.out.print("[" + array[i] + "]");
        }
    }
}