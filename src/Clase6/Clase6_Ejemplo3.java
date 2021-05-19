package Clase6;

/*Escribir un programa que llame un método que calcule el promedio de la suma de valores
enteros entre 1 y 1000. Finalmente, el resultado debe mostrarse por pantalla. */

public class Clase6_Ejemplo3 {
    public static void main(String[] args) {
        int promedio; // declaro una variable del mismo tipo para guardar el valor que retorna la función
        promedio = calcular_promedio();
        System.out.println("EL promedio de la suma de los valores enteros entre 1 y 1000 es: " + promedio);
    }

    public static int calcular_promedio() {
        final int max = 1000;
        final int min = 1;
        int promedio;
        int suma = 0;
        for (int num = min; num <= max; num++) {
            suma += num;
        }
        promedio = suma / max;
        return promedio;
    }
}
