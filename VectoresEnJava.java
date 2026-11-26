import java.util.Arrays;
import java.util.Scanner;

/**
 * Guía Práctica de Vectores (Arreglos Unidimensionales) en Java.
 * Incluye: Declaración, inicialización, acceso O(1), recorridos,
 * búsqueda lineal/binaria, ordenamiento y resolución de ejemplos.
 */
public class VectoresEnJava {

    public static void main(String[] args) {
        System.out.println("=== 1. DECLARACIÓN E INICIALIZACIÓN ===");
        // Forma 1: Declaración con tamaño fijo (valores por defecto en 0)
        int[] numeros = new int[5];
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;
        numeros[3] = 40;
        numeros[4] = 50;

        // Forma 2: Inicialización directa con valores
        int[] calificaciones = {85, 92, 78, 95, 88};

        System.out.println("Vector numeros: " + Arrays.toString(numeros));
        System.out.println("Vector calificaciones: " + Arrays.toString(calificaciones));
        System.out.println("Longitud del vector: " + calificaciones.length);

        System.out.println("\n=== 2. ACCESO Y MODIFICACIÓN O(1) ===");
        System.out.println("Primer elemento [0]: " + calificaciones[0]);
        System.out.println("Último elemento [length - 1]: " + calificaciones[calificaciones.length - 1]);
        calificaciones[2] = 82; // Modificación directa en tiempo constante O(1)
        System.out.println("Después de actualizar índice 2: " + Arrays.toString(calificaciones));

        System.out.println("\n=== 3. RECORRIDOS Y CÁLCULO DE ESTADÍSTICAS ===");
        int suma = 0;
        int mayor = calificaciones[0];
        int menor = calificaciones[0];

        // Bucle for tradicional (útil cuando se requiere el índice)
        for (int i = 0; i < calificaciones.length; i++) {
            suma += calificaciones[i];
            if (calificaciones[i] > mayor) mayor = calificaciones[i];
            if (calificaciones[i] < menor) menor = calificaciones[i];
        }

        double promedio = (double) suma / calificaciones.length;
        System.out.println("Suma total: " + suma);
        System.out.println("Promedio: " + promedio);
        System.out.println("Nota mayor: " + mayor + " | Nota menor: " + menor);

        System.out.println("\n=== 4. BÚSQUEDA LINEAL O(n) ===");
        int objetivo = 95;
        int posLineal = busquedaLineal(calificaciones, objetivo);
        System.out.println("Búsqueda lineal de " + objetivo + " -> Índice: " + posLineal);

        System.out.println("\n=== 5. ORDENAMIENTO O(n log n) Y BÚSQUEDA BINARIA O(log n) ===");
        // Ordenar el vector usando java.util.Arrays
        Arrays.sort(calificaciones);
        System.out.println("Vector ordenado: " + Arrays.toString(calificaciones));

        // La búsqueda binaria exige que el vector esté ordenado previamente
        int posBinaria = Arrays.binarySearch(calificaciones, 88);
        System.out.println("Búsqueda binaria de 88 -> Índice en vector ordenado: " + posBinaria);

        System.out.println("\n=== 6. REDIMENSIONAMIENTO MANUAL (COPIA A NUEVO VECTOR) ===");
        // Como un vector es estático, para agregar un elemento se crea uno más grande
        int[] ampliado = Arrays.copyOf(calificaciones, calificaciones.length + 1);
        ampliado[ampliado.length - 1] = 100;
        System.out.println("Vector ampliado: " + Arrays.toString(ampliado));
    }

    /**
     * Realiza una búsqueda secuencial sobre un vector.
     * Complejidad temporal: O(n)
     */
    public static int busquedaLineal(int[] vector, int valorBuscado) {
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == valorBuscado) {
                return i; // Retorna el índice donde se encontró
            }
        }
        return -1; // No encontrado
    }
}
