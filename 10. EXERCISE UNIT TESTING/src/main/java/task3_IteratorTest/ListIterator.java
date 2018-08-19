package task3_IteratorTest;

import javax.naming.OperationNotSupportedException;

public interface ListIterator<T> {

    T print() throws OperationNotSupportedException;

    boolean move();

    boolean hasNext();
}
