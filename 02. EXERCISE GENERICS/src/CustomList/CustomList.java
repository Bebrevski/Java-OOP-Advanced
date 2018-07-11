package CustomList;

public interface CustomList<T extends Comparable<T>> extends Iterable {

    void add(T element);

    T remove(int index);

    boolean contains(T element);

    void swap(int index1, int index2);

    int countGreaterThan(T element);

    T getMax();

    T getMin();

    void sort();
}
