package uvg.edu.gt;

import java.lang.reflect.Array;

/**
 * Esta clase proporciona un método estático para ordenar un array utilizando el algoritmo MergeSort.
 * El MergeSort es un algoritmo de ordenamiento eficiente basado en la técnica divide y conquista.
 */
public class MergeSort {

    /**
     * Ordena un array utilizando el algoritmo MergeSort.
     *
     * @param arr El array a ordenar.
     * @param <T> El tipo de elementos en el array, que deben ser comparables.
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * Método privado utilizado para realizar la división y la mezcla recursiva de los subarrays.
     *
     * @param arr    El array a ordenar.
     * @param left   El índice izquierdo del subarray.
     * @param right  El índice derecho del subarray.
     * @param <T>    El tipo de elementos en el array, que deben ser comparables.
     */
    private static <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }
    
    /**
     * Método privado utilizado para mezclar dos subarrays ordenados en un solo array ordenado.
     *
     * @param arr     El array original.
     * @param left    El índice izquierdo del primer subarray.
     * @param middle  El índice derecho del primer subarray y el índice izquierdo del segundo subarray.
     * @param right   El índice derecho del segundo subarray.
     * @param <T>     El tipo de elementos en el array, que deben ser comparables.
     */
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(T[] arr, int left, int middle, int right) {
        T[] leftTemp = (T[]) Array.newInstance(arr.getClass().getComponentType(), middle - left + 1);
        T[] rightTemp = (T[]) Array.newInstance(arr.getClass().getComponentType(), right - middle);

        // Copiar datos a los arrays temporales
        System.arraycopy(arr, left, leftTemp, 0, leftTemp.length);
        System.arraycopy(arr, middle + 1, rightTemp, 0, rightTemp.length);

        // Índices para recorrer los arrays temporales
        int leftIndex = 0, rightIndex = 0;
        // Índice para recorrer el array original
        int currentIndex = left;
        // Mezcla los elementos de los arrays temporales en el array original
        while (leftIndex < leftTemp.length && rightIndex < rightTemp.length) {
            if (leftTemp[leftIndex].compareTo(rightTemp[rightIndex]) <= 0) {
                arr[currentIndex++] = leftTemp[leftIndex++];
            } else {
                arr[currentIndex++] = rightTemp[rightIndex++];
            }
        }

        // Copia los elementos restantes del array temporal izquierdo, si los hay
        while (leftIndex < leftTemp.length) {
            arr[currentIndex++] = leftTemp[leftIndex++];
        }

        // Copia los elementos restantes del array temporal derecho, si los hay
        while (rightIndex < rightTemp.length) {
            arr[currentIndex++] = rightTemp[rightIndex++];
        }
    }
}


