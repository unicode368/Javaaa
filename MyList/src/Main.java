import myAlgorithm.MyAlgorithm;
import myCollection.MyCollection;

public class Main {
    public static void main(String[] args) {
        MyAlgorithm numberOccurrences = new MyAlgorithm();
        numberOccurrences.calculateUniqueNumbers();
        MyCollection<Integer> myCollection = new MyCollection<>();
        myCollection.add(2);
        myCollection.add(3);
        myCollection.remove(1);
    }
}
