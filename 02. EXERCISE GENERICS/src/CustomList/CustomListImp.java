package CustomList;

import java.util.*;
import java.util.function.Consumer;

public class CustomListImp<T extends Comparable<T>> implements CustomList<T> {

    private List<T> list;

    public CustomListImp() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(T element) {
        this.list.add(element);
    }

    @Override
    public T remove(int index) {
        return this.list.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.list.contains(element);
    }

    @Override
    public void swap(int index1, int index2) {
        T temp = this.list.get(index1);
        this.list.set(index1, this.list.get(index2));
        this.list.set(index2, temp);
    }

    @Override
    public int countGreaterThan(T element) {
        int count = 0;

        for (int i = 0; i < this.list.size(); i++) {
            if ((this.list.get(i)).compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    @Override
    public T getMax() {
        return Collections.max(this.list);
    }

    @Override
    public T getMin() {
        return Collections.min(this.list);
    }

    @Override
    public void sort() {
        Collections.sort(list);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T element : list) {
            sb.append(element).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}