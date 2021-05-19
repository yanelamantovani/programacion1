package Clase6;

/* Realizar un programa que dado dos números enteros ingresados por el usuario,
muestre por pantalla el resultado de las operaciones matemáticas básicas: la suma, la resta,
la multiplicación y la división entre ambos números. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase6_Ejemplo9 {
    public static void main(String[] args) {
        double num1, num2;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese un número entero:");
            num1 = Double.valueOf(entrada.readLine());
            System.out.println("Ingrese un número entero:");
            num2 = Double.valueOf(entrada.readLine());
            imprimir_operaciones(num1, num2);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void imprimir_operaciones (double numero1, double numero2) {
        System.out.println(numero1 + " + " + numero2 + " = " + (numero1 + numero2));
        System.out.println(numero1 + " - " + numero2 + " = " + (numero1 - numero2));
        System.out.println(numero1 + " * " + numero2 + " = " + (numero1 * numero2));
        System.out.println(numero1 + " / " + numero2 + " = " + (numero1 / numero2));
    }
}
