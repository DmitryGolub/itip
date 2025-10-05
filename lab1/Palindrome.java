import java.util.Scanner;


public class Palindrome {
    public static String reverseString(String sourceString) {
        String reversedString = "";
        int lenString = sourceString.length();

        for (int i = lenString - 1; i >= 0; i-- ) {
            reversedString += sourceString.charAt(i);
        }

        return reversedString;
    }

    public static boolean isPalindrome(String string) {
        boolean result = string.equals(reverseString(string));
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        System.out.printf("%s \n", (isPalindrome(string)) ? "Строка является палиндромом": "Строка не является палиндромом");
    }
}