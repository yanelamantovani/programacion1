package Clase6;

/* Escribir un programa que mientras que el usuario ingrese un número entero natural, llame a un método
que calcule la sumatoria entre 1 y dicho numero y se lo retorne como resultado. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp6_Ej6 {
    public static final int min = 0;

    public static void main(String[] args) {
        int num, sumatoria;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese un número entero natural:");
            num = Integer.valueOf(entrada.readLine());
            while (num > min) {
                sumatoria = calcular_sumatoria(num);
                System.out.println("La sumatoria entre 1 y " + num + " es = " + sumatoria);
                System.out.println("Ingrese un número entero natural:");
                num = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static int calcular_sumatoria (int numero) {
        int suma = 0;
        for (int i = 1; i <= numero; i++) {
            suma += i;
        }
        return suma;
    }
}
