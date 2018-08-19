package task4_BubbleSort;

public final class Bubble {
    private Bubble() {

    }

    public static <T extends Comparable<T>> void sort(T[] elements) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < elements.length - 1; i++) {
                if (elements[i].compareTo(elements[i + 1]) > 0) {
                    swapped = true;
                    T temp = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = temp;
                }
            }
        }
    }
}
