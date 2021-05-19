package Clase7;

/*Hacer un programa que cargue en un arreglo de enteros 5 valores desde teclado y lo imprima.*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase7_Ejemplo1 {
    public static final int max = 5;

    public static void main(String[] args) {
        //Declaro el arreglo y le asigno una dimensión
        int[] intArray = new int[max];
        fillArray(intArray);
        printArray(intArray);
    }

    public static void fillArray(int [] array) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int i = 0; i < max; i++) {
                System.out.println("Ingrese un número entero:");
                array[i] = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void printArray(int [] array) {
        for (int i = 0; i < max; i++) {
            System.out.println("intArray[" + i + "] -> " + array[i]);
        }
        // Otra forma de imprimirlo: System.out.print("[" + intArray[i] + "]");
    }
}
