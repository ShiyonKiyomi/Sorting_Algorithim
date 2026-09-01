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
}
