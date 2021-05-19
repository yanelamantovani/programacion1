package Clase6;

/*Escribir un diseno de un programa que mientras el usuario ingrese de un numero entero mayor que 0,
imprima la tabla de multiplicar de 10. Cuando salga del ciclo vuelva a imprimir la tabla de multiplicar de 10. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase6_Ejemplo6 {
    public static final int min = 0;
    public static final int max = 10;

    public static void main(String[] args) {
        int num;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.println("Ingrese un número entero natural:");
            num = Integer.valueOf(entrada.readLine());

            while (num > min) {
                imprimir_tabla10();
                System.out.println("Ingrese un número entero natural:");
                num = Integer.valueOf(entrada.readLine());
            }
            imprimir_tabla10();
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void imprimir_tabla10 () {
        for (int i = 1; i <= max; i++) {
            System.out.println(i + " por " + max + " = " + (i * max));
        }
    }
}
