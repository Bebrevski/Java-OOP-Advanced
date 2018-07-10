package tasks_1to6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GBox<T extends Comparable<T>> {

    private List<T> list;

    public GBox() {
        this.list = new ArrayList<>();
    }

    public int getCount(T element) {
        int count = 0;

        for (T current : this.getList()) {
            if (current.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    public List<T> getList() {
        return Collections.unmodifiableList(this.list);
    }

    public void addElementToList(T element) {
        this.list.add(element);
    }
}
