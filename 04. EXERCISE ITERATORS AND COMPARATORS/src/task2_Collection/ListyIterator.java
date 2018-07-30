package task2_Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator<T> implements Iterable<T> {

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

    public void printAll() {
        StringBuilder sb = new StringBuilder();

        for (T element : this) {
            sb.append(element).append(" ");
        }

        System.out.println(sb);
    }

    @Override
    public Iterator<T> iterator() {
        return new ListyIteratorImpl();
    }

    private final class ListyIteratorImpl implements Iterator<T> {

        private int counter;

        public ListyIteratorImpl() {
            this.counter = counter;
        }

        @Override
        public boolean hasNext() {
            return this.counter < collection.size();
        }

        @Override
        public T next() {
            return collection.get(this.counter++);
        }
    }
}
