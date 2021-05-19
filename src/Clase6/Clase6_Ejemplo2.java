package Clase6;

/* Hacer un método que dado un numero entero con valor inicial 1, haga una iteración
incrementando numero de a uno hasta un valor MAX = 4 (constante). Mientras itera deberá
imprimir numero. Luego invocarlo desde el programa principal y cuando termina imprimir
por pantalla “termino”. */

public class Clase6_Ejemplo2 {
    // main e imprimir_hasta4 son métodos del programa Clase6_Ejemplo2

    // main es el método principal del programa e invoca al método imprimir_hasta4
    public static void main(String[] args) {
        imprimir_hasta4();
        System.out.println("Terminó");
    }

    public static void imprimir_hasta4 () {
        // es void porque no retorna nada, solo imprime por pantalla
        final int max = 4;
        for (int num = 1; num <= max; num++) {
            System.out.println("El número es: " + num);
        }

    }
}
