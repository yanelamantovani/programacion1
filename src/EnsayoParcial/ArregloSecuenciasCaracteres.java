package EnsayoParcial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class ArregloSecuenciasCaracteres {
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilidadLetras = 0.4;

    public static void main(String[] args) {

        int max = solicitarTamanioArreglo();
        char [] arr = new char[max];

        cargarSecuenciasCaracteresRandomArray(arr, max);
        imprimirArrayCaracteres(arr, max);

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

    // Cargo un array con secuencias de caracteres random
    public static void cargarSecuenciasCaracteresRandomArray (char [] array, int max) {
        Random r = new Random();
        array[0] = ' ';
        array[max - 1] = ' ';
        for (int i = 1; i < max - 1; i++) {
            if (r.nextDouble() > probabilidadLetras) {
                array[i] = (char) (r.nextInt(26) + 'a');
            } else {
                array[i] = ' ';
            }
        }
        array [max - 2] = (char) (r.nextInt(26) + 'a'); // Evito que el anteúltimo número sea un espacio y me de error al buscar la última secuencia
    }

    // Imprimo array de caracteres
    public static void imprimirArrayCaracteres(char [] array, int max) {
        for (int i = 0; i < max; i++) {
            System.out.print("[" + array[i] + "]");
        }
    }
}
