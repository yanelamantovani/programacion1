package Clase3;

/* Escribir un programa que ingrese un número entero por teclado e
imprima el resultado de determinar:
1) si es múltiplo de 6 y de 7,
2) es mayor a 30 y múltiplo de 2, o es menor igual a 30,
3) el cociente de la división de dicho número con 5 es mayor a 10. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp3_Ej4 {
    public static void main(String[] args) {
        int num;
        try{
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese un número entero:");
            num = Integer.valueOf(entrada.readLine());

            System.out.println("El número ingresado es múltiplo de 6 y de 7?: " + (((num % 6) == 0) && ((num % 7) == 0)));
            System.out.println("El número ingresado es mayor a 30 y múltiplo de 2, o menor igual a 30?: " + (((num > 30) && ((num % 2) == 0)) || (num <= 30)));
            System.out.println("El cociente de la división del número ingresado con 5 es mayor a 10?: " + ((num / 5) > 10));
        }
        catch (Exception exc) {
            System.out.println(exc);
        }
    }
}

