/*
Se tiene un arreglo ORIGINAL precargado de caracteres letras minúsculas de tamaño MAX que está ordenado de
forma ascendente. Además se tiene un arreglo ORDEN1 precargado de tamaño MAX. ORDEN1 tiene posiciones de
ORIGINAL de forma tal que permita recorrer de forma ascendente y consecutiva los caracteres vocales de ORIGINAL.
ORDEN1 tendrá valores -1 al final en el caso de que ORIGINAL tenga consonantes. Se pide:
– Dada una posición ingresada por el usuario desde teclado, eliminar la letra de dicha posición en ORIGINAL,
y actualizar el arreglo ORDEN1.
– Imprimir los caracteres vocales siguiendo el orden establecido en ORIGINAL.
 */

package Clase7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Tp7_Ej18 {
    public static final int MAX = 10;

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        char [] original;
        int [] orden1;
        original = new char[MAX];
        orden1 = new int[MAX];
        try {
            System.out.println("Arreglo ORIGINAL:");
            cargarArrayCaracteres(original);
            imprimirArrayCaracteres(original);
            System.out.println("Arreglo ORIGINAL ordenado:");
            ordenarArrayCaracteres(original);
            imprimirArrayCaracteres(original);
            System.out.println("Arreglo ORDEN1 con posiciones de vocales en ORIGINAL en orden ascendente:");
            inicializarArrayIndices(orden1);
            cargarArrayIndicesVocalesOrdenado(original,orden1);
            imprimirArrayIndices(orden1);
            System.out.println("Ingrese un indice del arreglo ORIGINAL:");
            int indice = Integer.valueOf(entrada.readLine());
            System.out.println("Arreglo ORIGINAL ordenado sin caracter de la posicion ingresada:");
            eliminarCaracterArray(original,indice);
            imprimirArrayCaracteres(original);
            System.out.println("Arreglo ORDEN1 con posiciones de vocales en ORIGINAL en orden ascendente:");
            inicializarArrayIndices(orden1);
            cargarArrayIndicesVocalesOrdenado(original,orden1);
            imprimirArrayIndices(orden1);
            System.out.println("Vocales ordenadas del arreglo ORIGINAL:");
            imprimirVocales(original,orden1);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static void cargarArrayCaracteres(char [] array) {
        Random r = new Random();
        for (int i = 0; i < MAX; i++) {
            array[i] = (char) (r.nextInt(26) + 'a');
        }
    }

    public static void imprimirArrayCaracteres(char [] array) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println("");
    }

    public static void ordenarArrayCaracteres(char [] array) {
        int posMenor;
        char aux;
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

    public static void inicializarArrayIndices(int [] orden1){
        for (int pos = 0; pos < MAX; pos++){
            orden1[pos] = -1;
        }
    }

    public static void cargarArrayIndicesVocalesOrdenado(char[] original, int [] orden1) {
        int i = 0;
        for (int pos = 0; pos < MAX; pos++) {
            switch (original[pos]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    orden1[i] = pos;
                    i++;
                    break;
            }
        }
    }

    public static void imprimirArrayIndices(int [] array) {
        for (int i = 0; i < MAX; i++) {
            System.out.print("[" + array[i] + "]");
        }
        System.out.println("");
    }

    public static void eliminarCaracterArray(char [] original, int indice) {
        while (indice < MAX - 1) {
            original[indice] = original[indice + 1];
            indice++;
        }
    }

    public static void imprimirVocales(char [] original, int[] orden1) {
        int i = 0;
        while (orden1[i] != -1) {
            System.out.println("Posición " + orden1[i] + ": " + original[orden1[i]]);
            i++;
        }
    }
}
