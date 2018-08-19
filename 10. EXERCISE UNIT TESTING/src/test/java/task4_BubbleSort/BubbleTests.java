package task4_BubbleSort;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.Timer;

public class BubbleTests {

    @Test
    public void bubbleSort_orderElements() {
        Integer[] elements = {4, 2, 0, 3, 1};
        Bubble.sort(elements);

        Integer[] expected = {0, 1, 2, 3, 4};

        Assert.assertArrayEquals(expected, elements);
    }

    @Test
    public void bubbleSort_orderBigArray(){
        Integer[] elements = new Integer[1000];
        Random rnd = new Random();

        Integer[] expected = new Integer[1000];

        for (int i = 0; i < elements.length; i++) {
            int random = rnd.nextInt(Integer.MAX_VALUE);
            elements[i] = random;
            expected[i] = random;
        }

        Bubble.sort(elements);
        Arrays.sort(expected);

        Assert.assertArrayEquals(expected, elements);
    }
}
