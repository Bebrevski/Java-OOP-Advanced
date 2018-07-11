package task10_Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nameAndAddress = reader.readLine().split("\\s+");
        String name = nameAndAddress[0] + " " + nameAndAddress[1];
        String address = nameAndAddress[2];

        Tuple<String, String> person = new Tuple<>(name, address);
        System.out.println(person);

        String[] nameAndBeer = reader.readLine().split("\\s+");
        String name2 = nameAndBeer[0];
        Integer beer = Integer.parseInt(nameAndBeer[1]);

        Tuple<String, Integer> person2 = new Tuple<>(name2, beer);
        System.out.println(person2);

        String[] input = reader.readLine().split("\\s+");
        Integer integer = Integer.parseInt(input[0]);
        Double doubl = Double.parseDouble(input[1]);

        Tuple<Integer, Double> some = new Tuple<>(integer, doubl);
        System.out.println(some);
    }
}
