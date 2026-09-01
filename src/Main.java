import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        int algoSelect;
        int dataSelect;

        //Getting user input
        algoSelect = Helper.getValidChoice(myScanner,
                "Select Algorithm:\n[1]Insertion sort\n[2]Selection sort\nSelect: ", 1, 2);

        dataSelect = Helper.getValidChoice(myScanner,
                "\nSelect DataType input:\n[1]Integer\n[2]String\nSelect: ", 1, 2);

        //choosing logic
        if (dataSelect == 1){
            Integer[] numbersArray = new Integer[6];
            Helper.fillArray(myScanner, numbersArray, Scanner::nextInt);
            if(algoSelect == 1){
                Sorting.insertionSort(numbersArray);
            } else{
                Sorting.selectionSort(numbersArray);
            }
            System.out.println("Sorted elements: " + java.util.Arrays.toString(numbersArray));

        } else {
            String[] stringArray = new String[6];
            Helper.fillArray(myScanner, stringArray, Scanner::next);
            if (algoSelect == 1){
                Sorting.insertionSort(stringArray);
            } else{
                Sorting.selectionSort(stringArray);
            }
            System.out.println("Sorted elements: " + java.util.Arrays.toString(stringArray));

        }
    }
}
