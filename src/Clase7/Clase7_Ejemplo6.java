package Clase7;

/* Hacer un programa que dado un arreglo de enteros ordenado creciente de tamano 10 que se encuentra
precargado, encuentre la posicion donde se encuentra un numero entero ingresado por el usuario. Si existe,
muestre esa posicion por pantalla, o indique que no existe. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase7_Ejemplo6 {
    public static final int max = 10;

    public static void main(String[] args) {
        int [] intArray;
        intArray = new int[max];
        int number, position;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            fillIntArrayConsole(intArray);
            printIntArray(intArray);
            System.out.println("Ingrese el número entero que desea buscar:");
            number = Integer.valueOf(entrada.readLine());
            position = getPositionArray(intArray, number);
            if ((position < max) && (intArray[position] == number)) {
                System.out.println("La posición de " + number + " es: " + position);
            } else {
                System.out.println(number + " no existe en el arreglo.");
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void fillIntArrayConsole(int [] array) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int i = 0; i < max; i++) {
                System.out.println("Ingrese un valor número entero en la posición " + i);
                array[i] = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void printIntArray(int [] array) {
        for (int i = 0; i < max; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println(" ");
    }

    public static int getPositionArray(int [] array, int number) {
        int position = 0;
        while ((position < max) && (array[position] < number)) {
            position++;
        }
        return position;
    }
}
