package Assignment02;

import java.util.Scanner;

public class LibraryISBNValidator {

    static String normalizeCode(String raw) {

        String code = raw.trim();

        if (code.length() >= 3) {

            String publisher = code.substring(0, 3);
            String remaining = code.substring(3);

            publisher = publisher.toUpperCase();

            code = publisher + remaining;
        }

        return code;
    }

    static String validateAndFormat(String code) {

        // Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters
        for (int i = 3; i < 13; i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        // Extract parts
        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        // Create formatted output
        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(publisher);
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN code: ");
        String raw = sc.nextLine();

        String code = normalizeCode(raw);

        String result = validateAndFormat(code);

        System.out.println(result);

        sc.close();
    }
}