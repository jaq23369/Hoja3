package uvg.edu.gt;

import java.lang.reflect.Array;

public class MergeSort {

    public static <T extends Comparable<T>> void sort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }
    
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(T[] arr, int left, int middle, int right) {
        T[] leftTemp = (T[]) Array.newInstance(arr.getClass().getComponentType(), middle - left + 1);
        T[] rightTemp = (T[]) Array.newInstance(arr.getClass().getComponentType(), right - middle);

        System.arraycopy(arr, left, leftTemp, 0, leftTemp.length);
        System.arraycopy(arr, middle + 1, rightTemp, 0, rightTemp.length);

        int leftIndex = 0, rightIndex = 0;
        int currentIndex = left;
        while (leftIndex < leftTemp.length && rightIndex < rightTemp.length) {
            if (leftTemp[leftIndex].compareTo(rightTemp[rightIndex]) <= 0) {
                arr[currentIndex++] = leftTemp[leftIndex++];
            } else {
                arr[currentIndex++] = rightTemp[rightIndex++];
            }
        }

        while (leftIndex < leftTemp.length) {
            arr[currentIndex++] = leftTemp[leftIndex++];
        }

        while (rightIndex < rightTemp.length) {
            arr[currentIndex++] = rightTemp[rightIndex++];
        }
    }
}


