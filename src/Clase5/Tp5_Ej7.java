package Clase5;

/* Escribir un programa que mientras que el usuario ingrese un número entero entre 1 y 10 inclusive,
lleve la suma de los números ingresados y la cantidad de sumas que realizó. Finalmente,
cuando sale del ciclo muestre por pantalla el resultado del promedio de lo ingresado */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp5_Ej7 {
    public static void main(String[] args) {
        int num;
        int total_suma = 0;
        int cant_sumas = -1;
        double promedio;

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese un número entero entre 1 y 10:");
            num = Integer.valueOf(entrada.readLine());

            while ((num >= 1) && (num <= 10)) {
                total_suma = total_suma + num;
                cant_sumas++;
                System.out.println("Ingrese un número entero entre 1 y 10:");
                num = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }

        System.out.println("El resultado de la suma de todos los números ingresados es: " + total_suma);
        System.out.println("La cantidad de sumas realizadas es: " + cant_sumas);

        promedio = (total_suma * 1.0) / (cant_sumas + 1);

        System.out.println("El promedio de los números ingresados es: " + promedio);
    }
}
