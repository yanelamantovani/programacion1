package Clase2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase2_Ejemplos {
    public static void main(String[] args) {
         //declaro variables
         int edad;
         double altura, peso;
         boolean existe;
         //asigno valores
         edad = 30;
         altura = 1.7;
         existe = false;
         peso = 75.5;
         //imprimo
         System.out.println("El valor de peso es: " + peso);

         char caracter1;
         caracter1 = 'c';
         char caracter2;
         caracter2 = '1';
         int numero;
         numero = 1;
         System.out.println("El valor de caracter2 es: " + caracter2);
         System.out.println("El valor de numero es: " + numero);

         int entero;
         // try captura posibles errores o excepciones
         try {
            // buffer donde se van a cargar los datos por consola
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            // imprime un mensaje para pedir el dato
            System.out.println("Ingrese un entero: ");
            // permite el ingreso del dato el cual se convierte a entero mediante Integer.valueOf()
            entero = Integer.valueOf(entrada.readLine());
            // imprimo un mensaje con el valor ingresado
            System.out.println("EL valor ingresado es: " + entero);
         }
         // catch se ejecuta solo cuando ocurre un error en el bloque try
         // exc es una variable de tipo Exception cuyo valor es el tipo de error
         catch (Exception exc){
            // imprimo un mensaje con el tipo de error
            System.out.println(exc);
         }

         float flotante;
         double doble;
         int integer;
         char letra;
         String cadena;

         try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese un float:");
            flotante = Float.valueOf(entrada.readLine());
            System.out.println("Ingrese un double:");
            doble = Double.valueOf(entrada.readLine());
            System.out.println("Ingrese un entero:");
            integer = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese un caracter:");
            letra = entrada.readLine().charAt(0);
            System.out.println("Ingrese una cadena:");
            cadena = entrada.readLine();

            System.out.println("EL valor del float es: " + flotante);
            System.out.println("El valor del double es: " + doble);
            System.out.println("El valor del entero es: " + integer);
            System.out.println("El valor del caracter es: " + letra);
            System.out.println("EL valor de cadena es: " + cadena);
         }
         catch (Exception exc) {
            System.out.println(exc);
         }
    }
}