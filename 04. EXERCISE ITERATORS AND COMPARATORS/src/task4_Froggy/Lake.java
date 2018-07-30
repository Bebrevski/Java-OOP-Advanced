package task4_Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable<T> {

    private List<T> collection;

    public Lake(T... numbers) {
        this.collection = new ArrayList<>(Arrays.asList(numbers));
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<T> {

        private int evenIndex;
        private int oddIndex;

        public Frog() {
            this.evenIndex = -2;
            this.oddIndex = -1;
        }

        @Override
        public boolean hasNext() {
            if (this.evenIndex + 2 < collection.size()){
                return true;
            }

            if (this.oddIndex + 2 < collection.size()){
                return true;
            }

            return false;
        }

        @Override
        public T next() {
            if (this.evenIndex + 2 < collection.size()){
                return collection.get(evenIndex += 2);
            }

            return collection.get(oddIndex += 2);
        }
    }
}
