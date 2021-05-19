package Clase4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Clase4_Ejemplos {
    public static void main(String[] args) {

        // sentencia selectiva if-else
        int valor = 7;

        if (valor % 2 == 0) {
            System.out.println(valor + " es par.");
        }
        else if (valor % 3 == 0){
            System.out.println(valor + " es múltiplo de 3.");
        }
        else {
            System.out.println(valor + " no es impar ni múltiplo de 3.");
        }

        System.out.println("El valor es " +  valor);

        // ejemplo 5
        int num;

        try {
            BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
            System.out.println("Ingrese un número entero:");
            num = Integer.valueOf(entrada.readLine());
            if (num % 5 == 0) {
                System.out.println("A");
            }
            else if (num % 7 == 0) {
                System.out.println("B");
            }
            else if ((num % 2 == 0) && (num % 3 == 0)){
                System.out.println("C");
            }
            else {
                System.out.println("El número es: " + num);
            }
        }
        catch (Exception exc) {
            System.out.println(exc);
        }

        // ejemplo 6
        char caracter;

        try {
            BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));
            System.out.println("Ingrese un carácter:");
            caracter = entrada.readLine().charAt(0);
            if (('a' <= caracter) && (caracter <= 'z')){ // una de las propiedad de los caracteres es el orden
                System.out.println("El carácter es minúscula");
            }
            else if (('A' <= caracter) && (caracter <= 'Z')){
                System.out.println("El carácter es mayúscula");
            }
            else {
                System.out.println("No es carácter letra.");
            }
        }
        catch (Exception exc) {
            System.out.println(exc);
        }

        // if-else anidados - ejemplo 8
        valor = 6;
        if (valor % 2 == 0) {
            System.out.println("Es par");
            if (valor > 4) {
                System.out.println("Es mayor a 4");
            }
            else {
                System.out.println("No es mayor a 4");
            }
        }
        else {
            System.out.println("Es impar");
        }

        // sentencia switch - ejemplo 9
        char vocal = 'i';
        switch (vocal) {
            case 'a': {
                System.out.println("Vocal a");
                break;
            }
            case 'b': {
                System.out.println("Vocal e");
                break;
            }
            case 'i': {
                System.out.println("Vocal i");
                break;
            }
            default: {
                System.out.println("Ninguna de las opciones anteriores.");
            }
        }

        // ejemplo 10
        int n;
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese un número entero:");
            n = Integer.valueOf(entrada.readLine());
            switch (n) {
                case 0: {
                    System.out.println("Es 0.");
                    break;
                }
                case 1:
                case 2: {
                    System.out.println("Es 1 o 2.");
                    break;
                }
                default: {
                    if (n < 0) {
                        System.out.println("Es negativo");
                    } else {
                        System.out.println("Es positivo");
                    }
                }
            }
        }
        catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
