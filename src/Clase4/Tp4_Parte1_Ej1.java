package Clase4;

/* Escribir un programa que permita el ingreso de un carácter y realice:
_ imprima es carácter dígito si el carácter ingresado es carácter dígito,
_ o imprima no es carácter dígito */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp4_Parte1_Ej1 {
    public static void main(String[] args) {
        int digito;

        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese un dígito:");
            digito = Integer.valueOf(entrada.readLine());

            if ((digito >= 0) && (digito < 10)) {
                System.out.println("El carácter ingresado es carácter dígito.");
            }
            else {
                System.out.println("El carácter ingresado NO es carácter dígito.");
            }
        }
        catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
