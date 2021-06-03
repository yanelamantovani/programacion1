package EnsayoParcial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class MatrizSecuenciasEnteros {
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilidadNumeros = 0.4;

    public static void main(String[] args) {

        int maxFilas = solicitarFilasMatriz();
        int maxColumnas = solicitarColumnasMatriz();
        int [][] mat = new int[maxFilas][maxColumnas];

        cargarSecuenciasEnterosRandomMatriz(mat, maxFilas, maxColumnas);
        imprimirMatrizEnteros(mat, maxFilas, maxColumnas);

    }

    // Solicito al usuario que ingrese la cantidad de filas de la matriz
    public static int solicitarFilasMatriz() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        try {
            System.out.println("Ingrese la cantidad de filas de la matriz:");
            max = Integer.valueOf(entrada.readLine());
        } catch (Exception exc) {
            System.out.println(exc);
        }
        return max;
    }

    // Solicito al usuario que ingrese la cantidad de columnas de la matriz
    public static int solicitarColumnasMatriz() {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        try {
            System.out.println("Ingrese la cantidad de columnas de la matriz:");
            max = Integer.valueOf(entrada.readLine());
        } catch (Exception exc) {
            System.out.println(exc);
        }
        return max;
    }

    // Cargo matriz con secuencias de enteros random
    public static void cargarSecuenciasEnterosRandomMatriz (int [][] matriz, int maxFilas, int maxColumnas) {
        for (int fila = 0; fila < maxFilas; fila++) {
            cargarSecuenciasEnterosRandomArreglo(matriz[fila], maxColumnas);
        }
        System.out.println("");
    }

    // Cargo cada fila (arreglo) de la matriz con secuencias de enteros random
    public static void cargarSecuenciasEnterosRandomArreglo(int [] array, int maxColumnas) {
        Random r = new Random();
        array[0] = 0;
        array[maxColumnas - 1] = 0;
        for (int i = 1; i < maxColumnas - 1; i++) {
            if (r.nextDouble() > probabilidadNumeros) {
                array[i] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                array[i] = 0;
            }
        }
        array [maxColumnas - 2] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR); // Evito que el anteúltimo número sea un 0 y me de error al buscar la última secuencia
    }

    // Imprimo matriz de enteros
    public static void imprimirMatrizEnteros(int [][] matriz, int maxFilas, int maxColumnas) {
        for (int fila = 0; fila < maxFilas; fila++) {
            for (int columna = 0; columna < maxColumnas; columna++) {
                System.out.print("[" + matriz[fila][columna] + "]");
            }
            System.out.println("");
        }
    }
}