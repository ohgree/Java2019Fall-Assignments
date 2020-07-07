/**
 * CSE3040 HW1
 * Level005.java
 * Purpose: Repeats the program until user correctly guesses a random number.
 *
 * @version 1.0 24/9/2019
 * @author Minjun Shin
 */

import java.util.Random;
import java.util.Scanner;

public class Level005 {
    public static void main(String[] args) {
        Random random = new Random();
        Integer randomNum = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        Integer guess, low = 1, high = 100;
        Integer guessCount = 0;
        while (true) {
            guessCount++;
            System.out.print("[" + guessCount + "] Guess a number (" + low + "-" + high + "): ");
            guess = scanner.nextInt();
            if (guess.equals(randomNum)) {
                System.out.println("Correct!");
                break;
            } else if (randomNum.compareTo(guess) > 0) {
                System.out.println("Too small!");
                if(low < guess+1) low = guess+1;
            } else {
                System.out.println("Too large!");
                if(high > guess-1) high = guess-1;
            }
        }
        scanner.close();
    }
}
