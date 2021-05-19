package Clase6;

/*Escribir un programa que dado un numero ingresado por el usuario, si el numero es natural imprima la tabla
de multiplicar de ese numero. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase6_Ejemplo7 {
    public static final int min = 0;
    public static final int max = 10;

    public static void main(String[] args) {
        int num;
        BufferedReader entrada = new BufferedReader((new InputStreamReader(System.in)));
        try{
            System.out.println("Ingrese un número natural:");
            num = Integer.valueOf(entrada.readLine());
            if (num > min) {
                imprimir_tabla(num);
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void imprimir_tabla (int numero) {
        for (int i = 1; i <= max; i++) {
            System.out.println(i + " por " + numero + " = " + (i * numero));
        }
    }
}
