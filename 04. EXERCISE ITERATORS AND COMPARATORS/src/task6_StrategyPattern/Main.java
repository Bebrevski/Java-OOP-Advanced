package task6_StrategyPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> personByName = new TreeSet<>(new PersonNameComparator());
        Set<Person> personByAge = new TreeSet<>(new PersonAgeComparator());

        try {
            int count = Integer.parseInt(reader.readLine());

            while (count-- != 0) {
                String[] tokens = reader.readLine().split("\\s+");

                Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));

                personByName.add(person);
                personByAge.add(person);
            }

            personByName.forEach(System.out::println);
            personByAge.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
