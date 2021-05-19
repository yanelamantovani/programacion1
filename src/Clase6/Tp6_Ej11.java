package Clase6;

/* Escribir un programa que mientras el usuario ingrese un número entero entre 1 y 10 realice:
– Si el numero ingresado es múltiplo de 3 pida ingresar un caracter, y para el caracter ingresado
imprima a que tipo de carácter esta asociado:
• “letra minúscula” si el caracter es una letra del abecedario en minúscula;
• “letra mayúscula” si el caracter es una letra del abecedario en mayúscula;
• “dígito” si el caracter corresponde a un carácter número;
• “otro” para los restantes casos de caracteres.
– Si el numero ingresado es múltiplo de 5 imprima la tabla de multiplicar del numero
ingresado.  */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp6_Ej11 {
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
                if (num % 3 == 0) {
                    System.out.println("Ingrese un caracter:");
                    caracter = entrada.readLine().charAt(0);
                    imprimir_tipo_caracter(caracter);
                } else if (num % 5 == 0) {
                    imprimir_tabla(num);
                }
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

    public static void imprimir_tabla(int numero) {
        for (int i = min; i <= max; i++) {
            System.out.println(numero + " * " + i + " = " + (numero * i));
        }
    }
}
