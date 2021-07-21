package myCollection;

import java.util.ArrayList;

public class MyCollection<T> extends ArrayList<T> {

    @Override
    public T remove(int index) {
        try {
            throw new WrongOperationException("операція видалення не підтримується.");
        } catch (WrongOperationException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
