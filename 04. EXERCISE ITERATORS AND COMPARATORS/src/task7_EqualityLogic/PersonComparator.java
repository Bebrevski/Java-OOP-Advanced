package task7_EqualityLogic;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().compareTo(o2.getName()) == 0){
            return Integer.compare(o1.getAge(), o2.getAge());
        }

        return o1.getName().compareTo(o2.getName());
    }
}