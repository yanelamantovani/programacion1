/*
Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra precargada,
invierta el orden del contenido por fila. Este intercambio no se debe realizar de manera explícita,
hay que hacer un método que incluya una iteración de intercambio.
*/

package Clase8;

import java.util.Random;

public class Tp8_Ej01 {
    public static final int MAXFILAS = 5;
    public static final int MAXCOLUMNAS = 10;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;

    public static void main(String[] args) {
        int [][] intMatriz = new int[MAXFILAS][MAXCOLUMNAS];
        System.out.println("Matriz original:");
        cargarMatrizEnterosRandom(intMatriz);
        imprimirMatrizEnteros(intMatriz);
        System.out.println("Matriz con filas invertidas");
        invertirOrdenFilas(intMatriz);
        imprimirMatrizEnteros(intMatriz);
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

    public static void invertirOrdenFilas(int [][] intMatriz) {
        int aux = 0;
        for (int fila = 0; fila < MAXFILAS; fila++) {
            for (int columna = 0; columna < MAXCOLUMNAS / 2; columna++) {
                aux = intMatriz[fila][columna];
                intMatriz[fila][columna] = intMatriz[fila][MAXCOLUMNAS - 1 - columna];
                intMatriz[fila][MAXCOLUMNAS - 1 - columna] = aux;
            }
        }
    }
}
