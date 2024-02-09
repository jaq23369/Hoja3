package uvg.edu.gt;

/**
 * Esta clase proporciona un método estático para ordenar un array utilizando el algoritmo QuickSort.
 * El QuickSort es un algoritmo de ordenamiento eficiente basado en la técnica divide y conquista.
 */
public class QuickSort {

    /**
     * Ordena un array utilizando el algoritmo QuickSort.
     *
     * @param arr El array a ordenar.
     * @param <T> El tipo de elementos en el array, que deben ser comparables.
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * Método privado utilizado para realizar la ordenación rápida recursiva.
     *
     * @param arr  El array a ordenar.
     * @param low  El índice más bajo del subarray a ordenar.
     * @param high El índice más alto del subarray a ordenar.
     * @param <T>  El tipo de elementos en el array, que deben ser comparables.
     */
    private static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    /**
     * Método privado utilizado para realizar la partición del array.
     *
     * @param arr  El array a particionar.
     * @param low  El índice más bajo del subarray a particionar.
     * @param high El índice más alto del subarray a particionar.
     * @param <T>  El tipo de elementos en el array, que deben ser comparables.
     * @return El índice de la posición final del pivote después de la partición.
     */
    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                // Intercambiar arr[i] y arr[j]
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Intercambiar arr[i+1] y arr[high] (o el pivote)
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}

