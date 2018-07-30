package task5_ComparingObjects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person() {
    }

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person other) {
        if (this.name.compareTo(other.name) == 0){
           if (Integer.compare(this.age, other.age) == 0){
               return this.town.compareTo(other.town);
           }

           return Integer.compare(this.age, other.age);
        }

        return this.name.compareTo(other.name);
    }
}
