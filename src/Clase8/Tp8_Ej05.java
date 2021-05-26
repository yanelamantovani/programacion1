/*
Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra precargada,
solicite al usuario un numero entero y elimine la primer ocurrencia de numero en la matriz (un número igual)
si existe. Para ello tendrá que buscar la posición y si está, realizar un corrimiento a izquierda y no continuar
buscando.
*/

package Clase8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp8_Ej05 {
    public static final int MAXFILAS = 4;
    public static final int MAXCOLUMNAS = 5;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int [][] intMatriz = new int[MAXFILAS][MAXCOLUMNAS];
        int [] posicion = new int[2];
        try {
            cargarMatrizEnterosRandom(intMatriz);
            imprimirMatrizEnteros(intMatriz);
            System.out.println("Ingrese un número:");
            int numero = Integer.valueOf(entrada.readLine());
            posicion = buscarPosicionNumeroMatriz(intMatriz,numero,posicion);
            if (posicion != null) {
                corrimientoIzquierda(intMatriz,posicion);
                imprimirMatrizEnteros(intMatriz);
            } else {
                System.out.println("El número ingresado no se encuentra en la matriz.");
            }
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

    public static int[] buscarPosicionNumeroMatriz(int [][] intMatriz, int numero, int [] posicion) {
        for (int fila = 0; fila < MAXFILAS; fila++) {
            for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
                if (intMatriz[fila][columna] == numero) {
                    posicion[0] = fila;
                    posicion[1] = columna;
                    return posicion;
                }
            }
        }
        return null;
    }

    public static void corrimientoIzquierda(int [][]intMatriz, int[] posicion) {
        int i = posicion[1];
        while (i < MAXCOLUMNAS - 1) {
            intMatriz[posicion[0]][i] = intMatriz[posicion[0]][i + 1];
            i++;
        }
    }
}