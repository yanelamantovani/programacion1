/*
Hacer un programa que dado una matriz ordenada creciente por filas de enteros de tamaño 4*5 que se encuentra precargada,
solicite al usuario un numero entero y una fila, y elimine la primer ocurrencia de numero en la fila indicada (un número igual) si existe.
 */

package Clase8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp8_Ej08 {
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
            System.out.println("Ingrese el numero entero cuya primera ocurrencia desea eliminar:");
            int numero = Integer.valueOf(entrada.readLine());
            buscarPosicionFila(intMatriz,filaUsuario,numero);
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

    public static void eliminarNumeroMatriz(int[][] intMatriz, int filaUsuario, int posicion) {
        for (int columna = posicion; columna < MAXCOLUMNAS - 1; columna++) {
            intMatriz[filaUsuario][columna] = intMatriz[filaUsuario][columna + 1];
        }
        imprimirMatrizEnteros(intMatriz);
    }

    public static void buscarPosicionFila(int[][] intMatriz, int filaUsuario, int numero) {
        boolean existeNumero = existeNumeroFila(intMatriz,filaUsuario,numero);
        if (existeNumero == true) {
            int posicion = 0;
            for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
                if (numero == intMatriz[filaUsuario][columna]) {
                    posicion = columna;
                    break;
                }
            }
            eliminarNumeroMatriz(intMatriz,filaUsuario,posicion);

        } else {
            System.out.println("El numero ingresado no existe.");
        }
    }

    public static boolean existeNumeroFila(int[][] intMatriz, int filaUsuario, int numero) {
        boolean existeNumero = false;
        for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
            if (numero == intMatriz[filaUsuario][columna]) {
                existeNumero = true;
                break;
            }
        }
        return existeNumero;
    }
}