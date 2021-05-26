/*
Hacer un programa que dado una matriz de enteros de tamaño 5*10 que se encuentra precargada,
solicite al usuario un numero entero y una posición fila, columna. Con estos datos tendrá que
realizar un corrimiento a derecha (se pierde el último valor en dicha fila) y colocar el numero
en la matriz en la posición fila, columna indicada.
*/

package Clase8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp8_Ej04 {
    public static final int MAXFILAS = 5;
    public static final int MAXCOLUMNAS = 10;
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

    public static void corrimientoDerecha(int [][] intMatriz, int filaUsuario, int columnaUsuario) {
        if ((filaUsuario >= 0) && (filaUsuario < MAXFILAS) && (columnaUsuario >= 0) && (columnaUsuario < MAXCOLUMNAS)) {
            int i = MAXCOLUMNAS - 1;
            int aux;
            aux = intMatriz[filaUsuario][i];
            while (i > columnaUsuario) {
                intMatriz[filaUsuario][i] = intMatriz[filaUsuario][i - 1];
                i--;
            }
            intMatriz[filaUsuario][columnaUsuario] = aux;
            imprimirMatrizEnteros(intMatriz);
        } else {
            System.out.println("Los valores ingresados exceden las dimensiones de la matriz.");
        }
    }
}
