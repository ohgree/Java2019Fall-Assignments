/**
 * CSE3040 HW1
 * Level008.java
 * Purpose: Count number of instances of a string in given text.
 *
 * @version 1.0 28/9/2019
 * @author Minjun Shin
 */

import java.util.Scanner;

public class Level008 {
    public static void main(String[] args) {
        String str, text;
        Integer frequency;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        text = scanner.nextLine();
        System.out.print("Enter a string: ");
        str = scanner.nextLine();
        scanner.close();

        System.out.println("I have found " + (text.length() - text.replace(str, "").length())/str.length() +
                " instances of \"" + str + "\".");
    }
}
