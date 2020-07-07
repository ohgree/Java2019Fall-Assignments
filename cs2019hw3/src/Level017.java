/**
 * CSE3040 HW3
 * Level017.java
 * Purpose: Gets information from file, then prints number of elements, average,
 *          maximum and minimum data.
 *
 * @version 1.0 Nov. 29. 2019.
 * @author MJ Shin
 */
import java.io.*;
import java.util.HashMap;

/**
 * Main class
 */
public class Level017 {
    public static void main(String[] args) {
        HashMap<String, Double> data = new HashMap<>();
        String temp, name, max = "", min = "";
        Double value, avg = 0.0, maxV = Double.MIN_VALUE, minV = Double.MAX_VALUE;

        /* read data from file */
        try (BufferedReader fr = new BufferedReader(new FileReader("input.txt"))) {
            while ((temp = fr.readLine()) != null) {
                /* split data into two segments containing name and price */
                name = temp.split(" ")[0];
                value = Double.parseDouble(temp.split(" ")[1]);

                /* map processed values into data */
                data.put(name, value);
            }
        } catch (IOException e) {
            System.out.println("Input file not found!");
            return;
        }

        /* search for max, min priced item, and calculate average price */
        for (String k : data.keySet()) {
            value = data.get(k);
            if(value < minV) {
                minV = value;
                min = k;
            }
            if(value > maxV) {
                maxV = value;
                max = k;
            }
            avg += value;
        }
        avg /= data.size();

        try(PrintWriter pw = new PrintWriter("result_input.txt")) {
            pw.println("Summary");
            pw.println("-------");
            pw.println("number of items: " + data.size());
            pw.println("most expensive item: " + max + " (" + maxV + ")");
            pw.println("cheapest item: " + min + " (" + minV + ")");
            pw.println("average price of items: " + avg);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
