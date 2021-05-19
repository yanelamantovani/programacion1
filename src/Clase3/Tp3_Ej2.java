package Clase3;

/* Escribir un programa que imprima por pantalla la tabla de valores
de verdad para el or y and por separado. */

public class Tp3_Ej2 {
    public static void main(String[] args) {
        boolean verdadero, falso, resultado;
        verdadero = true;
        falso = false;
        falso = false;

        System.out.println("TABLA DE VERDAD DEL OPERADOR AND:");
        System.out.println("false && false = " + (falso && falso));
        System.out.println("false && true = " + (falso && verdadero));
        System.out.println("true && false = " + (verdadero && falso));
        System.out.println("true && true = " + (verdadero && verdadero));

        System.out.println("TABLA DE VERDAD DEL OPERADOR OR:");
        System.out.println("false || false = " + (falso || falso));
        System.out.println("false || true = " + (falso || verdadero));
        System.out.println("true || false = " + (verdadero || falso));
        System.out.println("true || true = " + (verdadero || verdadero));
    }
}
