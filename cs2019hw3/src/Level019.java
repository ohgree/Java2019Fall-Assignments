/**
 * CSE3040 HW3
 * Level019.java
 * Purpose: Read data from file, then sorts the data by name,
 *          in alphabetical order.
 *
 * @version 1.0 Nov. 29. 2019.
 * @author MJ Shin
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Class inheriting TreeMap, to use custom toString() method.
 * @param <K> Parameterised type for Key
 * @param <V> Parameterised type for Value
 */
class WorldMap<K, V> extends TreeMap<K, V> {
    /**
     * Constructor for WorldMap class.
     * does not do anything but call superclass constructor
     */
    public WorldMap() {
        super();
    }

    /**
     * Get string representation of this instance's contents, sorted by keys
     * @return String of sorted contents
     */
    @Override
    public String toString() {
        String str = "";
        for(Map.Entry<K, V> entry : this.entrySet()) {
            str += entry.getKey().toString() + " " + entry.getValue().toString() + System.lineSeparator();
        }
        return str;
    }
}

/**
 * Main class
 */
public class Level019 {
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
        return new WorldMap<String, Double>();
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