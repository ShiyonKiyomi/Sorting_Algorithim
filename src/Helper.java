import java.util.*;
import java.util.function.*;

public class Helper {
    public static int getValidChoice(Scanner scanner, String prompt, int min, int max) {
        int choice;
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } else {
                scanner.next(); // discard invalid non-integer token
            }
            System.out.println("Invalid input. Please try again");
        }
    }

    public static <T> void fillArray(Scanner scanner, T[] array, Function<Scanner, T> reader){
        for(int i = 0 ; i < array.length ; i++){
            System.out.print("Enter Element: " + (i + 1) +": ");
            array[i] = reader.apply(scanner);
        }
    }

}
