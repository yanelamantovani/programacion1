package Clase6;

/* Siguiendo la Clase 4 Ejercicio 4, hacer un programa completo (usando métodos donde se requiera)
en el cual se solicite de teclado el ingreso de un día, un número de mes, y un año; luego calcule la
cantidad de días desde la última luna nueva (edad lunar), e informe por pantalla en cual de las 4 fases
se corresponde para esa fecha. */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tp6_Ej12 {
    public static void main(String[] args) {
        int dia, mes, anio, aureo, epacta, edad_lunar;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Ingrese un día");
            dia = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese un mes");
            mes = Integer.valueOf(entrada.readLine());
            System.out.println("Ingrese un anio");
            anio = Integer.valueOf(entrada.readLine());

            aureo = calcular_aureo(anio);
            epacta = calcular_epacta(aureo);
            edad_lunar = calcular_edad_lunar(epacta, mes, dia);

            System.out.println("La cantidad de días desde la última luna nueva (edad lunar) es de " + edad_lunar + " días.");
            calcular_fase_lunar(edad_lunar);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    public static int calcular_aureo(int anio) {
        int aureo;
        aureo = (anio + 1) % 19;
        return aureo;
    }

    public static int calcular_epacta(int aureo) {
        int epacta;
        epacta = ((aureo - 1) * 11) % 30;
        return epacta;
    }

    public static int calcular_edad_lunar(int epacta, int mes, int dia) {
        int suma_mes, edad_lunar;
        if ((mes >= 3) && (mes <= 12)) {
            suma_mes = mes - 2;
        } else {
            suma_mes = mes + 10;
        }
        edad_lunar = epacta + suma_mes + dia;
        if (edad_lunar > 29) {
            edad_lunar = edad_lunar % 30;
        }
        return edad_lunar;
    }

    public static void calcular_fase_lunar (int edad_lunar) {
        if (edad_lunar < 7) {
            System.out.println("La fase lunar es LUNA NUEVA");
        } else if (edad_lunar < 15) {
            System.out.println("La fase lunar es CUARTO CRECIENTE");
        } else if (edad_lunar < 22){
            System.out.println("La fase lunar es LUNA LLENA");
        } else if (edad_lunar < 29){
            System.out.println("La fase lunar es CUARTO MENGUANTE");
        }
    }
}
