package uvg.edu.gt;

public class GnomeSort {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (index == 0 || arr[index].compareTo(arr[index - 1]) >= 0) {
                index++;
            } else {
                T temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                if (index > 1) {
                    index--;
                }
            }
        }
    }
}

