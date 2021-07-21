package myAlgorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MyAlgorithm {

    ArrayList<Integer> numbers;

    public MyAlgorithm() {
        numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(-6);
        numbers.add(4);
        numbers.add(5);
        numbers.add(3);
        numbers.add(4);
        numbers.add(2);
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
    }

    public void calculateUniqueNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        printResult(uniqueNumbers);
    }

    public void printResult(Set<Integer> elementsAndOccurrences) {
        for (Integer number : elementsAndOccurrences) {
            System.out.println(number);
        }
    }
}
