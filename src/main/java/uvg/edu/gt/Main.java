package uvg.edu.gt;

/**
 * Esta clase realiza mediciones de tiempo para varios algoritmos de ordenamiento,
 * como GnomeSort, MergeSort, QuickSort, RadixSort y HeapSort, sobre arrays de
 * diferentes tamaños y opciones de orden (ordenados o desordenados).
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // El número máximo de elementos en los arrays
    private static final int MAX_NUMBERS = 3000;

    // El número de iteraciones para realizar mediciones de tiempo
    private static final int ITERATIONS = 3000;

    /**
     * El punto de entrada principal del programa.
     *
     * @param args Los argumentos de la línea de comandos (no utilizados en este programa).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige una opción:\n1. Trabajar con arrays desordenados\n2. Trabajar con arrays ordenados");
        int option = scanner.nextInt();

        if (option != 1 && option != 2) {
            System.out.println("Entrada no válida. Terminando el programa.");
            return;
        }

        boolean arraysOrdenados = option == 2;

        try {
            for (int size = 10; size <= MAX_NUMBERS; size++) {
                int[] numbersToSort = generateRandomArray(size);
                if (arraysOrdenados) {
                    Arrays.sort(numbersToSort); // Ordena el array antes de pasar al algoritmo de sort si la opción es 2
                }

                System.out.println("Ordenando arrays de tamaño: " + size + (arraysOrdenados ? " (ordenados)" : " (desordenados)"));

                measureSortTime("GnomeSort", numbersToSort.clone());
                measureSortTime("MergeSort", numbersToSort.clone());
                measureSortTime("QuickSort", numbersToSort.clone());
                measureSortTime("RadixSort", numbersToSort.clone());
                measureSortTime("HeapSort", numbersToSort.clone());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Mide el tiempo que tarda un algoritmo de ordenamiento en ordenar un array de enteros
     * y muestra el resultado en milisegundos.
     *
     * @param algorithmName El nombre del algoritmo de ordenamiento a medir.
     * @param numbersToSort El array de números a ordenar.
     */
    private static void measureSortTime(String algorithmName, int[] numbersToSort) {
        long startTime = System.currentTimeMillis();

        switch (algorithmName) {
            case "GnomeSort":
                GnomeSort.sort(convertToInteger(numbersToSort));
                break;
            case "MergeSort":
                MergeSort.sort(convertToInteger(numbersToSort));
                break;
            case "QuickSort":
                QuickSort.sort(convertToInteger(numbersToSort));
                break;
            case "RadixSort":
                RadixSort.sort(numbersToSort);
                break;
            case "HeapSort":
                HeapSort.sort(convertToInteger(numbersToSort));
                break;
            default:
                System.out.println("Algoritmo desconocido: " + algorithmName);
                break;
        }

        long endTime = System.currentTimeMillis();
        System.out.println(algorithmName + " tomó: " + (endTime - startTime) + " ms para ordenar un array de " + numbersToSort.length + " números.");
    }

    /**
     * Convierte un array de enteros primitivos en un array de objetos Integer.
     *
     * @param arr El array de enteros primitivos a convertir.
     * @return El array de objetos Integer resultante.
     */
    private static Integer[] convertToInteger(int[] arr) {
        return Arrays.stream(arr)       // Convierte el int[] a un Stream<Integer>
                     .boxed()           // Convierte cada int en un Integer
                     .toArray(Integer[]::new); // Recolecta los resultados en un Integer[]
    }

    /**
     * Genera un array de números aleatorios de un tamaño dado.
     *
     * @param size El tamaño del array a generar.
     * @return El array de números aleatorios generado.
     */
    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000); // Genera números aleatorios entre 0 y 9999
        }
        return array;
    }
}
