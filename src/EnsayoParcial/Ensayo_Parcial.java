package EnsayoParcial;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Hacer un programa completo que mientras el usuario ingrese un caracter letra mayuscula o
minuscula realice lo siguiente:
_cuente cuantas veces el caracter ingresado fue letra vocal minuscula.
Finalmente cuando sale de la iteracion imprima por pantalla la cantidad acumulada. */

public class Ensayo_Parcial {
    public static void main(String[] args) {
        char caracter;
        int cantidad_vocales_minusculas = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese un caracter:");
            caracter = entrada.readLine().charAt(0);
            while (((caracter >= 'a') && (caracter <= 'z')) || ((caracter >= 'A') && (caracter <= 'Z'))) {
                switch (caracter) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u': {
                        cantidad_vocales_minusculas++;
                        break;
                    }
                }
                System.out.println("Ingrese un caracter:");
                caracter = entrada.readLine().charAt(0);
            }
            System.out.println("La cantidad de vocales minusculas ingresadas es: " + cantidad_vocales_minusculas);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}