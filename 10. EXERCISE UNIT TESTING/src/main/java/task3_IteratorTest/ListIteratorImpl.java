package task3_IteratorTest;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListIteratorImpl<T> implements ListIterator<T> {

    private List<T> list;
    private int index;

    public ListIteratorImpl(T... elements) {
        this.list = new ArrayList<>(Arrays.asList(elements));
        this.index = 0;
    }

    @Override
    public T print() throws OperationNotSupportedException {
        if (this.index < this.list.size()) {
            return this.list.get(this.index);
        }

        throw new OperationNotSupportedException("Invalid Operation!");
    }

    @Override
    public boolean move() {
        if (this.hasNext()) {
            this.index++;
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.list.size() - 1;
    }
}
