/**
 * CSE3040 HW3
 * Level018.java
 * Purpose: Read data from file, then sorts the data, first by price, then by
 *          name in alphabetical order.
 *
 * @version 1.0 Nov. 29. 2019.
 * @author MJ Shin
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Class for saving read data.
 */
class Element implements Comparable<Element>{
    String name;
    Double value;

    /**
     * Constructor for class Element.
     * @param name  String representing name.
     * @param value Double value representing price.
     */
    public Element(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    /**
     * compareTo method for implementing Comparable interface
     * @param o Element to compare this instance to
     * @return  0 if equal, -1 if this instance is smaller, 1 if larger.
     */
    @Override
    public int compareTo(Element o) {
        /* first, compare by value, then, by name */
        if(!this.value.equals(o.value)) {
            return this.value.compareTo(o.value);
        } else if(!this.name.equals(o.name)) {
            return this.name.compareTo(o.name);
        }
        return 0;
    }

    /**
     * Overridden toString() method
     * @return String representation of this instance.
     */
    @Override
    public String toString() {
        String str = "";
        str += this.name;
        str += " ";
        str += this.value;
        return str;
    }
}

/**
 * Main class
 */
public class Level018 {
    /**
     * Read data from given input file
     * @param  fileName String instance containing input file directory
     * @param  list     List of Element to write data to.
     * @return         0 if whole read was successful, 1 if there was an error.
     */
    private static int readDataFromFile(String fileName, List<Element> list) {
        String buffer, name;
        Double value;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while((buffer = br.readLine()) != null) {
                /* read data from line read */
                name = buffer.split(" ")[0];
                value = Double.parseDouble(buffer.split(" ")[1]);

                /* save read data */
                list.add(new Element(name, value));
            }
        } catch (IOException e) {
            return 1; // error code
        }
        return 0; // successful read
    }
    public static void main(String[] args) throws Exception {
        ArrayList<Element> list = new ArrayList<>();
        int rv = readDataFromFile("./input.txt", list);
        if (rv == 1) {
            System.out.println("input file not found!");
            return;
        }
        Collections.sort(list);
        Iterator<Element> it = list.iterator();
        while (it.hasNext()) System.out.println(it.next());
    }
}