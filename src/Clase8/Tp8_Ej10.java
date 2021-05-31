/*
Hacer un programa que dada la matriz de secuencias de enteros definida y precargada,
permita obtener a través de métodos la posición de inicio y la posición de fin de la
secuencia ubicada a partir de una posición entera y una fila, ambas ingresadas por el usuario.
Finalmente, si existen imprima por pantalla ambas posiciones obtenidas.
*/

package Clase8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp8_Ej10 {
    public static final int MAXFILAS = 4;
    public static final int MAXCOLUMNAS = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilityNumber = 0.4;

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        int [][] intMatriz = new int[MAXFILAS][MAXCOLUMNAS];

        cargarMatrizSecuenciasEnteros(intMatriz);
        imprimirMatrizEnteros(intMatriz);

        try {
            System.out.println("Ingresar una fila:");
            int filaUsuario = Integer.valueOf(entrada.readLine());
            System.out.println("Ingresar una posición (número entero):");
            int posicion = Integer.valueOf(entrada.readLine());
            int posicionInicio = buscarPosicionInicioSecuenciaMatriz(intMatriz, filaUsuario, posicion);
            System.out.println("La secuencia inicia en la posición: " + posicionInicio);
            int posicionFin = buscarPosicionFinSecuenciaMatriz(intMatriz, filaUsuario, posicionInicio);
            System.out.println("Y termina en la posición: " + posicionFin);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void cargarMatrizSecuenciasEnteros(int [][] intMatriz) {
        for (int fila = 0; fila < MAXFILAS; fila++) {
            cargarArregloSecuenciasEnteros(intMatriz[fila]);
        }
        System.out.println("");
    }

    public static void cargarArregloSecuenciasEnteros(int [] array) {
        Random r = new Random();
        array[0] = 0;
        array[MAXCOLUMNAS - 1] = 0;
        for (int i = 1; i < MAXCOLUMNAS - 1; i++) {
            if (r.nextDouble() > probabilityNumber) {
                array[i] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                array[i] = 0;
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

    public static int buscarPosicionInicioSecuenciaMatriz(int[][] intMatriz, int filaUsuario, int posicion) {
        int posicionInicio = posicion;
        if (intMatriz[filaUsuario][posicion] == 0) {
            posicionInicio++;
        } else {
            while (intMatriz[filaUsuario][posicion] != 0) {
                posicion--;
            }
            posicionInicio = posicion + 1;
        }
        return posicionInicio;
    }

    public static int buscarPosicionFinSecuenciaMatriz(int[][] intMatriz, int filaUsuario, int posicionInicio) {
        while (intMatriz[filaUsuario][posicionInicio] != 0) {
            posicionInicio++;
        }
        int posicionFin = posicionInicio - 1;
        return posicionFin;
    }
}