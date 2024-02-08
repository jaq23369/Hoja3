package uvg.edu.gt;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int MAX_NUMBERS = 3000;
    private static final int ITERATIONS = 3000;

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

    private static void measureSortTime(String algorithmName, int[] numbersToSort) {
        long startTime = System.currentTimeMillis();

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
                System.out.println("Algoritmo desconocido: " + algorithmName);
                break;
        }

        long endTime = System.currentTimeMillis();
        System.out.println(algorithmName + " tomó: " + (endTime - startTime) + " ms para ordenar un array de " + numbersToSort.length + " números.");
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10000); // Genera números aleatorios entre 0 y 9999
        }
        return array;
    }
}
