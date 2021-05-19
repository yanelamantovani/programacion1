package EnsayoParcial;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Hacer un programa completo que mientras el usuario ingrese un caracter letra mayuscula o
minuscula realice lo siguiente:
_cuente cuantas veces el caracter ingresado fue letra vocal minuscula.
Finalmente cuando sale de la iteracion imprima por pantalla la cantidad acumulada. */

public class Version_Funciones {
    public static void main(String[] args) {
        char caracter;
        int cantidad_vocales_minusculas = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        caracter = leerCaracter(entrada);
        while (esLetra(caracter)) {
            if (esVocal(caracter)) {
                cantidad_vocales_minusculas++;
            }
            caracter = leerCaracter(entrada);
        }
        System.out.println("La cantidad de vocales minusculas ingresadas es: " + cantidad_vocales_minusculas);
    }

    public static char leerCaracter(BufferedReader entrada) {
        try {
            System.out.println("Ingrese un caracter:");
            return entrada.readLine().charAt(0);
        } catch (Exception exc) {
            System.out.println(exc);
        }
        return 1;
    }

    public static boolean esLetra(char caracter) {
        return ((caracter >= 'a') && (caracter <= 'z')) || ((caracter >= 'A') && (caracter <= 'Z'));
    }

    public static boolean esVocal(char caracter) {
        switch (caracter) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}
