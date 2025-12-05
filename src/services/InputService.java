package services;

import java.util.Scanner;

public class InputService {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
