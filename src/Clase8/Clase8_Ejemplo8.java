/*
Carga de matrices con secuencias de enteros y caracteres.
*/

package Clase8;

import java.util.Random;

public class Clase8_Ejemplo8 {
    public static final int MAXFILAS = 4;
    public static final int MAXCOLUMNAS = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double probabilityLetter = 0.4;
    public static final double probabilityNumber = 0.4;

    public static void main(String[] args) {
        int [][] intMatriz = new int[MAXFILAS][MAXCOLUMNAS];
        char [][] charMatriz = new char[MAXFILAS][MAXCOLUMNAS];
        cargarMatrizSecuenciasEnteros(intMatriz);
        imprimirMatrizEnteros(intMatriz);
        cargarMatrizSecuenciasCaracter(charMatriz);
        imprimirMatrizCaracteres(charMatriz);
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

    public static void cargarMatrizSecuenciasCaracter(char [][] charMatriz) {
        for (int fila = 0; fila < MAXFILAS; fila++) {
            cargarArregloSecuenciasCaracter(charMatriz[fila]);
        }
        System.out.println("");
    }

    public static void cargarArregloSecuenciasCaracter(char [] array) {
        Random r = new Random();
        array[0] = ' ';
        array[MAXCOLUMNAS - 1] = ' ';
        for (int i = 1; i < MAXCOLUMNAS - 1; i++) {
            if (r.nextDouble() > probabilityLetter) {
                array[i] = (char) (r.nextInt(26) + 'a');
            } else {
                array[i] = ' ';
            }
        }
    }

    public static void imprimirMatrizCaracteres(char [][] charMatriz) {
        for (int fila = 0; fila < MAXFILAS; fila++) {
            for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
                System.out.print("[" + charMatriz[fila][columna] + "]");
            }
            System.out.println("");
        }
    }
}