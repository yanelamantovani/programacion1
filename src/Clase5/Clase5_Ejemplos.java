package Clase5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase5_Ejemplos {
    public static void main(String[] args) {

        // ejemplo 1 - while
        int num = 1;
        final int max = 4;

        while (num <= 4) {
            System.out.println(num);
            num++;
        }

        // ejemplo 2 - while
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese un número entero (0 para salir):");
            num = Integer.valueOf(entrada.readLine());

            while (num != 0) {
                System.out.println(("El número ingresado es: " + num));
                System.out.println("Ingrese otro número entero (0 para salir):");
                num = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }

        // ejemplo 3 - while
        try {
            System.out.println("Ingrese un número entero par (0 para salir):");
            num = Integer.valueOf(entrada.readLine());

            while (num != 0) {
                if (num % 2 == 0) {
                    System.out.println(("El número ingresado es par: " + num));
                }
                System.out.println("Ingrese otro número entero par (0 para salir):");
                num = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }

        // ejemplo 4 - do while
        num = 1;

        do {
            if (num % 2 == 0) {
                System.out.println(num + " es par");
            }
            num++;
        } while (num <= 5);

        // ejemplo 5 - do while
        try {
            do {
                System.out.println("Ingrese un número entero (0 para salir):");
                num = Integer.valueOf(entrada.readLine());
                System.out.println("El número ingresado es: " + num);
            } while (num != 0);
        } catch (Exception exc) {
            System.out.println(exc);
        }

        // ejemplo 6 - for
        for (int i = 1; i <= 4; i++) {
            System.out.println("El número es: " +  i);
        }

        // ejemplo 7 - for
        for (int i = 1; i <= 5; i++) {
            System.out.println("El número es: " +  i);
            if (i % 2 == 0) {
                System.out.println("El número es par.");
            }
        }

        // ejemplo 8 - for
        for (int i = 1; i <= 10; i++) {
            System.out.println("3 x " + i + " = " + (3 * i));
        }

        // ejemplo 9 - iteraciones anidadas
        try {
            System.out.println("Ingrese un número entero entre 1 y 3:");
            num = Integer.valueOf(entrada.readLine());

            if ((num >= 1) && (num <= 3)) {
                System.out.println("El número ingresado es: " + num);

                for (int i = 1; i <= 10; i++) {
                    System.out.println(num + " x " + i + " = " + (num * i));
                }
            } else {
                System.out.println("El número ingresado no es un entero entre 1 y 3.");
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }

        // ejemplo 10 - iteraciones anidadas
        int menor = 1000;

        try {
            System.out.println("Ingrese un número entero entre 0 y 1000 (no incluídos):");
            num = Integer.valueOf(entrada.readLine());

            while ((num > 0) && (num < 1000)) {
                if (num < menor) {
                    menor = num;
                }
                System.out.println("Ingrese otro número entero entre 0 y 1000 (no incluídos):");
                num = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }

        System.out.println("El menor número ingresado fue: " +  menor);
    }
}
