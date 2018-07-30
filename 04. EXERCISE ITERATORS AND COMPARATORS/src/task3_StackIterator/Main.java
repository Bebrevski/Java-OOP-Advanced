package task3_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Stack<Integer> stack = new Stack<>();

            while (true) {
                String[] tokens = reader.readLine().split("[, ]+");
                String command = tokens[0];

                if (command.equals("END")) {
                    for (Integer element : stack) {
                        System.out.println(element);
                    }

                    for (Integer element : stack) {
                        System.out.println(element);
                    }

                    break;
                }

                switch (command) {
                    case "Push":
                        stack.push(Arrays.stream(tokens)
                                .skip(1)
                                .map(Integer::parseInt)
                                .toArray(Integer[]::new));
                        break;
                    case "Pop":
                        try {
                            stack.pop();
                        } catch (StackNoElementsException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
