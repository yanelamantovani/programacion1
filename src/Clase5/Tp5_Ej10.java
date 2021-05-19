package Clase5;

/* Escribir un programa que mientras el usuario ingresa un numero de mes (entero) entre 1 y 12 inclusive,
muestre por pantalla la cantidad de días del mes ingresado (suponer febrero de 28 días).*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp5_Ej10 {
    public static void main(String[] args) {
        int mes;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese un número de mes:");
            mes = Integer.valueOf(entrada.readLine());

            while ((mes >= 1) && (mes <= 12)) {
                switch (mes) {
                    case 4:
                    case 6:
                    case 9:
                    case 11: {
                        System.out.println("El mes ingresado tiene 30 días.");
                        break;
                    }
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12: {
                        System.out.println("El mes ingresado tiene 31 días.");
                        break;
                    }
                    case 2: {
                        System.out.println("El mes ingresado tiene 28 días.");
                    }
                    break;
                }
                System.out.println("Ingrese un número de mes:");
                mes = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
