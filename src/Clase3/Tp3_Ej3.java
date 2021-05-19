package Clase3;

/* Escribir un programa que permita el ingreso de dos números
enteros por teclado e imprima el resultado de comparar:
1) si el primero es mayor al segundo.
2) si ambos son múltiplos de 2. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp3_Ej3 {
    public static void main(String[] args) {
        int num1, num2;
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese un número entero:");
            num1 = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese otro número entero:");
            num2 = Integer.valueOf(entrada.readLine());

            System.out.println("El primer número es mayor al segundo?: " + (num1 > num2));
            System.out.println("Ambos números son múltiplos de 2?: " + (((num1 % 2) == 0) && ((num2 % 2) == 0)));
        }
        catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
