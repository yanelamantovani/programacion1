package Clase5;

/* Escribir un programa que mientras que el usuario ingrese un número entero distinto de 0,
pida ingresar otro número entero y lo imprima.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp5_Ej4 {
    public static void main(String[] args) {
        int num;

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese un número entero (0 para salir):");
            num = Integer.valueOf(entrada.readLine());

            while (num != 0) {
                System.out.println("El número ingresado es: " +  num);
                System.out.println("Ingrese un número entero (0 para salir):");
                num = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}