package Clase4;

/* Escribir un programa que permita el ingreso de dos números enteros por teclado y realice:
_ imprima A si el primero mayor al segundo,
_ o imprima B si ambos son múltiplos de 2,
_ o imprima C para ninguna de las opciones anteriores */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp4_Parte1_Ej2 {
    public static void main(String[] args) {
        int num1, num2;

        try {
            BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
            System.out.println("Ingrese un número entero:");
            num1 = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese otro número entero:");
            num2 = Integer.valueOf(entrada.readLine());

            if (num1 > num2) {
                System.out.println("A");
            }
            else if ((num1 % 2 == 0) && (num2 % 2 == 0)) {
                System.out.println("B");
            }
            else {
                System.out.println("C");
            }
        }
        catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
