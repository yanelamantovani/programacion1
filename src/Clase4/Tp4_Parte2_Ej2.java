package Clase4;

/* Hacer un programa que solicite la carga desde consola de un carácter y realice:
imprima si es dígito, o letra minúscula, o es cualquier otro carácter.
Si es letra minúscula indicar si es vocal o consonante. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp4_Parte2_Ej2 {
    public static void main(String[] args) {
        char caracter;

        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese un caracter:");
            caracter = entrada.readLine().charAt(0);

            if ((caracter >= '0') && (caracter <= '9')) {
                System.out.println("Es dígito.");
            }
            else if ((caracter >= 'a') && (caracter <= 'z')) {
                switch (caracter) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u': {
                        System.out.println("Es una letra minúscula y es vocal.");
                        break;
                    }
                    default: {
                        System.out.println("Es una letra minúscula y es consonante.");
                    }
                }
            }
            else {
                System.out.println("Es otro tipo de caracter.");
            }
        }
        catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
