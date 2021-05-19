package Clase3;

/* Escribir un programa que permita el ingreso de un número entero
por teclado e imprima el cociente de la división de dicho número
con 2, 3, y 4.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp3_Ej1 {
    public static void main(String[] args) {
        double num;
        try{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese un número entero:");
            num = Integer.valueOf(entrada.readLine());
            System.out.println("El cociente de la división del número ingresado con 2 es: " + (num / 2));
            System.out.println("El cociente de la división del número ingresado con 3 es: " + (num / 3));
            System.out.println("El cociente de la división del número ingresado con 4 es: " + (num / 4));
        }
        catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
