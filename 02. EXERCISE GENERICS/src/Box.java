import java.util.List;

public class Box<T> {

    private T element;

    public Box(T element) {
        this.element = element;
    }

    public static <T> void swap(List<T> content, int index1, int index2) {
        T temp = content.get(index2);
        content.set(index2, content.get(index1));
        content.set(index1, temp);
    }


    @Override
    public String toString() {
        return String.format("%s: %s"
                , this.getElement().getClass().getName()
                , this.getElement());
    }

    public T getElement() {
        return this.element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
