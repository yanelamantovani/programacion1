package Clase7;

/*
Hacer un programa que dado un arreglo ordenado creciente de enteros de tamaño 10 que se encuentra precargado,
solicite al usuario un numero entero y lo inserte en el arreglo manteniendo su orden. Para ello tendrá que
realizar un corrimiento a derecha (se pierde el último valor del arreglo) y colocar el numero en el arreglo
en la posición indicada.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp7_Ej07 {
    public static final int MAX = 10;

    public static void main(String[] args) {
        int [] intArray;
        intArray = new int[MAX];
        int number, position;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            fillIntArrayConsole(intArray);
            printIntArray(intArray);
            System.out.println("Ingrese el número entero que desea buscar:");
            number = Integer.valueOf(entrada.readLine());
            position = getPositionArray(intArray, number);
            shiftRight(intArray, position, number);
            printIntArray(intArray);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void fillIntArrayConsole(int [] array) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int i = 0; i < MAX; i++) {
                System.out.println("Ingrese un valor número entero en la posición " + i);
                array[i] = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void printIntArray(int [] array) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println(" ");
    }

    public static int getPositionArray(int [] array, int number) {
        int position = 0;
        while ((position < MAX) && (array[position] < number)) {
            position++;
        }
        return position;
    }

    public static void shiftRight(int [] array, int position, int number) {
        int i = MAX - 1;
        while (i > position) {
            array[i] = array[i - 1];
            i--;
        }
        array[position] = number;
    }
}
