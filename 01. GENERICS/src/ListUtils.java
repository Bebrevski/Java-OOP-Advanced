import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list!");
        }

        T min = list.get(0);

        for (T element : list) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }

        return min;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list!");
        }

        T max = list.get(0);

        for (T element : list) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }

        return max;
    }

    public static Iterable<Integer> getNullIndices(List<?> list) {
        Collection<Integer> indices = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null) {
                indices.add(i);
            }
        }

        return indices;
    }

    public static <T> void flatten(List<? super T> destination, List<List<? extends T>> source) {

        for (List<? extends T> list : source) {
            destination.addAll(list);
        }
    }

    public static <T> void addAll(List<? super T> destination, List<? extends T> source) {
        destination.addAll(source);
    }
}
