/**
 * CSE3040 HW3
 * Level020.java
 * Purpose: Read data from file, then sorts the data, first by price, then by
 *          name in alphabetical order. Uses Map class
 *
 * @version 1.0 Nov. 29. 2019.
 * @author MJ Shin
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Custom Map class for implementing custom toString() method
 */
class NMap extends HashMap<String, Double> {
    /**
     * Constructor for class NMap.
     */
    public NMap() {
        super();
    }

    /**
     * Get contents of this instance, sorted by value first, then by key in alphabetical. Increasing order.
     * @return String representation of contents, in sorted increasing order
     */
    @Override
    public String toString() {
        String str = "";
        Entry<String, Double> e1, e2;

        /* convert mappings to list, since HashMap is unordered */
        ArrayList<Entry<String, Double>> list = new ArrayList<Entry<String, Double>>(this.entrySet());

        /* sorting entries */
        for(int i=0 ; i<list.size() ; i++) {
            for(int j=i+1 ; j<list.size() ; j++) {
                e1 = list.get(i);
                e2 = list.get(j);

                /* compare values first, then compare keys if values are identical */
                if(e1.getValue() > e2.getValue()) {
                    Collections.swap(list, i, j);
                } else if(e1.getValue().equals(e2.getValue())) {
                    if(e1.getKey().compareTo(e2.getKey()) > 0) {
                        Collections.swap(list, i, j);
                    }
                }
            }
        }

        /* creating string representation from sorted list */
        for(Entry<String, Double> e: list) {
            str += e.getKey() + " " + e.getValue() + System.lineSeparator();
        }
        return str;
    }
}

/**
 * Main class
 */
public class Level020 {
    /**
     * Read data from given input file
     *
     * @param  fileName String instance containing input file directory
     * @param  list     List of Element to write data to.
     * @return 0 if whole read was successful, 1 if there was an error.
     */
    private static int readDataFromFile(String fileName, Map<String, Double> map) {
        String buffer, name;
        Double value;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((buffer = br.readLine()) != null) {
                /* read data from line read */
                name = buffer.split(" ")[0];
                value = Double.parseDouble(buffer.split(" ")[1]);

                /* save read data */
                map.put(name, value);
            }
        } catch (IOException e) {
            return 1; // error code
        }
        return 0; // successful read
    }

    /**
     * Gets new initialised map with String, Double type as key pairs.
     * @return An empty HashMap instance with type params String and Double.
     */
    private static Map<String, Double> InitializeMap() {
        return new NMap();
    }

    public static void main(String[] args) throws Exception {
        Map<String, Double> map = InitializeMap();
        int rv = readDataFromFile("./input.txt", map);
        if (rv == 1) {
            System.out.println("input file not found!");
            return;
        }
        System.out.println(map);
    }
}