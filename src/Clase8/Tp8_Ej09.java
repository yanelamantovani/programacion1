/*
Hacer un programa que dado una matriz de enteros de tamaño 4*5 que se encuentra precargada,
solicite al usuario el ingreso de una fila y dos números enteros (columnas de la matriz),
y ordene de forma creciente la matriz en la fila indicada entre las dos posiciones columnas ingresadas.
*/

package Clase8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp8_Ej09 {
    public static final int MAXFILAS = 4;
    public static final int MAXCOLUMNAS = 5;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int [][] intMatriz = new int[MAXFILAS][MAXCOLUMNAS];
        cargarMatrizEnterosRandom(intMatriz);
        imprimirMatrizEnteros(intMatriz);
        try {
            System.out.println("Ingrese una fila (entre 0 y 3):");
            int filaUsuario = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese la posicion de inicio:");
            int posicionInicio = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese la posicion final:");
            int posicionFin = Integer.valueOf(entrada.readLine());
            ordenarFilaMatriz(intMatriz,filaUsuario,posicionInicio,posicionFin);
            imprimirMatrizEnteros(intMatriz);
        } catch (Exception exc) {
            System.out.println(exc);
        }
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

    public static void ordenarFilaMatriz(int [][] intMatriz, int filaUsuario, int posicionInicio, int posicionFin) {
        int posMenor, aux;
        for (int columna = posicionInicio; columna <= posicionFin; columna++) {
            posMenor = columna;
            for (int i = columna + 1; i <= posicionFin; i++) {
                if (intMatriz[filaUsuario][i] < intMatriz[filaUsuario][posMenor]) {
                    posMenor = i;
                }
            }
            if (posMenor != columna) {
                aux = intMatriz[filaUsuario][columna];
                intMatriz[filaUsuario][columna] = intMatriz[filaUsuario][posMenor];
                intMatriz[filaUsuario][posMenor] = aux;
            }
        }
    }
}