package uvg.edu.gt;
import java.util.Arrays;
/**
 * Esta clase proporciona un método estático para ordenar un array de enteros utilizando el algoritmo RadixSort.
 * El RadixSort es un algoritmo de ordenamiento no comparativo que utiliza el método de distribución.
 */
public class RadixSort {

    /**
     * Encuentra el valor máximo en el array.
     *
     * @param arr El array de enteros.
     * @return El valor máximo en el array.
     */
    private static int getMax(int[] arr) {
        int mx = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    /**
     * Ordena el array utilizando el método de Counting Sort basado en un dígito específico.
     *
     * @param arr El array de enteros a ordenar.
     * @param exp El valor del dígito en el que se basa la clasificación actual.
     */
    private static void countSort(int[] arr, int exp) {
        int[] output = new int[arr.length];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Contar la frecuencia de cada dígito
        for (int value : arr) {
            count[(value / exp) % 10]++;
        }

        // Calcular las posiciones actuales de los dígitos
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construir el array de salida
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copiar el array de salida al array original
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    /**
     * Ordena un array de enteros utilizando el algoritmo RadixSort.
     *
     * @param arr El array de enteros a ordenar.
     */
    public static void sort(int[] arr) {
        int m = getMax(arr);

        // Aplicar Counting Sort para cada dígito, comenzando por el dígito menos significativo
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }
}