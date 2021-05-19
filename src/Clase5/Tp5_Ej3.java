package Clase5;

/* Escribir un programa que mientras el usuario ingresa un caracter distinto del caracter ‘*’,
muestre por pantalla si es caracter digito, o si es caracter vocal minúscula.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp5_Ej3 {
    public static void main(String[] args) {
        char caracter;

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese un caracter (* para salir):");
            caracter = entrada.readLine().charAt(0);

            while (caracter != '*') {
                if ((caracter >= '0') && (caracter <= '9')) {
                    System.out.println("El caracter ingresado es un dígito.");
                } else if ((caracter >= 'a') && (caracter <= 'z')) {
                    switch (caracter) {
                        case 'a':
                        case 'e':
                        case 'i':
                        case 'o':
                        case 'u': {
                            System.out.println("El carácter ingresado es una letra vocal minúscula.");
                            break;
                        }
                    }
                }
                System.out.println("Ingrese un caracter (* para salir):");
                caracter = entrada.readLine().charAt(0);
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
