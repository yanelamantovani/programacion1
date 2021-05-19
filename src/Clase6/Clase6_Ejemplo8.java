package Clase6;

/* Escribir un programa que dado un numero natural (entero > 0 o >=1) ingresado por el usuario llame un metodo
que imprima de forma decreciente los numeros naturales menores a ese numero ingresado. Finalmente, imprima el
numero natural ingresado */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase6_Ejemplo8 {
    public static final int min = 1;

    public static void main(String[] args) {
        int num;
        BufferedReader entrada = new BufferedReader((new InputStreamReader(System.in)));
        try{
            System.out.println("Ingrese un número natural:");
            num = Integer.valueOf(entrada.readLine());
            if (num > min) {
                imprimir_naturales_menores(num);
            }
            System.out.println("El número natural ingresado es: " + num);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void imprimir_naturales_menores (int numero) {
        while (numero >= min) {
            System.out.println(numero);
            numero--;
        }
    }
}