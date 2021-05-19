package Clase5;

/* Escribir un programa que solicite al usuario el ingreso de un número entero positivo,
y muestre por pantalla los valores entre el numero ingresado y 0 de manera decreciente. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp5_Ej2 {
    public static void main(String[] args) {
        int num, i;

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese un número entero positivo:");
            num = Integer.valueOf(entrada.readLine());

            if (num > 0) {
                for (i = num; i >= 0; i--) {
                    System.out.println(i);
                }
            } else {
                System.out.println("El número ingresado es incorrecto");
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
