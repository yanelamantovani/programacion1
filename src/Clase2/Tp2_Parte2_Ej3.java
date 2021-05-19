package Clase2;

/* Escribir un programa que pida que se ingresen datos necesarios para emitir una
factura por la compra de dos artículos de librería (tipo factura, número, nombre
cliente, producto 1, importe 1, producto 2, importe 2, importe total). Como
salida debe imprimir por pantalla la factura en un formato similar al siguiente
(utilizar literales):

Factura             C                   201
Nombre y Apellido   Jorge Rodríguez
Producto                                Importe
Lápices                                 12.2
Cuadernos                               20.0
Importe Total                           30.2 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp2_Parte2_Ej3 {
    public static void main(String[] args) {
        char tipoFactura;
        int numeroFactura;
        String cliente, producto1, producto2;
        double importe1, importe2, importeTotal;

        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese el tipo de factura: ");
            tipoFactura = entrada.readLine().charAt(0);
            System.out.println("Ingrese el número de factura: ");
            numeroFactura = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese el nombre y apellido del cliente: ");
            cliente = entrada.readLine();
            System.out.println("Ingrese el producto 1: ");
            producto1 = entrada.readLine();
            System.out.println("Ingrese el importe 1: ");
            importe1 = Double.valueOf(entrada.readLine());
            System.out.println("Ingrese el producto 2: ");
            producto2 = entrada.readLine();
            System.out.println("Ingrese el importe 2: ");
            importe2 = Double.valueOf(entrada.readLine());

            importeTotal = importe1 + importe2;

            System.out.println("Factura             " + '\t' + tipoFactura + "                   " + '\t' + numeroFactura);
            System.out.println("Nombre y apellido   " + '\t' + cliente);
            System.out.println("Producto            " + '\t' + "                    " + '\t' + "Importe");
            System.out.println(producto1 + "             " + '\t' + "                    " + '\t' + importe1);
            System.out.println(producto2 + "           " + '\t' + "                    " + '\t' + importe2);
            System.out.println("Importe Total       " + '\t' + "                    " + '\t' + importeTotal);
        }
        catch (Exception exc) {
            System.out.println(exc);
        }
    }
}
