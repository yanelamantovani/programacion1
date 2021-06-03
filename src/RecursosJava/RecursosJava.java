package RecursosJava;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class RecursosJava {
    public static final int MAX = 10; // Dimensión de los arrays/matrices
    public static final int MAXVALOR = 9; // Máximo del random
    public static final int MINVALOR = 1; // Mínimo del random
    public static final double probabilityLetter = 0.4; // Para secuencias de caracteres random
    public static final double probabilityNumber = 0.4; // Para secuencias de enteros random

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        // Try - Catch
        try {
        } catch (Exception exc) {
            System.out.println(exc);
        }

//        // Pedir datos por consola
//        System.out.println("Ingrese un float:");
//        float flotante = Float.valueOf(entrada.readLine());
//        System.out.println("Ingrese un double:");
//        double doble = Double.valueOf(entrada.readLine());
//        System.out.println("Ingrese un entero:");
//        int integer = Integer.valueOf(entrada.readLine());
//        System.out.println("Ingrese un caracter:");
//        char letra = entrada.readLine().charAt(0);
//        System.out.println("Ingrese una cadena:");
//        String cadena = entrada.readLine();

        // Declaración de arrays
        char [] charArray;
        int [] intArray;
        double [] doubleArray;

        // Inicialización de los arrays (dimensión)
        charArray = new char[MAX];
        intArray = new int[MAX];
        doubleArray = new double[MAX];

        // Funciones para cargar arrays
        fillCharArrayConsole(charArray);
        fillRandomCharArray(charArray);
        fillIntArrayConsole(intArray);
        fillRandomIntArray(intArray);
        fillDoubleArrayConsole(doubleArray);
        fillRandomDoubleArray(doubleArray);

        // Funciones para imprimir arrays
        printCharArray(charArray);
        printIntArray(intArray);
        printDoubleArray(doubleArray);
        printReverseArray(intArray); // Imprimir al revés

//        // Funciones para ordenar arrays de enteros
//        sortArraySeleccion(intArray);
//        sortArrayInsercion(intArray);
//        sortArrayBurbujeo(intArray);
//        System.out.println("Ingrese la primer posición:"); // Ordenar entre dos posiciones
//        int position1 = Integer.valueOf(entrada.readLine());
//        System.out.println("Ingrese la segunda posición:");
//        int position2 = Integer.valueOf(entrada.readLine());
//        sortBetween(intArray, position1, position2);

//        // Funciones para cargar secuencias de arrays
//        fillRandomCharSequenceArray(charArray);
//        fillRandomIntSequenceArray(intArray);

//        // Otras funciones con arrays
//        calculateAverage(intArray); // Suma y promedio de enteros
//        System.out.println("Ingresar número entero:"); // Buscar posición de un entero
//        int number = Integer.valueOf(entrada.readLine());
//        int position = getPositionArray(intArray, number);
//        shiftLeft(intArray, position); // Corrimiento hacia izquierda
//        shiftRight(intArray, position); // Corrimiento hacia derecha
//        System.out.println("Ingresar un número que se agregará en la primera posición:"); // Insertar entero y correr a la derecha
//        number = Integer.valueOf(entrada.readLine());
//        insertShiftRight(intArray, number);
//        reverseArray(intArray); // Invertir valores
//        int totalEvenNumbers = findEvenNumbers(intArray); // Buscar pares
//        findRepeated(intArray, number); // Buscar repeticiones
//        int startingPosition = getStartingPositionSequenceArray(intArray, position); // Buscar inicio de la siguiente secuencia
//        int finalPosition = getFinalPositionSequenceArray(intArray, startingPosition); // Buscar fin de la siguiente secuencia
    }

    // Cargar array de caracteres por consola
    public static void fillCharArrayConsole(char [] array) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int i = 0; i < MAX; i++) {
                System.out.println("Ingrese un caracter:");
                array[i] = entrada.readLine().charAt(0);
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    // Cargar array de caracteres aleatorios
    public static void fillRandomCharArray(char [] array) {
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            array[i] = (char) (r.nextInt(26) + 'a');
        }
    }

    // Cargar array de enteros por consola
    public static void fillIntArrayConsole(int [] array) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int i = 0; i < MAX; i++) {
                System.out.println("Ingrese un número entero:");
                array[i] = Integer.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    // Cargar array de enteros aleatorios
    public static void fillRandomIntArray(int [] array) {
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            array[i] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
        }
    }

    // Cargar array de doubles por consola
    public static void fillDoubleArrayConsole(double [] array) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int i = 0; i < MAX; i++) {
                System.out.println("Ingrese un número real:");
                array[i] = Double.valueOf(entrada.readLine());
            }
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    // Cargar array de doubles aleatorios
    public static void fillRandomDoubleArray(double [] array) {
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            array[i] = ((MAXVALOR - MINVALOR + 1) * r.nextDouble() + MINVALOR * 1.0);
        }
    }

    // Imprimir array de caracteres
    public static void printCharArray(char [] array) {
        for (int i = 0; i < MAX; i++) {
            System.out.println("charArray[" + i + "] -> " + array[i]);
        }
        // Otra forma de imprimirlo: System.out.print("[" + array[i] + "]");
    }

    // Imprimir array de enteros
    public static void printIntArray(int [] array) {
        for (int i = 0; i < MAX; i++) {
            System.out.println("intArray[" + i + "] -> " + array[i]);
        }
        // Otra forma de imprimirlo: System.out.print("[" + array[i] + "]");
    }

    // Imprimir array de doubles
    public static void printDoubleArray(double [] array) {
        for (int i = 0; i < MAX; i++) {
            System.out.println("doubleArray[" + i + "] -> " + array[i]);
        }
        // Otra forma de imprimirlo: System.out.print("[" + array[i] + "]");
    }

    // Imprimir array de enteros al revés
    public static void printReverseArray(int [] array) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("[" + array[MAX - 1 - i] + "]");
        }
    }

    // Ordenar array de enteros por selección
    public static void sortArraySeleccion(int [] array) {
        int posMenor, aux;
        for (int i = 0; i < MAX; i++) {
            posMenor = i;
            for (int j = i + 1; j < MAX; j++) {
                if (array[j] < array[posMenor]) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                aux = array[i];
                array[i] = array[posMenor];
                array[posMenor] = aux;
            }
        }
    }

    // Ordenar array de enteros por inserción
    public static void sortArrayInsercion(int [] array) {
        int j, aux;
        for (int i = 1; i < MAX; i++) {
            aux = array[i];
            j = i - 1;
            while ((j >= 0) && (array[j] > aux)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = aux;
        }
    }

    // Ordenar array de enteros por burbujeo
    public static void sortArrayBurbujeo(int [] array) {
        int aux;
        for (int i = 1; i < MAX; i++) {
            for (int j = 0; j < MAX - 1; j++) {
                if (array[j] > array[j+1]) {
                    aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }

    // Ordenar array de enteros entre dos posiciones
    public static void sortBetween(int [] array, int position1, int position2) {
        int posMenor, aux;
        for (int i = position1; i <= position2; i++) {
            posMenor = i;
            for (int j = i + 1; j <= position2; j++) {
                if (array[j] < array[posMenor]) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                aux = array[i];
                array[i] = array[posMenor];
                array[posMenor] = aux;
            }
        }
    }

    // Cargar secuencias de caracteres en arrays
    public static void fillRandomCharSequenceArray(char [] array) {
        Random r = new Random();
        array[0] = ' ';
        array[MAX - 1] = ' ';
        for (int i = 1; i < MAX - 1; i++) {
            if (r.nextDouble() > probabilityLetter) {
                array[i] = (char) (r.nextInt(26) + 'a');
            } else {
                array[i] = ' ';
            }
        }
    }

    // Cargar secuencias de enteros en arrays
    public static void fillRandomIntSequenceArray(int [] array) {
        Random r = new Random();
        array[0] = 0;
        array[MAX - 1] = 0;
        for (int i = 1; i < MAX - 1; i++) {
            if (r.nextDouble() > probabilityNumber) {
                array[i] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                array[i] = 0;
            }
        }
        array [MAX - 2] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR); // Evito que el anteúltimo número sea un 0 y me de error al buscar la última secuencia
    }

    // Calcular suma y promedio de los enteros de un array
    public static int calculateAverage(int [] array) {
        int suma = 0;
        for (int i = 0; i < MAX; i++) {
            suma += array[i];
        }
        return (suma / MAX);
    }

    // Buscar posición de un entero en un array
    public static int getPositionArray(int [] array, int number) {
        int position = 0;
        while ((position < MAX) && (array[position] != number)) {
            position++;
        }
        return position;
    }

    // Correr hacia izquierda de una posición un array de enteros
    public static void shiftLeft(int [] array, int position) {
        int i = 0;
        while (i < position) {
            array[i] = array[i + 1];
            i++;
        }
    }

    // Correr hacia derecha de una posición un array de enteros
    public static void shiftRight(int [] array, int position) {
        int i = MAX - 1; // Ultima posicion del vector
        while (i > position) {
            array[i] = array[i - 1]; // Desplazo desde el final hasta la posición
            i--;
        }
    }

    // Insertar valor y correr valores hacia derecha en un array de enteros
    public static void insertShiftRight(int [] array, int number) {
        int i = MAX - 1;
        while (i > 0) {
            array[i] = array[i - 1];
            i--;
        }
        array[0] = number;
    }

    // Invertir valores en un array de enteros
    public static void reverseArray(int [] array) {
        int aux;
        for (int i = 0; i < MAX / 2; i++) {
            aux = array[i];
            array[i] = array[MAX - 1 - i];
            array[MAX - 1 - i] = aux;
        }
    }

    // Buscar cantidad de enteros pares en un array
    public static int findEvenNumbers(int [] array) {
        int totalEvenNumbers = 0;
        for (int i = 0; i < MAX; i++) {
            if (array[i] % 2 == 0) {
                totalEvenNumbers++;
            }
        }
        return totalEvenNumbers;
    }

    // Buscar repeticiones de enteros en un array
    public static void findRepeated(int [] array, int number) {
        int repeats = 0;
        for (int i = 0; i < MAX; i++) {
            if (array[i]  == number) {
                System.out.println(number + " se encuentra en la posición " + i);
                repeats++;
            }
        }
        if (repeats > 0) {
            System.out.println(number + " se repite " + repeats + " veces.");
        } else {
            System.out.println(number + " no se encuentra en el arreglo.");
        }

    }

    // Buscar inicio de la siguiente secuencia
    public static int getStartingPositionSequenceArray(int [] array, int position) {
        while (array[position] != 0) {
            position++;
        }
        while (array[position] == 0) {
            position++;
        }
        int startingPosition = position;
        return startingPosition;
    }

    // Buscar fin de la siguiente secuencia
    public static int getFinalPositionSequenceArray(int [] array, int startingPosition) {
        while (array[startingPosition] != 0) {
            startingPosition++;
        }
        int finalPosition = startingPosition - 1;
        return finalPosition;
    }

    // Ordenar matriz por columnas
/*    public static void ordenarColumnasMatriz(int [][] intMatriz) {
        int posMenor, aux;
        for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
            for (int fila = 0; fila < MAXFILAS; fila++) {
                posMenor = fila;
                for (int i = fila + 1; i < MAXFILAS; i++) {
                    if (intMatriz[i][columna] < intMatriz[posMenor][columna]) {
                        posMenor = i;
                    }
                }
                if (posMenor != fila) {
                    aux = intMatriz[fila][columna];
                    intMatriz[fila][columna] = intMatriz[posMenor][columna];
                    intMatriz[posMenor][columna] = aux;
                }
            }
        }
    }*/

    // Ordenar matriz por filas
/*    public static void ordenarFilasMatriz(int[][] intMatriz) {
        int posMenor, aux;
        for (int fila = 0; fila < MAXFILAS; fila++) {
            for (int columna = 0; columna < MAXCOLUMNAS; columna++) {
                posMenor = columna;
                for (int i = columna + 1; i < MAXCOLUMNAS; i++) {
                    if (intMatriz[fila][i] < intMatriz[fila][posMenor]) {
                        posMenor = i;
                    }
                }
                if (posMenor != columna) {
                    aux = intMatriz[fila][columna];
                    intMatriz[fila][columna] = intMatriz[fila][posMenor];
                    intMatriz[fila][posMenor] = aux;
                }
            }
        }
    }*/
}