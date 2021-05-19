package Clase5;

/* Escribir un programa que mientras el usuario ingrese un número entero menor que 10 y mayor a 1,
muestre por pantalla si el número es múltiplo de 2 y múltiplo de 3 simultáneamente.
(¿Los valores mencionados deberían ser constantes?. De a poco habría que definirlos como constantes). */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp5_Ej1 {
    public static void main(String[] args) {
        int num;
        final int dos = 2;
        final int tres = 3;

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese un número entero menor que 10 y mayor que 1:");
            num = Integer.valueOf(entrada.readLine());

            while ((num > 1) && (num < 10)) {
                if ((num % 2 == 0) && (num % 3 == 0)) {
                    System.out.println("El número ingresado es múltiplo de 2 y de 3.");
                }
                System.out.println("Ingrese otro número entero menor que 10 y mayor que 1:");
                num = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc){
            System.out.println(exc);
        }
    }
}
