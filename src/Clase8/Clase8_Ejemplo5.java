/*
Hacer un programa que dado una matriz de enteros de tamano 4*5 que se encuentra precargada,
encuentre la posicion fila,columna de un numero entero ingresado por el usuario. Si existe,
muestre esa posicion por pantalla, o indique que no existe.
*/

package Clase8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Clase8_Ejemplo5 {
    public static final int MAXFILAS = 4; // Dimensiones de la matriz
    public static final int MAXCOLUMNAS = 5;
    public static final int MAXVALOR = 9; // Máximo del random
    public static final int MINVALOR = 1;

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int [][] intMatriz = new int[MAXFILAS][MAXCOLUMNAS];
        try {
            cargarMatrizEnterosRandom(intMatriz);
            imprimirMatrizEnteros(intMatriz);
            System.out.println("Ingrese un entero:");
            int numero = Integer.valueOf(entrada.readLine());
            buscarNumeroMatriz(intMatriz,numero);
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

    public static void buscarNumeroMatriz(int [][] intMatriz, int numero) {
        boolean existe = false;
        for (int fila = 0; fila < MAXFILAS; fila++) {
            for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
                if (intMatriz[fila][columna] == numero) {
                    System.out.println("El numero ingresado está en la fila " + fila + " y columna " + columna);
                    existe = true;
                }
            }
        }
        if (existe == false) {
            System.out.println("El numero ingresado no se encuentra en la matriz");
        }
    }
}