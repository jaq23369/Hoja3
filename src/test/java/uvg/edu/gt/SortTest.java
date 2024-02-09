package uvg.edu.gt;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SortTest {

    @Test
    public void testQuickSort() {
        Integer[] array = {4, 3, 2, 1};
        QuickSort.sort(array);
        assertTrue(isSorted(array));
    }

    @Test
    public void testGnomeSort() {
        Integer[] array = {10, 3, 2, 40, 1};
        GnomeSort.sort(array);
        assertTrue(isSorted(array));
    }

    @Test
    public void testMergeSort() {
        Integer[] array = {3, 6, 45, 12, 1, -2};
        MergeSort.sort(array);
        assertTrue(isSorted(array));
    }
    
    @Test
    public void testHeapSort() {
        Integer[] array = {20, 3, 50, 1, 4, 7, 9};
        HeapSort.sort(array);
        assertTrue(isSorted(array));
    }

    // Método auxiliar para verificar si un arreglo está ordenado
    private boolean isSorted(Comparable[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].compareTo(array[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }
    
}    
    