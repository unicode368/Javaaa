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
        ArrayList<Integer> counter = new ArrayList<>();
        ArrayList<Integer> uniqueNumbers = new ArrayList<>();

        while (!numbers.isEmpty()) {
            if (!uniqueNumbers.contains(numbers.get(0))) {
                uniqueNumbers.add(numbers.get(0));
                counter.add(0);
            }
            int index = uniqueNumbers.indexOf(numbers.get(0));
            counter.set(index, counter.get(index) + 1);
            numbers.remove(0);
        }
        printResult(uniqueNumbers, counter);
    }

    public void printResult(ArrayList<Integer> elements, ArrayList<Integer> occurrences) {
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i) +
                    " - " + occurrences.get(i));
        }
    }
}
