package Clase6;

/* Escribir un programa que mientras el usuario cargue desde teclado un numero entero
distinto de 0, imprima por pantalla la suma que se obtiene de invocar un método que
calcula la sumatoria de los primeros 200 números naturales (son números enteros en 1
y 200). */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp6_Ej4 {
    public static void main(String[] args) {
        int num;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese un número entero (0 para salir):");
            num = Integer.valueOf(entrada.readLine());
            while (num != 0) {
                int suma = sumar_hasta200();
                System.out.println("La suma de los primeros 200 números naturales es: " + suma);
                System.out.println("Ingrese un número entero (0 para salir):");
                num = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static int sumar_hasta200 () {
        final int min = 1;
        final int max = 200;
        int suma = 0;

        for (int i = min; i <= max; i++) {
            suma += i;
        }
        return suma;
    }
}
