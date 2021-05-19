package Clase6;

/* Escribir un programa que mientras que el usuario ingrese un caracter letra minúscula,
pida ingresar un numero entero. Si el número ingresado está entre 1 y 5 inclusive deberá imprimir
la tabla de multiplicar de dicho numero. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp6_Ej8 {
    public static final int min = 1;
    public static final int max = 10;

    public static void main(String[] args) {
        char caracter;
        int num;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese una letra minúscula:");
            caracter = entrada.readLine().charAt(0);
            while ((caracter >= 'a') && (caracter <= 'z')) {
                System.out.println("Ingrese un número entero:");
                num = Integer.valueOf(entrada.readLine());
                if ((num >= 1) && (num <= 5)) {
                    imprimir_tabla(num);
                }
                System.out.println("Ingrese una letra minúscula:");
                caracter = entrada.readLine().charAt(0);
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void imprimir_tabla (int numero) {
        for (int i = min; i <= max; i++) {
            System.out.println(numero + " por " + i + " = " + (i * numero));
        }
    }
}
