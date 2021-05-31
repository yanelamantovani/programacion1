/*
Hacer un programa que dado la matriz definida y precargada, imprima lo que suma el
contenido de cada secuencia.
*/

package Clase8;

import java.util.Random;

public class Clase8_Ejemplo9 {
    public static final int MAXFILAS = 4;
    public static final int MAXCOLUMNAS = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilityNumber = 0.4;

    public static void main(String[] args) {
        int [][] intMatriz = new int[MAXFILAS][MAXCOLUMNAS];

        cargarMatrizSecuenciasEnteros(intMatriz);
        imprimirMatrizEnteros(intMatriz);
        imprimirSumasSecuenciasMatriz(intMatriz);
    }

    public static void cargarMatrizSecuenciasEnteros(int [][] intMatriz) {
        for (int fila = 0; fila < MAXFILAS; fila++) {
            cargarArregloSecuenciasEnteros(intMatriz[fila]);
        }
        System.out.println("");
    }

    public static void cargarArregloSecuenciasEnteros(int [] array) {
        Random r = new Random();
        array[0] = 0;
        array[MAXCOLUMNAS - 1] = 0;
        for (int i = 1; i < MAXCOLUMNAS - 1; i++) {
            if (r.nextDouble() > probabilityNumber) {
                array[i] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                array[i] = 0;
            }
        }
        array [MAXCOLUMNAS - 2] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR); // Evito que el anteúltimo número sea un 0 y me de error al buscar la última secuencia
    }

    public static void imprimirMatrizEnteros(int [][] intMatriz) {
        for (int fila = 0; fila < MAXFILAS; fila++) {
            for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
                System.out.print("[" + intMatriz[fila][columna] + "]");
            }
            System.out.println("");
        }
    }

    public static int buscarPosicionInicioSecuencia(int[][] intMatriz, int fila, int posicion) {
        while (intMatriz[fila][posicion] == 0) {
            posicion++;
        }
        return posicion;
    }

    public static int buscarPosicionFinSecuencia(int[][] intMatriz, int fila, int posicionInicio) {
        while (intMatriz[fila][posicionInicio] != 0) {
            posicionInicio++;
        }
        int posicionFin = posicionInicio - 1;
        return posicionFin;
    }

    public static void imprimirSumasSecuenciasMatriz(int[][] intMatriz) {
        for (int fila = 0; fila < MAXFILAS; fila++) {
            int posicion = 0;
            int posicionInicio = buscarPosicionInicioSecuencia(intMatriz, fila, posicion);
            while (posicionInicio < MAXCOLUMNAS) {
                int posicionFin = buscarPosicionFinSecuencia(intMatriz, fila, posicionInicio);
                int sum = 0;
                for (int i = posicionInicio; i <= posicionFin; i++){
                    sum+= intMatriz[fila][i];
                }
                System.out.println("La suma de la secuencia de posiciones " + posicionInicio + " hasta " + posicionFin + " en la fila " + fila + " es: " + sum);
                posicion = posicionFin + 1;
                if (posicion < MAXCOLUMNAS - 1) {
                    posicionInicio = buscarPosicionInicioSecuencia(intMatriz, fila, posicion);
                } else {
                    break;
                }
            }
        }
    }
}
