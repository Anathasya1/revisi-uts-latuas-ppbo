package util;

import java.util.Scanner;

public class CLIUtil {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int getInt() {
        return scanner.nextInt();
    }

    public static String getString() {
        return scanner.nextLine();
    }

    public static int askForInt(String message) {
        System.out.println(message);
        return scanner.nextInt();
    }

    public static String askForString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
