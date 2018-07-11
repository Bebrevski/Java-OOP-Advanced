package task11_Threeuple;

public class Threeuple<K, V1, V2> {

    private K key;
    private V1 valueOne;
    private V2 valueTwo;

    public Threeuple(K key, V1 valueOne, V2 valueTwo) {
        this.key = key;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s"
                , this.getKey()
                , this.getValueOne()
                , this.getValueTwo());
    }

    public K getKey() {
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V1 getValueOne() {
        return this.valueOne;
    }

    public void setValueOne(V1 valueOne) {
        this.valueOne = valueOne;
    }

    public V2 getValueTwo() {
        return this.valueTwo;
    }

    public void setValueTwo(V2 valueTwo) {
        this.valueTwo = valueTwo;
    }
}
