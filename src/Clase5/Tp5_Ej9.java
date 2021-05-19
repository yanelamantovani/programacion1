package Clase5;

/* Escribir un programa que mientras el usuario ingrese un caracter letra minúscula,
se quede con la menor y la mayor letra ingresada. Finalmente muestre por pantalla dichas letras.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp5_Ej9 {
    public static void main(String[] args) {
        char caracter;
        char menor = 'z';
        char mayor = 'a';

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese un caracter:");
            caracter = entrada.readLine().charAt(0);

            while ((caracter >= 'a') && (caracter <= 'z')) {
                if (caracter < menor) {
                    menor = caracter;
                }
                if (caracter > mayor) {
                    mayor = caracter;
                }
                System.out.println("Ingrese un caracter:");
                caracter = entrada.readLine().charAt(0);
            }
        }
        catch (Exception exc) {
            System.out.println(exc);
        }

        System.out.println("La mayor letra ingresada es: " + mayor);
        System.out.println("La menor letra ingresada es: " + menor);
    }
}
