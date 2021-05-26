/*
Hacer un programa que dado una matriz de enteros de tamano 4*5 que se encuentra precargada,
solicite al usuario una posicion fila, columna, y realice un corrimiento a derecha. Ademas imprima
la matriz antes y despues del corrimiento
*/

package Clase8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Clase8_Ejemplo6 {
    public static final int MAXFILAS = 4;
    public static final int MAXCOLUMNAS = 5;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int [][] intMatriz = new int[MAXFILAS][MAXCOLUMNAS];
        try {
            cargarMatrizEnterosRandom(intMatriz);
            imprimirMatrizEnteros(intMatriz);
            System.out.println("Ingrese una fila:");
            int filaUsuario = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese una columna:");
            int columnaUsuario = Integer.valueOf(entrada.readLine());
            corrimientoDerecha(intMatriz,filaUsuario,columnaUsuario);
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

    //Buscar posición en matriz y hacer corrimiento a derecha
    public static void corrimientoDerecha(int [][] intMatriz, int filaUsuario, int columnaUsuario) {
        if ((filaUsuario >= 0) && (filaUsuario < MAXFILAS) && (columnaUsuario >= 0) && (columnaUsuario < MAXCOLUMNAS)) {
            int i = MAXCOLUMNAS - 1;
            while (i > columnaUsuario) {
                intMatriz[filaUsuario][i] = intMatriz[filaUsuario][i - 1];
                i--;
            }
            imprimirMatrizEnteros(intMatriz);
        } else {
            System.out.println("Los valores ingresados exceden las dimensiones de la matriz.");
        }
    }
}
