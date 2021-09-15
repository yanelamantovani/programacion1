package Recursos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Recursos {
    public static final int MAXFILA = 4;
    public static final int MAXCOLUMNA = 20;
    public static final int MAXVALOR = 9;
    public static final int MINVALOR = 1;
    public static final double PROBABILIDAD = 0.4;

    public static void main(String[] args) {
        // Ingreso de datos por teclado
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Ingrese un dato:");
            int num = Integer.valueOf(entrada.readLine());
        } catch (Exception exc) {
            System.out.println(exc);
        }

        // Declaración
        int [] arrenteros = new int [MAXCOLUMNA];
        char [] arrchar = new char [MAXCOLUMNA];
        int [][] matint = new int [MAXFILA][MAXCOLUMNA];
        char [][] matchar = new char [MAXFILA][MAXCOLUMNA];

        // Carga
        cargar_arreglo_int(arrenteros);
        cargar_arreglo_char(arrchar);
        cargar_matriz_int(matint);
        cargar_matriz_char(matchar);
        cargar_arreglo_secuencias_int(arrenteros);
        cargar_arreglo_secuencias_char(arrchar);
        cargar_matriz_secuencias_int(matint);
        cargar_matriz_secuencias_char(matchar);
        inicializar_arreglo_int(arrenteros); // En -1

        // Impresión
        imprimir_arreglo_int(arrenteros);
        imprimir_arreglo_char(arrchar);
        imprimir_matriz_int(matint);
        imprimir_matriz_char(matchar);

        // Ordenamientos
        ordenar_arreglo_seleccion(arrenteros);
        ordenar_filas(matint);
        ordenar_columnas(matint);
        ordenar_arreglo_entre_pos(arrenteros, 0, 0);

        // Métodos para obtener posiciones
        recorrer_secuencias(arrenteros);
        int posFin = obtener_fin_secuencia(arrenteros, 0);
        int posInicio = obtener_inicio_secuencia(arrenteros, posFin + 1);
        int posInicioSiguiente = obtener_inicio_siguiente_secuencia(arrenteros, 0);
        int posNumDesordenado = obtener_pos_num_arreglo(arrenteros, 0);
        int posNumOrdenado = obtener_pos_arreglo_ord_crec(arrenteros, 0);
        imprimir_pos_num_matriz(matint,0);
        buscar_secuencia_suma_mayor_arreglo(arrenteros);
        buscar_secuencias_suma_mayor_matriz(matint);
        buscar_anteultima_secuencia_arreglo(arrenteros);
        buscar_anteultimas_secuencias_matriz(matint);

        // Corrimientos y modificaciones
        corrimiento_izq(arrenteros, 0); // Elimina pos - Duplica último
        corrimiento_der(arrenteros, 0); // Duplica pos - Elimina último
        insertar_num_arreglo(arrenteros, 0, 0);
        insertar_num_matriz(matint, 0, 0, 0);
        buscar_eliminar_num_matriz(matint, 0);
        buscar_eliminar_num_todos_matriz(matint, 0);
        eliminar_secuencia(arrenteros, posInicio, posFin); // Hace corrimiento a izquierda
        eliminar_secuencias_tamanio_arreglo(arrenteros, 0);
        eliminar_secuencias_tamanio_matriz(matint, 0);
        eliminar_secuencias_orden_descendente_arreglo(arrenteros);
        eliminar_secuencias_orden_descendente_matriz(matint);
        invertir_arreglo(arrenteros);
        invertir_matriz(matint);
        copiar_secuencia(arrenteros, arrenteros, 0, 0, 0);
        copiar_secuencias_tamanio_num(arrenteros, arrenteros, 0);

        // Métodos para hacer cálculos
        boolean sonArreglosIguales = son_iguales(arrenteros, arrenteros, 0, 0, 0, 0);
        boolean esSecuenciaDescendente = es_descendente(arrenteros, posInicio, posFin);
        int sumaSecuencia = obtener_suma_secuencia(arrenteros, posInicio, posFin);
        int cantParesArreglo = obtener_pares_arreglo(arrenteros);
        int cantParesMatriz = obtener_pares_matriz(matint);
        int promedioFila = obtener_promedio_arreglo(arrenteros);
        int promedioColumna = obtener_promedio_columna(matint, 0);
        imprimir_promedios_columnas_matriz(matint);
    }

    public static void cargar_matriz_int(int [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo_int(mat[fila]);
        }
    }

    public static void cargar_arreglo_int(int [] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
        }
    }

    public static void cargar_matriz_char(char [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo_char(mat[fila]);
        }
    }

    public static void cargar_arreglo_char(char [] arr) {
        Random r = new Random();
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            arr[pos] = (char)(r.nextInt(26) + 'a');
        }
    }

    public static void cargar_matriz_secuencias_int(int [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo_secuencias_int(mat[fila]);
        }
        System.out.println(" ");
    }

    public static void cargar_arreglo_secuencias_int(int [] arr) {
        Random r = new Random();
        arr[0] = 0;
        arr[MAXCOLUMNA - 1] = 0;
        for (int pos = 1; pos < MAXCOLUMNA - 1; pos++) {
            if (r.nextDouble() > PROBABILIDAD) {
                arr[pos] = (r.nextInt(MAXVALOR - MINVALOR + 1) + MINVALOR);
            } else {
                arr[pos] = 0;
            }
        }
    }

    public static void cargar_matriz_secuencias_char(char [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            cargar_arreglo_secuencias_char(mat[fila]);
        }
        System.out.println(" ");
    }

    public static void cargar_arreglo_secuencias_char(char [] arr) {
        Random r = new Random();
        arr[0] = ' ';
        arr[MAXCOLUMNA - 1] = ' ';
        for (int pos = 1; pos < MAXCOLUMNA - 1; pos++) {
            if (r.nextDouble() > PROBABILIDAD) {
                arr[pos] = (char) (r.nextInt(26) + 'a');
            } else {
                arr[pos] = ' ';
            }
        }
    }

    public static void imprimir_matriz_int(int [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            imprimir_arreglo_int(mat[fila]);
        }
    }

    public static void imprimir_arreglo_int(int [] arr) {
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println(" ");
    }

    public static void imprimir_matriz_char(char [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            imprimir_arreglo_char(mat[fila]);
        }
    }

    public static void imprimir_arreglo_char(char [] arr) {
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            System.out.print("[" + arr[pos] + "]");
        }
        System.out.println(" ");
    }

    public static int obtener_promedio_arreglo(int [] arr) {
        int suma = 0;
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            suma += arr[pos];
        }
        return suma / MAXCOLUMNA;
    }

    public static void imprimir_promedios_columnas_matriz(int [][] mat) {
        for (int columna = 0; columna < MAXCOLUMNA; columna++) {
            System.out.println("El promedio de la columna " + columna + " es: " + obtener_promedio_columna(mat, columna));
        }
    }

    public static int obtener_promedio_columna(int [][] mat, int columna) {
        int suma = 0;
        for (int fila = 0; fila < MAXFILA; fila++) {
            suma += mat[fila][columna];
        }
        return suma / MAXFILA;
    }

    public static void imprimir_pos_num_matriz(int [ ][ ] mat, int num) {
        int fila = 0;
        int columna = MAXCOLUMNA;
        while ((fila < MAXFILA) && (columna == MAXCOLUMNA)) {
            columna = obtener_pos_num_arreglo(mat[fila], num);
            if (columna == MAXCOLUMNA) {
                fila++;
            }
        }
        if ((fila < MAXFILA) && (columna < MAXCOLUMNA)) {
            System.out.println(num + " está en la fila " + fila + " columna " + columna);
        } else {
            System.out.println(num + " no existe en la matriz.");
        }
    }

    public static int obtener_pos_num_arreglo(int [ ] arr, int num) {
        int pos = 0;
        while ((pos < MAXCOLUMNA) && (arr[pos] != num)) {
            pos++;
        }
        return pos;
    }

    public static void corrimiento_izq(int [ ] arr, int pos) {
        while (pos < MAXCOLUMNA - 1) {
            arr[pos] = arr[pos + 1];
            pos++;
        }
    }

    public static void corrimiento_der(int [] arr, int pos) {
        int indice = MAXCOLUMNA - 1;
        while (indice > pos) {
            arr[indice] = arr[indice - 1];
            indice--;
        }
    }

    public static void insertar_num_matriz(int [ ][ ] mat, int fila, int columna, int num) {
        corrimiento_der(mat[fila], columna);
        mat[fila][columna] = num;
    }

    public static void insertar_num_arreglo(int [ ] arr, int pos, int num) {
        corrimiento_der(arr, pos);
        arr[pos] = num;
    }

    public static void ordenar_filas(int [ ][ ] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            ordenar_arreglo_seleccion(mat[fila]);
        }
    }

    public static void ordenar_arreglo_seleccion(int [ ] arr) {
        int posMenor, temp;
        for (int i = 0; i < MAXCOLUMNA; i++) {
            posMenor = i;
            for (int j = i + 1; j < MAXCOLUMNA; j++) {
                if (arr[j] < arr[posMenor]) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                temp = arr[i];
                arr[i] = arr[posMenor];
                arr[posMenor] = temp;
            }
        }
    }

    public static void ordenar_columnas(int [ ][ ] mat) {
        int posMenor, temp;
        for (int columna = 0; columna < MAXCOLUMNA; columna++) {
            for (int i = 0; i < MAXFILA; i++) {
                posMenor = i;
                for (int j = i + 1; j < MAXFILA; j++) {
                    if (mat[j][columna] < mat[posMenor][columna]) {
                        posMenor = j;
                    }
                }
                if (posMenor != i) {
                    temp = mat[i][columna];
                    mat[i][columna] = mat[posMenor][columna];
                    mat[posMenor][columna] = temp;
                }
            }
        }
    }

    public static void invertir_matriz(int [ ][ ] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            invertir_arreglo(mat[fila]);
        }
    }

    public static void invertir_arreglo(int [ ] arr) {
        int aux;
        for (int pos = 0; pos < MAXCOLUMNA / 2; pos++) {
            aux = arr[MAXCOLUMNA -  1 - pos];
            arr[MAXCOLUMNA -  1 - pos] = arr [pos];
            arr[pos] = aux;
        }
    }

    public static int obtener_pares_matriz(int [][] mat) {
        int cantPares = 0;
        for (int fila = 0; fila < MAXFILA; fila++) {
            cantPares += obtener_pares_arreglo(mat[fila]);
        }
        return cantPares;
    }

    public static int obtener_pares_arreglo(int [ ] arr) {
        int cantPares = 0;
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            if (arr[pos] % 2 == 0) {
                cantPares++;
            }
        }
        return cantPares;
    }

    public static void buscar_eliminar_num_matriz(int [ ][ ] mat, int num) {
        int fila = 0;
        int columna = MAXCOLUMNA;
        while ((fila < MAXFILA) && (columna == MAXCOLUMNA)) {
            columna = obtener_pos_num_arreglo(mat[fila], num);
            if (columna == MAXCOLUMNA) {
                fila++;
            }
        }
        if ((fila < MAXFILA) && (columna < MAXCOLUMNA)) {
            corrimiento_izq(mat[fila], columna);
            imprimir_matriz_int(mat);
        } else {
            System.out.println(num + " no existe en la matriz.");
        }
    }

    public static void buscar_eliminar_num_todos_matriz(int [ ][ ] mat, int num) {
        int columna;
        for (int fila = 0; fila < MAXFILA; fila++) {
            columna = obtener_pos_num_arreglo(mat[fila], num);
            int indice = 0;
            while ((columna < MAXCOLUMNA - 1) && (indice < MAXCOLUMNA - 1)) {
                corrimiento_izq(mat[fila], columna);
                columna = obtener_pos_num_arreglo(mat[fila], num);
                indice++;
            }
        }
    }

    public static int obtener_pos_arreglo_ord_crec(int [ ] arr, int num) {
        int pos = 0;
        while ((pos < MAXCOLUMNA) && (arr[pos] < num)) {
            pos++;
        }
        return pos;
    }

    public static void ordenar_arreglo_entre_pos(int [ ] arr, int posInicio, int posFin) {
        int posMenor, aux;
        for (int i = posInicio; i <= posFin; i++) {
            posMenor = i;
            for (int j = i + 1; j <= posFin; j++) {
                if (arr[j] < arr[posMenor]) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                aux = arr[i];
                arr[i] = arr[posMenor];
                arr[posMenor] = aux;
            }
        }
    }

    public static int obtener_inicio_siguiente_secuencia(int [ ] arr, int pos) {
        if ((arr[pos] != 0)) {
            pos = obtener_fin_secuencia(arr, pos) + 1;
        }
        while ((pos < MAXCOLUMNA) && (arr[pos] == 0)) {
            pos++;
        }
        return pos;
    }

    public static int obtener_fin_secuencia(int [ ] arr, int pos) { // posInicio
        while ((pos < MAXCOLUMNA) && (arr[pos] != 0)) {
            pos++;
        }
        return pos - 1;
    }

    public static int obtener_inicio_secuencia(int [ ] arr, int pos) { // posFin + 1
        while ((pos < MAXCOLUMNA) && (arr[pos] == 0)) {
            pos++;
        }
        return pos;
    }

    public static void buscar_secuencias_suma_mayor_matriz(int [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            System.out.println("Fila " + fila);
            buscar_secuencia_suma_mayor_arreglo(mat[fila]);
        }
    }

    public static void buscar_secuencia_suma_mayor_arreglo(int [] arr) {
        int suma;
        int inicio = 0;
        int fin = -1;
        int sumaMayor = 0;
        int sumaMayorInicio = 0;
        int sumaMayorFin = 0;
        while (inicio < MAXCOLUMNA) {
            inicio = obtener_inicio_secuencia(arr, fin + 1);
            if (inicio < MAXCOLUMNA) {
                fin = obtener_fin_secuencia(arr, inicio);
                suma = obtener_suma_secuencia(arr, inicio, fin);
                if (suma > sumaMayor) {
                    sumaMayor = suma;
                    sumaMayorInicio = inicio;
                    sumaMayorFin = fin;
                }
            }
        }
        System.out.println("La secuencia cuya suma de sus valores es mayor comienza en la posicion " + sumaMayorInicio + " y termina en la posición " + sumaMayorFin);
    }

    public static int obtener_suma_secuencia(int [ ] arr, int inicio, int fin) {
        int suma = 0;
        while (inicio <= fin) {
            suma += arr[inicio];
            inicio++;
        }
        return suma;
    }

    public static void buscar_anteultimas_secuencias_matriz(int [][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            System.out.println("Fila " + fila);
            buscar_anteultima_secuencia_arreglo(mat[fila]);
        }
    }

    public static void buscar_anteultima_secuencia_arreglo(int [] arr) {
        int fin = obtener_fin_secuencia(arr, MAXCOLUMNA - 1);
        int inicio = obtener_inicio_secuencia(arr, fin);
        fin = obtener_fin_secuencia(arr, inicio - 1);
        inicio = obtener_inicio_secuencia(arr, fin);
        System.out.println("La anteultima secuencia comienza en la posicion " + inicio + " y termina en la posición " + fin);
    }

    public static void eliminar_secuencias_tamanio_matriz(int [][] mat, int num) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            eliminar_secuencias_tamanio_arreglo(mat[fila], num);
        }
    }

    public static void eliminar_secuencias_tamanio_arreglo(int [ ] arr, int num) {
        int fin = -1;
        int inicio = obtener_inicio_secuencia(arr, fin + 1);
        while ((inicio < MAXCOLUMNA)) {
            fin = obtener_fin_secuencia(arr, inicio);
            if (num == (fin - inicio + 1)) {
                eliminar_secuencia(arr, inicio, fin);
                fin = inicio - 1;
            }
            inicio = obtener_inicio_secuencia(arr, fin + 1);
        }
    }

    public static void eliminar_secuencia(int [ ] arr, int inicio, int fin) {
        for(int i = inicio; i <= fin; i++) {
            corrimiento_izq(arr, inicio);
        }
    }

    // Estructura (falta implementar el método pedido) - Otra forma de hacerlo es con la usada en eliminar_secuencias_tamanio_arreglo
    public static void recorrer_secuencias(int [ ] arr) {
        int inicio = 0;
        int fin = -1;
        while (inicio < MAXCOLUMNA) { // Recorrido de cada secuencia
            inicio = obtener_inicio_secuencia(arr, fin + 1);
            if (inicio < MAXCOLUMNA)
                fin = obtener_fin_secuencia(arr, inicio);
            /*
            if (condicion) {
                llama otro método;
                fin = inicio;
            }
            */
        }
    }

    public static boolean son_iguales(int[] arr1, int[] arr2, int inicio1, int fin1,int inicio2,int fin2){
        while ((inicio1 < fin1) && (inicio2 < fin2) && (arr1[inicio1] == arr2[inicio2])){ // Va hasta la anteúltima posición porque en el siguiente if ya se paso
            inicio1++;
            inicio2++;
        }
        if ((inicio1 == fin1) && (inicio2 == fin2) && (arr1[inicio1] == arr2[inicio2])) {
            return true;
        } else {
            return false;
        }
    }

    public static void eliminar_secuencias_orden_descendente_matriz(int[][] mat) {
        for (int fila = 0; fila < MAXFILA; fila++) {
            eliminar_secuencias_orden_descendente_arreglo(mat[fila]);
        }
    }

    public static void eliminar_secuencias_orden_descendente_arreglo(int[] arr) {
        int fin = -1;
        int inicio = obtener_inicio_secuencia(arr, fin + 1);
        while (inicio < MAXCOLUMNA - 1) {
            fin = obtener_fin_secuencia(arr, inicio);
            if (es_descendente(arr, inicio, fin)) {
                eliminar_secuencia(arr, inicio, fin);
            }
            inicio = obtener_inicio_secuencia(arr, fin + 1);
        }
    }

    public static boolean es_descendente(int[] arr, int inicio, int fin) {
        for(int pos = inicio; pos <= fin; pos++) {
            if ((arr[pos] <= arr[pos + 1]) || (inicio == fin)){
                return false;
            }
        }
        return true;
    }

    public static void copiar_secuencias_tamanio_num(int [ ] arrInicial, int [ ] arrCopia, int num) {
        int tamanio;
        int inicio = 0;
        int fin = -1;
        int posCopia = 0;
        while (inicio < MAXCOLUMNA) {
            inicio = obtener_inicio_secuencia(arrInicial, fin + 1);
            if (inicio < MAXCOLUMNA) {
                fin = obtener_fin_secuencia(arrInicial, inicio);
                tamanio = fin - inicio + 1;
                if (num == tamanio) {
                    copiar_secuencia(arrInicial, arrCopia, inicio, fin, posCopia);
                    posCopia += tamanio;
                }
            }
        }
    }

    public static void copiar_secuencia(int [ ] arrInicial, int [ ] arrCopia, int inicio, int fin, int pos) {
        while (inicio <= fin) {
            arrCopia[pos] = arrInicial[inicio];
            inicio++;
            pos++;
        }
    }

    public static void inicializar_arreglo_int(int [] arr) {
        for (int pos = 0; pos < MAXCOLUMNA; pos++) {
            arr[pos] = -1;
        }
    }
}
