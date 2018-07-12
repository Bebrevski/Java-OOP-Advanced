package task11_Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nameAndAddress = reader.readLine().split("\\s+");
        String name = nameAndAddress[0] + " " + nameAndAddress[1];
        String address = nameAndAddress[2];
        String town = nameAndAddress[3];

        Threeuple<String, String, String> person = new Threeuple<>(name, address, town);
        System.out.println(person);

        String[] nameAndBeer = reader.readLine().split("\\s+");
        String name2 = nameAndBeer[0];
        Integer beer = Integer.parseInt(nameAndBeer[1]);
        String drunk = nameAndBeer[2];

        Threeuple<String, Integer, Boolean> person2 = new Threeuple<>(name2, beer, drunk.equals("drunk"));
        System.out.println(person2);

        String[] input = reader.readLine().split("\\s+");
        String name3 = input[0];
        Double doubl = Double.parseDouble(input[1]);
        String bank = input[2];

        Threeuple<String, Double, String> some = new Threeuple<>(name3, doubl, bank);
        System.out.println(some);
    }
}
