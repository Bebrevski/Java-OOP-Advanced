package task3_CoffeeMachine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CoffeeMachine machine = new CoffeeMachine();

        String line;
        while (!"END".equals(line = reader.readLine())) {
            String[] cmdArgs = line.split(" ");

            if (cmdArgs.length == 1) {
                machine.insertCoin(cmdArgs[0]);
            } else {
                machine.buyCoffee(cmdArgs[0], cmdArgs[1]);
            }
        }

        for (Coffee coffee : machine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}
