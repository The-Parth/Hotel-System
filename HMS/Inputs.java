package HMS;

import java.util.Scanner;

public class Inputs {
    public static int getInt(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        String input = sc.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
            return getInt(prompt);
        }
    }

    public static String getString(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static double getDouble(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        String input = sc.nextLine();
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input!");
            return getDouble(prompt);
        }
    }
}
