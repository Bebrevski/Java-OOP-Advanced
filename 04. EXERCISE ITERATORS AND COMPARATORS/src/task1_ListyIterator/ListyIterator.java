package task1_ListyIterator;

import java.util.Arrays;
import java.util.List;

public final class ListyIterator<T> {

    private List<T> collection;
    private int iterator;

    public ListyIterator(T... collection) {
        this.collection = Arrays.asList(collection);
        this.iterator = 0;
    }

    public boolean move() {
        if (this.hasNext()) {
            this.iterator++;
            return true;
        }

        return false;
    }

    public boolean hasNext() {
        return this.iterator < this.collection.size() - 1;
    }

    public void print() {
        if (this.iterator < this.collection.size()) {
            System.out.println(this.collection.get(this.iterator));
        } else {
            System.out.println("Invalid Operation!");
        }
    }
}
