package Clase5;

/* Escribir un programa que mientras que el usuario ingrese un número entero
entre 1 y 10 inclusive, lleve la suma de los números ingresados. Finalmente,
cuando sale del ciclo muestre por pantalla el resultado de la suma. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp5_Ej6 {
    public static void main(String[] args) {
        int num;
        int suma = 0;

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese un número entero entre 1 y 10:");
            num = Integer.valueOf(entrada.readLine());

            while ((num >= 1) && (num <= 10)) {
                suma = suma + num;
                System.out.println("Ingrese un número entero entre 1 y 10:");
                num = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }

        System.out.println("El resultado de la suma de todos los números ingresados es: " +  suma);
    }
}
