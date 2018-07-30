package task5_ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> collection = new ArrayList<>();

        String input;
        try {

            while (!(input = reader.readLine()).equals("END")) {
                String[] personInfo = input.split("\\s+");
                String name = personInfo[0];
                int age = Integer.parseInt(personInfo[1]);
                String town = personInfo[2];

                Person person = new Person(name, age, town);

                collection.add(person);
            }

            int index = Integer.parseInt(reader.readLine()) - 1;

            Person target = collection.get(index);

            int equal = 0;
            int notEqual = 0;

            for (Person person : collection) {
                if (person.compareTo(target) == 0) {
                    equal++;
                    continue;
                }

                notEqual++;
            }

            if (equal == 1) {
                System.out.println("No matches");
                return;
            }

            System.out.println(String.format("%s %d %s"
                    , equal
                    , notEqual
                    , collection.size()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
