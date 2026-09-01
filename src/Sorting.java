import java.util.*;
import java.util.function.*;

public class Sorting {
    //insertion sort
    public static <T extends Comparable<T>> void insertionSort(T[] array){
        for (int i =1; i < array.length ; i++){
            T key = array[i];
            int j = i - 1;

            while(j >= 0 && array[j].compareTo(key) > 0){
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
        for(int i = 0 ; i < array.length ; i ++){
            int min_idx = i;

            for (int j = i + 1 ; j < array.length ; j ++ ){
                Helper.printState(array, min_idx, j);
                if(array[j].compareTo(array[min_idx]) < 0 ){
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
        if (array.length < 2) {
            return;
        }

        mergeSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] array, int left, int right){
        if (left >= right) {
            return;
        }

        int middle = left + (right - left) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        merge(array, left, middle, right);
    }

    private static <T extends Comparable<T>> void merge(T[] array, int left, int middle, int right){
        T[] merged = Arrays.copyOfRange(array, left, right + 1);
        int leftIndex = 0;
        int rightIndex = middle - left + 1;
        int outputIndex = left;

        while (leftIndex <= middle - left && rightIndex <= right - left) {
            if (merged[leftIndex].compareTo(merged[rightIndex]) <= 0) {
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
        quickSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int low, int high){
        if (low >= high) {
            return;
        }

        int pivotIndex = partition(array, low, high);
        quickSort(array, low, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, high);
    }

    private static <T extends Comparable<T>> int partition(T[] array, int low, int high){
        T pivot = array[high];
        int smallerIndex = low;

        for (int currentIndex = low; currentIndex < high; currentIndex++) {
            Helper.printState(array, currentIndex, high);
            if (array[currentIndex].compareTo(pivot) <= 0) {
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
}
