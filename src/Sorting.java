import java.util.*;
import java.util.function.*;

public class Sorting {
    //insertion sort
    public static <T extends Comparable<T>> void insertionSort(T[] array){
        insertionSort(array, true);
    }

    public static <T extends Comparable<T>> void insertionSort(T[] array, boolean ascending){
        for (int i =1; i < array.length ; i++){
            T key = array[i];
            int j = i - 1;

            while(j >= 0 && compare(array[j], key, ascending) > 0){
                array[j+1] = array[j];
                    j--;
                    Helper.printState(array, j + 1 , i);
            }
            array[j+1] = key;
            Helper.printState(array, j + 1, i);
        }
    }

    //selection sort
    public static <T extends Comparable<T>> void selectionSort(T[] array){
        selectionSort(array, true);
    }

    public static <T extends Comparable<T>> void selectionSort(T[] array, boolean ascending){
        for(int i = 0 ; i < array.length ; i ++){
            int min_idx = i;

            for (int j = i + 1 ; j < array.length ; j ++ ){
                Helper.printState(array, min_idx, j);
                if(compare(array[j], array[min_idx], ascending) < 0 ){
                    min_idx = j;
                }
            }

            //swaps the
            T temp = array[i];
            array[i] = array[min_idx];
            array[min_idx] = temp;

            Helper.printState(array, i , min_idx);
        }
    }

    //merge sort
    public static <T extends Comparable<T>> void mergeSort(T[] array){
        mergeSort(array, true);
    }

    public static <T extends Comparable<T>> void mergeSort(T[] array, boolean ascending){
        if (array.length < 2) {
            return;
        }

        mergeSort(array, 0, array.length - 1, ascending);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] array, int left, int right){
        mergeSort(array, left, right, true);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] array, int left, int right, boolean ascending){
        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;
        mergeSort(array, left, middle, ascending);
        mergeSort(array, middle + 1, right, ascending);
        merge(array, left, middle, right, ascending);
    }

    private static <T extends Comparable<T>> void merge(T[] array, int left, int middle, int right){
        merge(array, left, middle, right, true);
    }

    private static <T extends Comparable<T>> void merge(T[] array, int left, int middle, int right, boolean ascending){
        T[] merged = Arrays.copyOfRange(array, left, right + 1);
        int leftIndex = 0;
        int rightIndex = middle - left + 1;
        int outputIndex = left;

        while (leftIndex <= middle - left && rightIndex <= right - left) {
            if (compare(merged[leftIndex], merged[rightIndex], ascending) <= 0) {
                array[outputIndex] = merged[leftIndex++];
            } else {
                array[outputIndex] = merged[rightIndex++];
            }
            Helper.printState(array, outputIndex, outputIndex);
            outputIndex++;
        }

        while (leftIndex <= middle - left) {
            array[outputIndex] = merged[leftIndex++];
            Helper.printState(array, outputIndex, outputIndex);
            outputIndex++;
        }

        while (rightIndex <= right - left) {
            array[outputIndex] = merged[rightIndex++];
            Helper.printState(array, outputIndex, outputIndex);
            outputIndex++;
        }
    }

    //quick sort
    public static <T extends Comparable<T>> void quickSort(T[] array){
        quickSort(array, true);
    }

    public static <T extends Comparable<T>> void quickSort(T[] array, boolean ascending){
        quickSort(array, 0, array.length - 1, ascending);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high){
        quickSort(array, low, high, true);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, boolean ascending){
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(array, low, high, ascending);
        quickSort(array, low, pivotIndex - 1, ascending);
        quickSort(array, pivotIndex + 1, high, ascending);
    }

    private static <T extends Comparable<T>> int partition(T[] array, int low, int high){
        return partition(array, low, high, true);
    }

    private static <T extends Comparable<T>> int partition(T[] array, int low, int high, boolean ascending){
        T pivot = array[high];
        int smallerIndex = low;

        for (int currentIndex = low; currentIndex < high; currentIndex++) {
            Helper.printState(array, currentIndex, high);
            if (compare(array[currentIndex], pivot, ascending) <= 0) {
                swap(array, smallerIndex, currentIndex);
                Helper.printState(array, smallerIndex, currentIndex);
                smallerIndex++;
            }
        }

        swap(array, smallerIndex, high);
        Helper.printState(array, smallerIndex, high);
        return smallerIndex;
    }

    private static <T> void swap(T[] array, int first, int second){
        T temporary = array[first];
        array[first] = array[second];
        array[second] = temporary;
    }

    private static <T extends Comparable<T>> int compare(T first, T second, boolean ascending) {
        int result = first.compareTo(second);
        return ascending ? result : -result;
    }
}
