package uvg.edu.gt;

/**
 * Esta clase proporciona un método estático para ordenar un array utilizando el algoritmo HeapSort.
 * El HeapSort es un algoritmo de ordenamiento eficiente basado en la estructura de datos heap.
 */
public class HeapSort {

    /**
     * Ordena un array utilizando el algoritmo HeapSort.
     *
     * @param arr El array a ordenar.
     * @param <T> El tipo de elementos en el array, que deben ser comparables.
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        int n = arr.length;

        // Construir el heap (reorganizar el array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Extraer elementos uno por uno del heap
        for (int i = n - 1; i >= 0; i--) {
            // Mover la raíz actual al final
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Llamar a la función heapify en el heap reducido
            heapify(arr, i, 0);
        }
    }

    /**
     * Método privado utilizado para reorganizar un subárbol en un heap enraizado con el nodo i.
     *
     * @param arr El array que contiene el heap.
     * @param n   El tamaño del heap.
     * @param i   El índice del nodo raíz del subárbol a heapificar.
     * @param <T> El tipo de elementos en el array, que deben ser comparables.
     */
    private static <T extends Comparable<T>> void heapify(T[] arr, int n, int i) {
        int largest = i; // Inicializar largest como raíz
        int l = 2 * i + 1; // izquierda = 2i + 1
        int r = 2 * i + 2; // derecha = 2*i + 2

        // Si el hijo izquierdo es más grande que la raíz
        if (l < n && arr[l].compareTo(arr[largest]) > 0)
            largest = l;

        // Si el hijo derecho es más grande que largest hasta ahora
        if (r < n && arr[r].compareTo(arr[largest]) > 0)
            largest = r;

        // Si largest no es raíz
        if (largest != i) {
            // Intercambiar el nodo raíz con el nodo más grande
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Heapify recursivamente el subárbol afectado
            heapify(arr, n, largest);
        }
    }
}

