package Clase6;

/* Escribir un programa que mientras el usuario cargue desde teclado un numero distinto
de 0, llame a un método que imprima por pantalla los numeros entre 1 y 4 de forma
creciente. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase6_Ejemplo4 {
    public static void main(String[] args) {
        int num;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese un número entero (0 para salir):");
            num = Integer.valueOf(entrada.readLine());
            while (num != 0) {
                imprimir_hasta4();
                System.out.println("Ingrese un número entero (0 para salir):");
                num = Integer.valueOf(entrada.readLine());
            }

        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void imprimir_hasta4 () {
        final int min = 1;
        final int max = 4;

        for (int i = min; i <= max; i++) {
            System.out.println(i);
        }
    }
}
