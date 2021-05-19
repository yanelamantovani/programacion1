package Clase2;

/*Escribir un programa que para los tipos int, double, char y boolean
declare una variable en cada caso, luego asigne un valor a cada
una correspondiente al tipo que la variable tiene, e imprima por
pantalla cada una de las variables.*/

public class Tp2_Parte1_Ej1 {
    public static void main(String[] args) {
        int entero;
        double real;
        char caracter;
        boolean logico;

        entero = 25;
        real = 2.5;
        caracter = 'y';
        logico = true;

        System.out.println("El valor de la variable entero es: " + entero);
        System.out.println("El valor de la variable real es: " + real);
        System.out.println("El valor de la variable caracter es: " + caracter);
        System.out.println("El valor de la variable logico es: " + logico);
    }
}
