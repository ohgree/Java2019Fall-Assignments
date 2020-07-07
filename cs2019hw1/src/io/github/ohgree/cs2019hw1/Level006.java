/**
 * CSE3040 HW1
 * Level006.java
 * Purpose: Simulating a Lotto with 6 pseudorandom numbers
 *
 * @version 1.0 26/9/2019
 * @author Minjun Shin
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Level006 {
    public static void main(String[] args) {
        Random random = new Random();
        Integer randNum;
        ArrayList<Integer> lottoNum = new ArrayList<Integer>();
        ArrayList<Integer> guess = new ArrayList<Integer>();
        while(lottoNum.size() < 6) {
            while(true) {
                randNum = random.nextInt(45) + 1;
                if(!lottoNum.contains(randNum))
                    break;
            }
            lottoNum.add(randNum);
        }
        /*
        for(int i=0 ; i<6 ; i++) {
            System.out.print(" " + lottoNum.get(i));
        }
        System.out.println();
        */
        Scanner scanner = new Scanner(System.in);
        while(guess.size() < 6) {
            System.out.print("[Lotto] Enter number #" + (guess.size()+1) + " (1-45): ");
            guess.add(scanner.nextInt());
        }
        scanner.close();

        System.out.print("This week's lotto numbers:");
        for(int i=0 ; i<6 ; i++) {
            System.out.print(" " + lottoNum.get(i));
        }
        System.out.println();

        lottoNum.retainAll(guess);
        System.out.println("You matched " + lottoNum.size() + " numbers.");
    }
}
