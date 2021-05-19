package Clase3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase3_Ejemplos {
    public static void main(String[] args) {

        //operadores aritméticos
        int num1, num2, suma, resta, multiplicacion, division, modulo;

        num1 = 10;
        num2 = 5;

        suma = num1 + num2;
        resta = num1 - num2;
        multiplicacion = num1 * num2;
        division = num1 / num2;
        modulo = num1 % num2;

        System.out.println("Operador suma: num1 + num2 = " + suma);
        System.out.println("Operador resta: num1 - num2 = " + resta);
        System.out.println("Operador multiplicación: num1 * num2 = " + multiplicacion);
        System.out.println("Operador división: num1 / num2 = " + division);
        System.out.println("Operador módulo: num1 % num2 = " + modulo);

        //operadores incrementales
        num1++;
        System.out.println("num1 = " + num1);
        num1 = 10;
        ++num1;
        System.out.println("num1 = " + num1);
        num1 = 10;
        num2 = num1++;
        System.out.println("num1 = " + num1 + " y num2 = " + num2);
        num1 = 10;
        num2 = ++num1;
        System.out.println("num1 = " + num1 + " y num2 = " + num2);

        //operadores aritméticos combinados
        num1 = 10;
        num2 = 5;

        num1 += num2; //ahora num1 vale 15
        num2 -= num1; // ahora num2 vale -10

        System.out.println("Operador combinado suma: num1 += num2 = " + num1);
        System.out.println("Operador combinado resta: num1 -= num2 = " + num2);

        //operadores relacionales
        char c1, c2;
        boolean resultado;

        num1 = 10;
        num2 = 5;
        c1 = '7';
        c2 = '5';
        resultado = (num1 != num2);

        System.out.println("Operador igual que: " + (c1 == c2));
        System.out.println("Operador distinto que: " + resultado);
        System.out.println("Operador mayor que: " + (c1 > c2));

        //operadores lógicos
        /* Escribir un programa que permita el ingreso de dos números enteros por teclado e imprima
        el resultado de comparar: 1) si el primero es múltiplo de 3, 2) si el primero es múltiplo de
        5, 3) si el primero es múltiplo del segundo, 4) si el primero es múltiplo de 3 y de 5.*/
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese un número entero:");
            num1 = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese otro número entero:");
            num2 = Integer.valueOf(entrada.readLine());
            resultado = ((num1 % 3) == 0);
            System.out.println("El primer número es múltiplo de 3?:" + resultado);
            resultado = ((num1 % 5) == 0);
            System.out.println("El primer número es múltiplo de 5?:" + resultado);
            resultado = ((num1 % num2) == 0);
            System.out.println("El primer número es múltiplo del segundo?:" + resultado);
            resultado = (((num1 % 3) == 0) && ((num1 % 5) == 0));
            System.out.println("El primer número es múltiplo de 3 y 5?:" + resultado);
        }
        catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
