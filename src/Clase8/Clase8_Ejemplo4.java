/*
NO SE PUEDE RESOLVER CON ARREGLOS
Hacer un programa que dado una matriz de enteros de tamanio 4*5 que se encuentra precargada,
imprima por pantalla el promedio de cada una de sus columnas.
 */

package Clase8;

import java.util.Random;

public class Clase8_Ejemplo4 {
    public static final int MAXFILAS = 4; // Dimensiones de la matriz
    public static final int MAXCOLUMNAS = 5;
    public static final int MAXVALOR = 9; // Máximo del random
    public static final int MINVALOR = 1;

    public static void main(String[] args) {
        int [][] intMatriz = new int[MAXFILAS][MAXCOLUMNAS];
        cargarMatrizEnterosRandom(intMatriz);
        imprimirMatrizEnteros(intMatriz);
        imprimirPromediosColumnas(intMatriz);
    }

    // Cargar matriz de enteros aleatorios
    public static void cargarMatrizEnterosRandom(int [][] intMatriz) {
        Random r = new Random();
        for (int fila = 0; fila < MAXFILAS; fila++) {
            for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
                intMatriz[fila][columna] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            }
        }
    }

    // Imprimir matriz de enteros
    public static void imprimirMatrizEnteros(int [][] intMatriz) {
        for (int fila = 0; fila < MAXFILAS; fila++) {
            for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
                System.out.print("[" + intMatriz[fila][columna] + "]");
            }
            System.out.println("");
        }
    }

    // Imprimir promedio de cada fila de la matriz
    public static void imprimirPromediosColumnas(int [][] intMatriz) {
        for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
            System.out.println("Promedio de la columna " + columna + " = " + promedioColumna(intMatriz,columna));
        }
    }

    // Calcular promedio de una fila de la matriz (pasándola como matriz, no se puede pasar como arreglo)
    public static int promedioColumna(int [][] intMatriz, int columna) {
        int promedio;
        int suma = 0;
        for (int fila = 0; fila < MAXFILAS; fila++) {
            suma += intMatriz[fila][columna];
        }
        promedio = suma / MAXFILAS;
        return promedio;
    }
}
