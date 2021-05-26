/*
OPCION SIN ARREGLOS
Hacer un programa que dado una matriz de enteros de tamanio 4*5 que se encuentra precargada,
imprima por pantalla el promedio de cada una de sus filas.
 */

package Clase8;

import java.util.Random;

public class Clase8_Ejemplo2 {
    public static final int MAXFILAS = 4;
    public static final int MAXCOLUMNAS = 5;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;

    public static void main(String[] args) {
        int [][] intMatriz = new int[MAXFILAS][MAXCOLUMNAS];
        cargarMatrizEnterosRandom(intMatriz);
        imprimirMatrizEnteros(intMatriz);
        imprimirPromediosFilas(intMatriz);
    }

    public static void cargarMatrizEnterosRandom(int [][] intMatriz) {
        Random r = new Random();
        for (int fila = 0; fila < MAXFILAS; fila++) {
            for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
                intMatriz[fila][columna] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            }
        }
    }

    public static void imprimirMatrizEnteros(int [][] intMatriz) {
        for (int fila = 0; fila < MAXFILAS; fila++) {
            for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
                System.out.print("[" + intMatriz[fila][columna] + "]");
            }
            System.out.println("");
        }
    }

    // Imprimir promedio de cada fila de la matriz
    public static void imprimirPromediosFilas(int [][] intMatriz) {
        for (int fila = 0; fila < MAXFILAS; fila++) {
            System.out.println("Promedio de la fila " + fila + " = " + promedioFila(intMatriz,fila));
        }
    }

    // Calcular promedio de una fila de la matriz (pasándola como matriz)
    public static int promedioFila(int [][] intMatriz, int fila) {
        int promedio;
        int suma = 0;
        for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
            suma += intMatriz[fila][columna];
        }
        promedio = suma / MAXCOLUMNAS;
        return promedio;
    }
}
