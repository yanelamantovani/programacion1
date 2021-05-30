/*
Ordenar por selección columnas de la matriz.
*/

package Clase8;

import java.util.Random;

public class Clase8_Ejemplo7 {
    public static final int MAXFILAS = 4;
    public static final int MAXCOLUMNAS = 5;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;

    public static void main(String[] args) {
        int [][] intMatriz = new int[MAXFILAS][MAXCOLUMNAS];
        System.out.println("Matriz aleatoria:");
        cargarMatrizEnterosRandom(intMatriz);
        imprimirMatrizEnteros(intMatriz);
        System.out.println("Matriz ordenada por columnas");
        ordenarColumnasMatriz(intMatriz);
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

    public static void ordenarColumnasMatriz(int [][] intMatriz) {
        int posMenor, aux;
        for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
            for (int fila = 0; fila < MAXFILAS; fila++) {
                posMenor = fila;
                for (int i = fila + 1; i < MAXFILAS; i++) {
                    if (intMatriz[i][columna] < intMatriz[posMenor][columna]) {
                        posMenor = i;
                    }
                }
                if (posMenor != fila) {
                    aux = intMatriz[fila][columna];
                    intMatriz[fila][columna] = intMatriz[posMenor][columna];
                    intMatriz[posMenor][columna] = aux;
                }
            }
        }
    }
}