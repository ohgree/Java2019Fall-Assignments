/**
 * CSE3040 HW1
 * Level009.java
 * Purpose: Show top 3 students based on their grades
 *
 * @version 1.0 28/9/2019
 * @author Minjun Shin
 */

import java.util.Scanner;

public class Level009 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] scores = new Integer[5];
        Integer[] index = {0, 1, 2, 3, 4};
        Integer temp;

        System.out.println("Please enter exam scores of each student.");
        for(int i=0 ; i<5 ; i++) {
            System.out.print("Score of student " + (i+1) + ": ");
            scores[i] = scanner.nextInt();
        }

        for(int i=0 ; i<5 ; i++) {
            for(int j=i+1 ; j<5 ; j++) {
                if(scores[i] < scores[j]) {
                    temp = scores[i];
                    scores[i] = scores[j];
                    scores[j] = temp;

                    temp = index[i];
                    index[i] = index[j];
                    index[j] = temp;
                }
            }
        }
        System.out.println("The 1st place is student " + (index[0]+1) + " with " + scores[0] + " points.");
        System.out.println("The 2nd place is student " + (index[1]+1) + " with " + scores[1] + " points.");
        System.out.println("The 3rd place is student " + (index[2]+1) + " with " + scores[2] + " points.");
    }
}
