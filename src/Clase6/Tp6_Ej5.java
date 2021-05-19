package Clase6;

/* Escribir un programa que mientras el usuario ingresa un caracter distinto del caracter ‘*’,
invoque a un método que imprima si es caracter dígito o caracter letra minúscula, y si es letra minúscula
imprimir si es vocal o consonante. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp6_Ej5 {
    public static void main(String[] args) {
        char caracter;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese un caracter (* para salir):");
            caracter = entrada.readLine().charAt(0);
            while (caracter != '*') {
                imprimir_caracteres(caracter);
                System.out.println("Ingrese un caracter (* para salir):");
                caracter = entrada.readLine().charAt(0);
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void imprimir_caracteres(char caracter) {
        if ((caracter >= 'a') && (caracter <= 'z')) {
            System.out.println(caracter + " es una letra minúscula.");
            switch (caracter) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u': {
                    System.out.println(caracter + " es una vocal.");
                    break;
                }
                default: {
                    System.out.println(caracter + " es una consonante.");
                }
            }
        }
        else if ((caracter >= '0') && (caracter <= '9')) {
            System.out.println(caracter + " es un dígito.");
        }
    }
}
