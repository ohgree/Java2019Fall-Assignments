/**
 * CSE3040 HW1
 * Level004.java
 * Purpose: Convert an ASCII letter to an ASCII code value.
 *
 * @version 1.0 24/9/2019
 * @author Minjun Shin
 */

import java.util.Scanner;

public class Level004 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        System.out.print("ASCII code teller. Enter a letter: ");
        str = scanner.nextLine();
        scanner.close();
        System.out.println("The ASCII code of " + str.charAt(0) + " is " + (int)(str.charAt(0)) + ".");
    }
}
