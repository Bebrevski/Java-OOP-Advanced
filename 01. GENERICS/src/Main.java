import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 3, 4, 5);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 1.1, 2.2, 3.3, 4.4, 5.5);

        List<Number> dest = new ArrayList<>();

        ListUtils.addAll(dest, integers);
        ListUtils.addAll(dest, doubles);

        System.out.println(dest);
    }
}
