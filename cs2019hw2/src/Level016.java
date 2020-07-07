/**
 * CSE3040 HW2
 * Level016.java
 * Purpose: Count number of occurrence of certain characters in a given file.
 *
 * @version 1.0 Nov. 4. 2019.
 * @author MJ Shin
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class for reading text from file, and count occurrences
 */
class Text {
    private String text = "";

    /**
     * Read string from given file
     * @param fileDir Directory of the file to read
     */
    public void readTextFromFile(String fileDir){
        // try-with-resources
        try(BufferedReader br = new BufferedReader(new FileReader(fileDir))) {
            String in;
            // read line from file, then concatenates it to instance variable
            while ((in = br.readLine()) != null) {
                this.text = this.text.concat(in);
            }
        } catch (IOException e) {
            System.out.println("Error: file does not exist.");
        }
    }

    /**
     * Count total occurrences of given character in text.
     * @param k Character to look for
     * @return Number of occurrences in int
     */
    public int countChar(char k) {
        // if we remove all occurrence of k from text, the text's length will
        // shrink by exactly the same number as the occurrences.
        return this.text.length() - this.text.replaceAll(Character.toString(k), "").length();
    }
}

/**
 * Main class
 */
public class Level016 {
    public static void main(String args[]) {
        Text t = new Text();
        t.readTextFromFile("input.txt");
        System.out.println("a: " + t.countChar('a'));
        System.out.println("b: " + t.countChar('b'));
        System.out.println("c: " + t.countChar('c'));
    }
}