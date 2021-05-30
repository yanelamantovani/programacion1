/*
Hacer un programa que dado una matriz ordenada creciente por filas de enteros de tamaño 4*5 que se encuentra precargada,
solicite al usuario un numero entero y una fila, y luego inserte el numero en la matriz en la fila indicada manteniendo su orden.
*/

package Clase8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp8_Ej07 {
    public static final int MAXFILAS = 4;
    public static final int MAXCOLUMNAS = 5;

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int[][] intMatriz = new int[MAXFILAS][MAXCOLUMNAS];

        cargarMatrizEnterosOrdenada(intMatriz);
        imprimirMatrizEnteros(intMatriz);

        try {
            System.out.println("Ingrese una fila (entre 0 y 3):");
            int filaUsuario = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese el numero entero que quiere insertar:");
            int numero = Integer.valueOf(entrada.readLine());
            insertarNumeroMatriz(intMatriz,filaUsuario,numero);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void cargarMatrizEnterosOrdenada(int[][] intMatriz) {
        for (int fila = 0; fila < MAXFILAS; fila++) {
            int valor = 0;
            for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
                intMatriz[fila][columna] = valor;
                valor += 2;
            }
        }
    }

    public static void imprimirMatrizEnteros(int[][] intMatriz) {
        for (int fila = 0; fila < MAXFILAS; fila++) {
            for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
                System.out.print("[" + intMatriz[fila][columna] + "]");
            }
            System.out.println("");
        }
    }

    public static void insertarNumeroMatriz(int[][] intMatriz, int filaUsuario, int numero) {
        int posicion = buscarPosicionFila(intMatriz,filaUsuario,numero);
        if (numero > 8) {
            System.out.println("El numero ingresado excede los valores de la matriz.");
        } else {
            int i = MAXCOLUMNAS - 1;
            while (i > posicion) {
                intMatriz[filaUsuario][i] = intMatriz[filaUsuario][i - 1];
                i--;
            }
            intMatriz[filaUsuario][posicion] = numero;
            imprimirMatrizEnteros(intMatriz);
        }
    }
    public static int buscarPosicionFila(int[][] intMatriz, int filaUsuario, int numero) {
        int posicion = 0;
        for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
            if (numero <= intMatriz[filaUsuario][columna]) {
                posicion = columna;
                break;
            }
        }
        return posicion;
    }
}
