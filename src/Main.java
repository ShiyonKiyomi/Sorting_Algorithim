import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int algoSelect;
        int dataSelect;
        int orderSelect;
        boolean running = true;

        //Getting user input
        while (running) {
            printMenu();
            int selection = myScanner.nextInt();

            if (selection == 0) {
                running = false;
                continue;
            }

            algoSelect = Helper.getValidChoice(myScanner,
                    "Select Algorithm:\n[1]Insertion sort\n[2]Selection sort\n[3]Merge sort\n[4]Quick sort\nSelect: ", 1, 4);

            dataSelect = Helper.getValidChoice(myScanner,
                    "\nSelect DataType input:\n[1]Integer\n[2]String\n[3]Double\n[4]Character\nSelect: ", 1, 4);

            orderSelect = Helper.getValidChoice(myScanner,
                    "\nSelect Sorting Order:\n[1]Ascending\n[2]Descending\nSelect: ", 1, 2);
            boolean ascending = orderSelect == 1;

            //choosing logic
            if (dataSelect == 1) {
                Integer[] numbersArray = new Integer[6];
                Helper.fillArray(myScanner, numbersArray, Scanner::nextInt);
                sortAndPrint(numbersArray, algoSelect, ascending);
            } else if (dataSelect == 2) {
                String[] stringArray = new String[6];
                Helper.fillArray(myScanner, stringArray, Scanner::next);
                sortAndPrint(stringArray, algoSelect, ascending);
            } else if (dataSelect == 3) {
                Double[] decimalArray = new Double[6];
                Helper.fillArray(myScanner, decimalArray, Scanner::nextDouble);
                sortAndPrint(decimalArray, algoSelect, ascending);
            } else {
                Character[] characterArray = new Character[6];
                Helper.fillArray(myScanner, characterArray,
                        scanner -> scanner.next().charAt(0));
                sortAndPrint(characterArray, algoSelect, ascending);
            }

        }



        }


    private static <T extends Comparable<T>> void sortAndPrint(T[] array, int algoSelect, boolean ascending) {
        switch (algoSelect) {
            case 1 -> Sorting.insertionSort(array, ascending);
            case 2 -> Sorting.selectionSort(array, ascending);
            case 3 -> Sorting.mergeSort(array, ascending);
            case 4 -> Sorting.quickSort(array, ascending);
            default -> throw new IllegalArgumentException("Unknown sorting algorithm");
        }

        System.out.println((ascending ? "Sorted ascending: " : "Sorted descending: ") + Arrays.toString(array));
    }
    public static void println(String args) {
        System.out.print(args);
    }
    public static void printMenu(){
        println("""
                ---------- MENU --------------
                1. Select Algorithim
                0. Exit
                Selection: 
                """);
    }
}
