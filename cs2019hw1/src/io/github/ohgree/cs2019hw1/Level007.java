/**
 * CSE3040 HW1
 * Level007.java
 * Purpose: Find the number of occurrences of a letter in given string.
 *
 * @version 1.0 26/9/2019
 * @author Minjun Shin
 */

import java.util.Scanner;

public class Level007 {
    public static void main(String[] args) {
        String str, letter;
        Integer frequency;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        str = scanner.nextLine();
        System.out.print("Enter a letter: ");
        letter = scanner.nextLine();
        scanner.close();

        System.out.println("There are " + (str.length() - str.replace(letter, "").length()) +
                " " + letter + "'s in the text.");
    }
}
