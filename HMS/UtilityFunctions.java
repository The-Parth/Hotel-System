package HMS;

import java.util.Vector;
import java.util.Scanner;

public class UtilityFunctions {
    public static void sortVector(Vector<Object> vector, SortByFunction sortByFunction) {
        int n = vector.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                Float value1 = sortByFunction.sortBy(vector.get(j));
                Float value2 = sortByFunction.sortBy(vector.get(j + 1));

                if (value1 > value2) {
                    // Swap the elements
                    Object temp = vector.get(j);
                    vector.set(j, vector.get(j + 1));
                    vector.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void sortVector(Vector<Object> vector, SortByFunction sortByFunction, boolean reverse) {
        sortVector(vector, sortByFunction);
        if (reverse) {
            java.util.Collections.reverse(vector);
        }
    }

    public static void cls() {
        final String os = System.getProperty("os.name");  
        try {
            ProcessBuilder pb = new ProcessBuilder();
            if (os.contains("Windows")) {
                pb.command("cmd", "/c", "cls");
            } else {
                pb.command("clear");
            }
            pb.inheritIO().start().waitFor();
        } catch (final Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void waitForEnter() {
        System.out.println("Press enter to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    
}