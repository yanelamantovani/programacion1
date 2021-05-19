package Clase7;

/*Hacer un programa que dado un arreglo de enteros de tamano 10 que se encuentra precargado,
encuentre la posicion de un numero entero ingresado por el usuario. Si existe, muestre esa posicion
por pantalla, o indique que no existe. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Clase7_Ejemplo4 {
    public static final int max = 10;
    public static final int maxValor = 10;
    public static final int minValor = 1;

    public static void main(String[] args) {
        int [] intArray = new int[max];
        int number, position;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            fillRandomIntArray(intArray);
            printIntArray(intArray);
            System.out.println("Ingresar número entero:");
            number = Integer.valueOf(entrada.readLine());
            position = getPositionArray(intArray, number);
            if (position < max) {
                System.out.println(number + " está en la posición " + position);
            } else {
                System.out.println(number + " no existe");
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void fillRandomIntArray(int [] array) {
        Random r = new Random();
        for (int i = 0; i < max; i++) {
            array[i] = (r.nextInt(maxValor - minValor + 1) + minValor);
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
        while ((position < max) && (array[position] != number)) {
            position++;
        }
        return position;
    }
}
