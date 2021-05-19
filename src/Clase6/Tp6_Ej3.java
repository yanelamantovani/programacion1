package Clase6;

/* Escribir un programa que mientras el usuario cargue desde teclado un caracter letra
minúscula, llame a un método que imprime por pantalla la tabla de multiplicar de 9. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp6_Ej3 {
    public static void main(String[] args) {
        char letra;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese un caracter letra minúscula:");
            letra = entrada.readLine().charAt(0);

            while ((letra >= 'a') && (letra <= 'z')) {
                imprimir_tabla9();
                System.out.println("Ingrese un caracter letra minúscula:");
                letra = entrada.readLine().charAt(0);
            }

        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void imprimir_tabla9 () {
        final int nueve = 9;

        for (int i = 1; i <= 10; i++) {
            System.out.println(nueve + " por " + i + " = " + (nueve * i));
        }
    }
}
