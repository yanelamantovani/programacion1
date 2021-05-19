package Clase2;

/* Escribir un programa que declare tres variables de tipo double y
una constante de tipo double con valor 1.0 . Luego deberá
asignar el valor de la constante a una de la variables declaradas,
y posteriormente sobre las dos restantes variables se le deberá
asignar el valor de la variable que inicialmente fue seteada con el
valor de la constante. Finalmente imprima por pantalla cada una
de las variables. */

public class Tp2_Parte1_Ej2 {
    public static void main(String[] args) {
        double var1;
        double var2;
        double var3;
        final double constante;
        double aux;

        var1 = 5.0;
        var2 = 10.0;
        var3 = 15.0;
        constante = 1.0;
        aux = var1;

        var1 = constante;
        var2 = aux;
        var3 = aux;

        System.out.println("El valor de la variable 1 es: " + var1);
        System.out.println("El valor de la variable 2 es: " + var2);
        System.out.println("El valor de la variable 3 es: " + var3);
    }
}
