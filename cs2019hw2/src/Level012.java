/**
 * CSE3040 HW2
 * Level012.java
 * Purpose: Converts integer to binary format then prints it.
 *
 * @version 1.0 Nov. 4. 2019.
 * @author MJ Shin
 */

import java.util.Scanner;

/**
 * Interface for implementing IntSequenceStr.
 */
interface IntSequenceStr {
    /**
     * Checks if the sequence has next item.
     * @return true if sequence has next item, false if not.
     */
    boolean hasNext();

    /**
     * Next value in the sequence.
     * @return next value of the sequence.
     */
    int next();
}

/**
 * Class to implement binary sequences
 */
class BinarySequenceStr implements IntSequenceStr {
    String binStr;

    /**
     * return whether binStr is empty.
     */
    @Override
    public boolean hasNext() {
        return !this.binStr.isEmpty();
    }

    /**
     * returns character value at index 0, while removing the returned character
     * from sequence.
     */
    @Override
    public int next() {
        int digit = Character.getNumericValue(binStr.charAt(0));
        binStr = binStr.substring(1);
        return digit;
    }

    /**
     * Constructor
     * @param num The integer to convert as binary.
     */
    public BinarySequenceStr(Integer num) {
        // convert num as binary string.
        this.binStr = Integer.toBinaryString(num);
    }
}

/**
 * Main class
 */
public class Level012 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        String str = in.nextLine();
        int num = Integer.parseInt(str);
        in.close();
        System.out.println("Integer: " + num);
        IntSequenceStr seq = new BinarySequenceStr(num);
        System.out.print("Binary number: ");
        while(seq.hasNext())
            System.out.print(seq.next());
        System.out.println("");
    }
}
