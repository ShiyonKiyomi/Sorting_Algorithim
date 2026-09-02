Sorting Algorithms Using Java Generics
Objective
Implement and demonstrate sorting algorithms through pseudocode, step-by-step execution, Java implementation using Generics, and real-world applications. The activity demonstrates how a generic sorting implementation can be used to sort different data types, including Integer and String values.

Part I – Sorting Algorithm Demonstration
Below are the sorting algorithms with their sample numbers, pseudocode, and step-by-step execution. These examples serve as references for understanding and writing the Java implementations.

1. Insertion Sort (Ascending Order)
Numbers: 56 23 45 12 5 10 3 89

Pseudocode:

text Treat the first number as sorted. Take the next number. Compare it with the numbers in the sorted part. Shift bigger numbers to the right. Insert the number in the correct position. Repeat until all numbers are sorted.

Step-by-step execution:

text Start: [56] 23 45 12 5 10 3 89 Insert 23: [23, 56] 45 12 5 10 3 89 Insert 45: [23, 45, 56] 12 5 10 3 89 Insert 12: [12, 23, 45, 56] 5 10 3 89 Insert 5: [5, 12, 23, 45, 56] 10 3 89 Insert 10: [5, 10, 12, 23, 45, 56] 3 89 Insert 3: [3, 5, 10, 12, 23, 45, 56] 89 Insert 89: [3, 5, 10, 12, 23, 45, 56, 89]

Final result (ascending): 3 5 10 12 23 45 56 89

2. Selection Sort (Ascending Order)
Numbers: 24 55 2 48 61 35 57

Pseudocode:

text Find the smallest number in the list. Swap it with the first number. Find the next smallest number from the remaining elements. Swap it with the second number. Continue until all elements are sorted.

Step-by-step execution:

text Start: 24 55 2 48 61 35 57 Smallest is 2 -> swap with 24: [2, 55, 24, 48, 61, 35, 57] Next is 24 -> swap with 55: [2, 24, 55, 48, 61, 35, 57] Next is 35 -> swap with 55: [2, 24, 35, 48, 61, 55, 57] Next is 48 -> stays: [2, 24, 35, 48, 61, 55, 57] Next is 55 -> swap with 61: [2, 24, 35, 48, 55, 61, 57] Next is 57 -> swap with 61: [2, 24, 35, 48, 55, 57, 61]

Final result (ascending): 2 24 35 48 55 57 61

3. Merge Sort (Ascending Order)
Numbers: 22 36 74 12 5 90 68 41

Pseudocode:

text Split the list into halves until only single elements remain. Merge pairs by comparing their elements and arranging them in order. Keep merging the sorted sections until one sorted list remains.

Step-by-step execution:

text Split: [22 36 74 12] and [5 90 68 41] Split again: [22 36] [74 12] and [5 90] [68 41] Split again: [22] [36] [74] [12] [5] [90] [68] [41] Merge 1: [22, 36] [12, 74] [5, 90] [41, 68] Merge 2: [12, 22, 36, 74] and [5, 41, 68, 90] Final merge: [5, 12, 22, 36, 41, 68, 74, 90]

Final result (ascending): 5 12 22 36 41 68 74 90

4. Quick Sort (Ascending Order)
Numbers: 102 28 55 9 43 15 84

Pseudocode:

text Choose a pivot, commonly the last element. Place smaller values on the left and larger values on the right. Repeat the process for the left and right sections until sorted.

Step-by-step execution:

text Start: 102 28 55 9 43 15 84 (pivot = 84) Partition using 84: [28, 55, 9, 43, 15], 84, [102] Sort [28, 55, 9, 43, 15] using pivot 15: [9], 15, [28, 55, 43] Sort [28, 55, 43] using pivot 43: [28], 43, [55] Combine all sections: [9, 15, 28, 43, 55, 84, 102]

Final result (ascending): 9 15 28 43 55 84 102

Java Program Task
Write a single Java program that uses Generics to implement the four sorting algorithms: Insertion Sort, Selection Sort, Merge Sort, and Quick Sort. The program should allow the user to choose whether to sort Integer or String values. After selecting the data type, the user enters the values to be sorted. The program should then allow the user to choose the sorting algorithm and sorting order, either ascending or descending. It should display the sorting process step by step and show the final sorted list. Animation may be used to make the sorting process more interactive and easier to understand. At least one useful original feature should also be added to improve the program's functionality.

Java Implementation and Class Logic
The Main class is the entry point and controls the overall flow of the application. It creates a Scanner, asks the user to select one of the four algorithms, asks for a data type, creates an array of six values, and passes that array to the appropriate sorting method. Its generic sortAndPrint method uses a switch statement to select the algorithm and then prints the final result. Although the activity specifically requires Integer and String, the implementation extends the data-type menu to support Double and Character values as an additional feature. The current version performs the four algorithms in ascending order; descending-order selection remains a possible future extension.

The Sorting class contains the four generic sorting implementations. Insertion Sort grows a sorted section by shifting larger values right before inserting the current key. Selection Sort repeatedly finds the smallest remaining value and swaps it into the next sorted position. Merge Sort recursively divides the array and combines its sections using an ordered temporary copy. Quick Sort uses the last value as its pivot, partitions smaller or equal values to the left, places the pivot in its final location, and recursively processes both remaining sections. Every public method uses <T extends Comparable<T>>, allowing the same code to compare and sort different object types through compareTo instead of using integer-only comparison operators.

The Helper class groups reusable support operations that do not belong inside the sorting algorithms. The getValidChoice method validates menu input and keeps asking until the user enters an allowed number. The generic fillArray method accepts a Function<Scanner, T>, allowing one input routine to read integers, strings, doubles, or characters. The clearScreen and printState methods create the visual animation: the console is refreshed, active array positions are enclosed in brackets, and a short delay lets the user observe each comparison or movement.

Compared with a traditional sorting program, which often places one integer-only algorithm directly inside main, this implementation separates user interaction, sorting logic, and reusable utilities into Main, Sorting, and Helper. It combines four algorithms in one menu-driven program, uses Generics for multiple comparable data types, validates menu choices, avoids repeated code through shared methods, and visualizes intermediate sorting states. The added support for Double and Character values goes beyond the required Integer and String types and is the program's additional useful feature.

Part II – Reflection Questions
1. How does Insertion Sort work, and how is it different from Selection Sort?
Insertion Sort treats the beginning of the array as a sorted section. It takes the next value, shifts every larger value one position to the right, and inserts the selected value into its proper location. Selection Sort instead searches the entire unsorted section for the smallest value and swaps it with the value at the current position. Therefore, Insertion Sort builds the result through insertion and shifting, while Selection Sort builds it through repeated searching and swapping. Insertion Sort can perform well on small or nearly sorted data because fewer shifts may be required, whereas Selection Sort continues scanning the remaining elements even when the array is already close to sorted.

2. What is the main difference between Merge Sort and Quick Sort?
Merge Sort divides the array into equal halves, recursively sorts both halves, and combines them using a separate merging process. It normally requires additional memory for temporary arrays and consistently runs in O(n log n) time. Quick Sort selects a pivot, partitions the values around that pivot, and recursively sorts the resulting sections. It generally sorts in place and is often fast in practice, but its performance depends on pivot selection; poor partitions can lead to a worst-case running time of O(n²). The main difference is therefore that Merge Sort organizes data during merging, while Quick Sort organizes data during partitioning.

3. Why is Java Generics useful in this activity when sorting both Integer and String values?
Java Generics makes it possible to write each sorting algorithm once and reuse it for different types. The type parameter <T extends Comparable<T>> guarantees that every value provides a compareTo method, so integers can be compared numerically and strings can be compared alphabetically through the same algorithm. Without Generics, separate and mostly duplicated methods would be needed for Integer, String, and every additional data type. Generics therefore improve code reuse, type safety, readability, and maintainability.

4. Which sorting algorithm was easiest or most difficult to understand or implement? Explain your answer.
Selection Sort was the easiest to understand because its process is direct: find the smallest remaining element and move it to the next position. Merge Sort was the most difficult to implement because it requires several connected operations, including recursive splitting, calculating array boundaries, maintaining temporary storage, comparing values from two sections, and copying all remaining values back into the original array. A small boundary error in the merge operation can lose, duplicate, or incorrectly arrange an element, so it requires more careful index management than Selection Sort.

5. Give three real-life applications where sorting algorithms can be used. For each application, identify the sorting algorithm you would use and explain why it is appropriate.
An online store can use Merge Sort to arrange a large product catalog by price, name, or rating. Merge Sort has predictable O(n log n) performance, works well with large collections, and is stable, which helps preserve the previous order of products with equal values. It is also suitable when records are processed in sections or come from external storage.

A leaderboard or frequently updated list of student grades can use Insertion Sort when only a small number of new records are added at a time. Because most of the list is already sorted, each new value can be inserted into its proper position without sorting the entire collection again. This makes Insertion Sort practical for small, nearly sorted datasets.

A large in-memory list of search results can use Quick Sort to arrange records by relevance score or date. Quick Sort usually has good average performance, uses little additional memory because partitioning can be performed in place, and is effective when fast in-memory processing is important. A suitable pivot-selection strategy helps keep the partitions balanced and reduces the chance of worst-case behavior.

Conclusion
This activity demonstrates how four sorting algorithms solve the same ordering problem through different strategies. Insertion Sort inserts values into a growing sorted section, Selection Sort repeatedly selects the smallest remaining value, Merge Sort divides and combines, and Quick Sort partitions around pivots. Java Generics allows all four implementations to work safely with several comparable data types, while the separate Main, Sorting, and Helper classes keep the program organized. Input validation, reusable data-entry logic, extra data types, and animated intermediate states make the implementation more functional and educational than a traditional single-algorithm example.
Video Presentation

https://github.com/user-attachments/assets/8493c151-08cc-4fba-a626-ced785833d53


