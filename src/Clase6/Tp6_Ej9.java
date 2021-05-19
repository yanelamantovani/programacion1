package Clase6;

/* Realizar un programa que dado dos números enteros y un carácter, todos ingresados por el usuario,
muestre por pantalla el resultado de la operación matemática básica considerando el valor del carácter.
Si ingreso el caracter:
‘a’ la suma,
‘b’ la resta,
‘c’ la multiplicación
‘d’ la división entre ambos números. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp6_Ej9 {
    public static void main(String[] args) {
        double num1, num2;
        char caracter;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese un número entero:");
            num1 = Double.valueOf(entrada.readLine());
            System.out.println("Ingrese un número entero:");
            num2 = Double.valueOf(entrada.readLine());
            System.out.println("Ingrese un caracter para indicar qué operación desea hacer entre ambos números: a) suma, b) resta, c) multiplicación, d) división");
            caracter = entrada.readLine().charAt(0);
            imprimir_operaciones(num1, num2, caracter);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void imprimir_operaciones (double numero1, double numero2, char letra) {
        switch (letra) {
            case 'a': {
                System.out.println(numero1 + " + " + numero2 + " = " + (numero1 + numero2));
                break;
            }
            case 'b': {
                System.out.println(numero1 + " - " + numero2 + " = " + (numero1 - numero2));
                break;
            }
            case 'c': {
                System.out.println(numero1 + " * " + numero2 + " = " + (numero1 * numero2));
                break;
            }
            case 'd': {
                System.out.println(numero1 + " / " + numero2 + " = " + (numero1 / numero2));
                break;
            }
            default: {
                System.out.println("La opción ingresada es incorrecta.");
            }
        }
    }
}
