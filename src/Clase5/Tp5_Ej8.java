package Clase5;

/* Escribir un programa que mientras el usuario ingrese un caracter letra minúscula,
acumule la cantidad de vocales que ingreso. Finalmente muestre por pantalla dicha cantidad.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp5_Ej8 {
    public static void main(String[] args) {
        char caracter;
        int vocales = 0;

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese un caracter:");
            caracter = entrada.readLine().charAt(0);

            while ((caracter >= 'a') && (caracter <= 'z')) {
                switch (caracter) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u': {
                        vocales++;
                        break;
                    }
                }
                System.out.println("Ingrese un caracter:");
                caracter = entrada.readLine().charAt(0);
            }
        }
        catch (Exception exc) {
            System.out.println(exc);
        }

        System.out.println("La cantidad de vocales ingresadas es: " + vocales);
    }
}
