/*
Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra precargada,
obtenga la cantidad de números pares que tiene y la imprima.
*/

package Clase8;

import java.util.Random;

public class Tp8_Ej02 {
    public static final int MAXFILAS = 5;
    public static final int MAXCOLUMNAS = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;

    public static void main(String[] args) {
        int [][] intMatriz = new int[MAXFILAS][MAXCOLUMNAS];
        cargarMatrizEnterosRandom(intMatriz);
        imprimirMatrizEnteros(intMatriz);
        buscarNumerosPares(intMatriz);
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

    public static void buscarNumerosPares(int [][] intMatriz) {
        int contador = 0;
        for (int fila = 0; fila < MAXFILAS; fila++) {
            for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
               if (intMatriz[fila][columna] % 2 == 0) {
                   contador++;
               }
            }
        }
        System.out.println("Cantidad de numeros pares en la matriz: " + contador);
    }
}