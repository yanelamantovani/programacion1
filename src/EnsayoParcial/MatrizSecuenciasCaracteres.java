package EnsayoParcial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class MatrizSecuenciasCaracteres {
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilidadLetras = 0.4;

    public static void main(String[] args) {

        int maxFilas = solicitarFilasMatriz();
        int maxColumnas = solicitarColumnasMatriz();
        char [][] mat = new char[maxFilas][maxColumnas];

        cargarSecuenciasCaracteresRandomMatriz(mat, maxFilas, maxColumnas);
        imprimirMatrizCaracteres(mat, maxFilas, maxColumnas);
        // DESARROLLAR EJERCICIO SECUENCIAS
        ejercicioSecuencias(mat, maxFilas, maxColumnas);

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

    // Cargo matriz con secuencias de caracteres random
    public static void cargarSecuenciasCaracteresRandomMatriz (char [][] matriz, int maxFilas, int maxColumnas) {
        for (int fila = 0; fila < maxFilas; fila++) {
            cargarSecuenciasCaracteresRandomArreglo(matriz[fila], maxColumnas);
        }
        System.out.println("");
    }

    // Cargo cada fila (arreglo) de la matriz con secuencias de caracteres random
    public static void cargarSecuenciasCaracteresRandomArreglo(char [] array, int maxColumnas) {
        Random r = new Random();
        array[0] = ' ';
        array[maxColumnas - 1] = ' ';
        for (int i = 1; i < maxColumnas - 1; i++) {
            if (r.nextDouble() > probabilidadLetras) {
                array[i] = (char) (r.nextInt(26) + 'a');
            } else {
                array[i] = ' ';
            }
        }
    }

    // Imprimo matriz de caracteres
    public static void imprimirMatrizCaracteres(char [][] matriz, int maxFilas, int maxColumnas) {
        for (int fila = 0; fila < maxFilas; fila++) {
            for (int columna = 0; columna < maxColumnas; columna++) {
                System.out.print("[" + matriz[fila][columna] + "]");
            }
            System.out.println("");
        }
    }

    // DESARROLLAR EJERCICIO SECUENCIAS
    private static void ejercicioSecuencias(char[][] matriz, int maxFilas, int maxColumnas) {
        for (int fila = 0; fila < maxFilas; fila++) {
            int inicio = 0;
            while (existeSecuencia(matriz, inicio, fila, maxColumnas)) {
                inicio = buscarPosicionInicioSecuencia(matriz, inicio, fila, maxColumnas);
                int fin = buscarPosicionFinSecuencia(matriz, inicio, fila, maxColumnas);
                System.out.println("fila " + fila + " inicio " + inicio + " fin " + fin);
                inicio = fin;
            }
        }
    }

    // Retorna true si existe una secuencia a partir de la posicion
    public static boolean existeSecuencia(char[][] matriz, int posicionInicio, int fila, int maxColumnas) {
        for (int i = posicionInicio; i < maxColumnas; i++) {
            if (matriz[fila][i] != ' ') {
                return true;
            }
        }
        return false;
    }

    // Busca posicion de inicio de una secuencia
    public static int buscarPosicionInicioSecuencia(char[][] matriz, int posicion, int fila, int maxColumnas) {
        while (matriz[fila][posicion] == ' ' && posicion < maxColumnas - 1) {
            posicion++;
        }
        return posicion;
    }

    // Busca posicion final de una secuencia
    public static int buscarPosicionFinSecuencia(char[][] matriz, int posicion, int fila, int maxColumnas) {
        while (matriz[fila][posicion] != ' ' && posicion < maxColumnas - 1) {
            posicion++;
        }
        return posicion;
    }
}