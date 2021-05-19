package Clase2;

/* Escribir un programa que solicite y luego muestre por consola los valores
necesarios para dibujar un círculo y un triángulo. Hay que determinar en cada
caso que constantes (que no se cargan por consola) y variables con tipos son
necesarias declarar. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Parte2_Ej1 {
    public static void main(String[] args) {
        double radio;
        final double pi = 3.14159265358979323846;
        double lado1, lado2, angulo;

        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            // valores para dibujar un circulo
            System.out.println("Ingrese el radio:");
            radio = Double.valueOf(entrada.readLine());
            System.out.println("Los valores necesarios para dibujar un círculo son radio = " + radio + " y pi = " + pi);
            //valores para dibujar un triangulo
            System.out.println("Ingrese el lado 1");
            lado1 = Double.valueOf(entrada.readLine());
            System.out.println("Ingrese el lado 2:");
            lado2 = Double.valueOf(entrada.readLine());
            System.out.println("Ingrese el angulo");
            angulo = Double.valueOf(entrada.readLine());
            System.out.println("Los valores necesarios para dibujar un triángulo son lado 1 = " + lado1 + ", lado 2 = " + lado2 + " y el ángulo = " + angulo);
        }
        catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
