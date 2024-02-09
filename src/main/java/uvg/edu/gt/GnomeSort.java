package uvg.edu.gt;

/**
 * Esta clase proporciona un método estático para ordenar un array utilizando el algoritmo GnomeSort.
 * El GnomeSort es un algoritmo de ordenamiento simple que funciona moviendo elementos hacia atrás en el
 * array hasta que el elemento actual sea mayor o igual que el anterior.
 */
public class GnomeSort {

    /**
     * Ordena un array utilizando el algoritmo GnomeSort.
     *
     * @param arr El array a ordenar.
     * @param <T> El tipo de elementos en el array, que deben ser comparables.
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (index == 0 || arr[index].compareTo(arr[index - 1]) >= 0) {
                index++;
            } else {
                // Intercambiar el elemento actual con el anterior
                T temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;

                // Retroceder el índice si es posible
                if (index > 1) {
                    index--;
                }
            }
        }
    }
}

