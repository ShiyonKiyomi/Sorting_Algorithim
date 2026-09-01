import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);

        int algoSelect;
        int dataSelect;

        //Getting user input
        algoSelect = Helper.getValidChoice(myScanner,
                "Select Algorithm:\n[1]Insertion sort\n[2]Selection sort\n[3]Merge sort\n[4]Quick sort\nSelect: ", 1, 4);

        dataSelect = Helper.getValidChoice(myScanner,
                "\nSelect DataType input:\n[1]Integer\n[2]String\n[3]Double\n[4]Character\nSelect: ", 1, 4);

        //choosing logic
        if (dataSelect == 1) {
            Integer[] numbersArray = new Integer[6];
            Helper.fillArray(myScanner, numbersArray, Scanner::nextInt);
            sortAndPrint(numbersArray, algoSelect);
        } else if (dataSelect == 2) {
            String[] stringArray = new String[6];
            Helper.fillArray(myScanner, stringArray, Scanner::next);
            sortAndPrint(stringArray, algoSelect);
        } else if (dataSelect == 3) {
            Double[] decimalArray = new Double[6];
            Helper.fillArray(myScanner, decimalArray, Scanner::nextDouble);
            sortAndPrint(decimalArray, algoSelect);
        } else {
            Character[] characterArray = new Character[6];
            Helper.fillArray(myScanner, characterArray,
                    scanner -> scanner.next().charAt(0));
            sortAndPrint(characterArray, algoSelect);
        }
    }

    private static <T extends Comparable<T>> void sortAndPrint(T[] array, int algoSelect) {
        switch (algoSelect) {
            case 1 -> Sorting.insertionSort(array);
            case 2 -> Sorting.selectionSort(array);
            case 3 -> Sorting.mergeSort(array);
            case 4 -> Sorting.quickSort(array);
            default -> throw new IllegalArgumentException("Unknown sorting algorithm");
        }

        System.out.println("Sorted elements: " + Arrays.toString(array));
    }
}
