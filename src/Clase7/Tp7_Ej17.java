/*
Para el Ejemplo 9, hacer:
– c) cargar los índices de los valores pares de DESORDENADO en un arreglo PARES de
tamaño MAX sin importar el orden.
– d) ordenar PARES de forma descendente según los valores pares de DESORDENADO utilizando un
método de ordenamiento.
 */

package Clase7;

public class Tp7_Ej17 {
    public static int MINVALOR = 1;
    public static int MAXVALOR = 10;
    public static int MAX = 10;
    public static void main (String [] args) {
        int[] desordenado = new int[MAX];
        int[] pares = new int[MAX];
        cargar_arreglo_aleatorio(desordenado);
        System.out.println("Arreglo DESORDENADO:");
        imprimir_arreglo(desordenado);
        inicializar_arreglo(pares);
        cargar_arreglo_indices_pares(desordenado,pares);
        System.out.println("Arreglo con índices de valores pares");
        imprimir_arreglo(pares);
        ordenarArregloPares(desordenado,pares);
        System.out.println("Areglo con índices pares ORDENADO según valores de DESORDENADO");
        imprimir_arreglo(pares);
    }

    public static void cargar_arreglo_aleatorio(int [] arr){
        for (int pos = 0; pos < MAX; pos++){
            arr[pos]=(int)((MAXVALOR-MINVALOR)*Math.random() + MINVALOR);
        }
    }

    public static void imprimir_arreglo(int [] arr){
        for (int pos = 0; pos < MAX; pos++){
            System.out.print("|"+arr[pos]);
        }
        System.out.println("|");
    }

    public static void inicializar_arreglo(int [] arr){
        for (int pos = 0; pos < MAX; pos++){
            arr[pos] = -1;
        }
    }

    public static void cargar_arreglo_indices_pares(int[] original,int[] arrindices){
        int i = 0;
        for (int pos = 0; pos < MAX; pos++){
            if ((original[pos]%2) == 0){
                arrindices[i] = pos;
                i++;
            }
        }
    }

    public static void ordenarArregloPares(int [] desordenado, int [] pares) {
        int posMenor, aux;
        int maxPares = obtenerMaxArregloPares(pares);
        for (int i = 0; i <= MAX - 1; i++) {
            posMenor = i;
            for (int j = i + 1; j <= maxPares; j++) {
                if (desordenado[pares[j]] > desordenado[pares[posMenor]]) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                aux = pares[i];
                pares[i] = pares[posMenor];
                pares[posMenor] = aux;
            }
        }
    }

    public static int obtenerMaxArregloPares(int [] pares) {
        int pos = 0;
        while (pares[pos] != (-1)) {
            pos++;
        }
        int maxPares = pos - 1;
        return maxPares;
    }
}