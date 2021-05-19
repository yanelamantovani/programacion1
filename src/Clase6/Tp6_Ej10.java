package Clase6;

/* Escribir un programa que mientras el usuario ingrese un número entero entre 1 y 10,
pida ingresar un caracter, y por cada caracter ingresado imprima:
– “letra minúscula” si el caracter es una letra del abecedario en minúscula;
– “letra mayúscula” si el caracter es una letra del abecedario en mayúscula;
– “dígito” si el caracter corresponde a un carácter número;
– “otro” para los restantes casos de caracteres.  */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp6_Ej10 {
    public static final int min = 1;
    public static final int max = 10;

    public static void main(String[] args) {
        int num;
        char caracter;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese un número entero entre 1 y 10:");
            num = Integer.valueOf(entrada.readLine());
            while ((num >= min) && (num <= max)) {
                System.out.println("Ingrese un caracter:");
                caracter = entrada.readLine().charAt(0);
                imprimir_tipo_caracter(caracter);
                System.out.println("Ingrese un número entero entre 1 y 10:");
                num = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void imprimir_tipo_caracter(char caracter) {
        if ((caracter >= 'a') && (caracter <= 'z')) {
            System.out.println("Letra minúscula.");
        } else if ((caracter >= 'A') && (caracter <= 'Z')) {
            System.out.println("Letra mayúscula.");
        } else if ((caracter >= '0') && (caracter <= '9')) {
            System.out.println("Dígito.");
        } else {
            System.out.println("Otro");
        }
    }
}
