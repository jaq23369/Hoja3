package uvg.edu.gt;

import java.util.Random;
import java.util.Scanner; // Importa la clase Scanner

public class Main {

    private static final int MAX_NUMBERS = 3000;
    private static final int ITERATIONS = 3000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crea una instancia de Scanner
        System.out.println("Presiona '1' y luego Enter para comenzar:");
        int input = scanner.nextInt(); // Espera la entrada del usuario
        if (input != 1) {
            System.out.println("Entrada no válida. Terminando el programa.");
            return; // Termina si la entrada no es 1
        }

        try {
            for (int size = 10; size <= MAX_NUMBERS; size += 1) {
                System.out.println("Ordenando arrays de tamaño: " + size);

                int[] numbersToSort = generateRandomArray(size);
                System.out.println("GnomeSort va a comenzar.");
                measureSortTime("GnomeSort", numbersToSort);
                System.out.println("GnomeSort ha terminado.");

                numbersToSort = generateRandomArray(size);
                System.out.println("MergeSort va a comenzar.");
                measureSortTime("MergeSort", numbersToSort);
                System.out.println("MergeSort ha terminado.");

                // Continúa para QuickSort, RadixSort y HeapSort...
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void measureSortTime(String algorithmName, int[] numbersToSort) {
        long startTime = System.currentTimeMillis();

        try {
            switch (algorithmName) {
                case "GnomeSort":
                    GnomeSort.sort(numbersToSort);
                    break;
                case "MergeSort":
                    MergeSort.sort(numbersToSort);
                    break;
                case "QuickSort":
                    QuickSort.sort(numbersToSort);
                    break;
                case "RadixSort":
                    RadixSort.sort(numbersToSort);
                    break;
                case "HeapSort":
                    HeapSort.sort(numbersToSort);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown algorithm: " + algorithmName);
            }
        } catch (Exception e) {
            System.out.println("Una excepción ha ocurrido en " + algorithmName);
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println(algorithmName + " tomó: " + (endTime - startTime) + " ms para ordenar un array de " + numbersToSort.length + " números.");
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000);
        }
        return array;
    }
}
