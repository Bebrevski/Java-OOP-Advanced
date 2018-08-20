package P01_ExtendedArrayList;

import P01_ExtendedArrayList.ExtendedArrayList;

public class Main {
    public static void main(String[] args) {

        ExtendedArrayList<Integer> myList = new ExtendedArrayList<Integer>(){{
            add(1);
            add(10);
            add(5);
            add(7);
            add(3);
        }};

        System.out.println(myList.min());
        System.out.println(myList.max());

        ExtendedArrayList<String> myList2 = new ExtendedArrayList<String>(){{
            add("a");
            add("b");
            add("zAz");
            add("aF");
            add("maW");
        }};

        System.out.println(myList2.min());
        System.out.println(myList2.max());
    }
}
