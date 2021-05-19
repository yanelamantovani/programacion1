package Clase5;

/* Escribir un programa que mientras que el usuario ingrese un caracter letra minúscula,
pida ingresar un numero entero. Si el número ingresado está entre 1 y 5 inclusive deberá
imprimir la tabla de multiplicar de dicho numero. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp5_Ej11 {
    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese un caracter:");
            char caracter = entrada.readLine().charAt(0);

            while ((caracter >= 'a') && (caracter <= 'z')) {
                System.out.println("Ingrese un número entero:");
                int num = Integer.valueOf(entrada.readLine());

                if ((num >= 1) && (num <= 5)) {
                    for (int i = 1; i <= 10; i++){
                        int resultado = num * i;
                        System.out.println(num + " x " + i + " = " + resultado);
                    }
                }
                System.out.println("Ingrese un caracter:");
                caracter = entrada.readLine().charAt(0);
            }
        }
        catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
