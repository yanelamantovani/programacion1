package Clase4;

/* Escribir un programa que ingrese un número entero por teclado y realice:
_ imprima es múltiplo de 6 y de 7 si cumple con esa condición,
_ o imprima es mayor a 30 y múltiplo de 2 si cumple con esa condición,
_ imprima si el cociente de la división de dicho número con 5 es mayor a 10
sin importar las condiciones previas. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp4_Parte1_Ej3 {
    public static void main(String[] args) {
        int num;

        try {
            BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
            System.out.println("Ingrese un número entero:");
            num = Integer.valueOf(entrada.readLine());

            if ((num % 6 == 0) && (num % 7 == 0)) {
                System.out.println("Es múltiplo de 6 y de 7.");
            }
            else if ((num > 30) && (num % 2 == 0)) {
                System.out.println("Es mayor a 30 y múltiplo de 2.");
            }

            if ((num /  5) > 10) {
                System.out.println("El cociente de la división de dicho número con 5 es mayor a 10.");
            }
        }
        catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
