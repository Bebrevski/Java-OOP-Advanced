package task3_StackIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Stack<T extends Integer> implements Iterable<T> {

    private List<T> collection;

    public Stack() {
        this.collection = new ArrayList<>();
    }

    public T pop() throws StackNoElementsException {
        try {
            return this.collection.remove(this.collection.size() - 1);
        } catch (IndexOutOfBoundsException ex) {
            throw new StackNoElementsException("No elements");
        }
    }

    public void push(T[] element) {
        this.collection.addAll(Arrays.asList(element));
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private final class StackIterator implements Iterator<T> {

        private int counter;

        public StackIterator() {
            this.counter = collection.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return this.counter >= 0;
        }

        @Override
        public T next() {
            return collection.get(this.counter--);
        }
    }
}
