package task4_Froggy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            Integer[] numbers = Arrays.stream(reader.readLine()
                    .split("[, ]+"))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            Lake<Integer> lake = new Lake<>(numbers);

            String terminateCommand = reader.readLine();

            StringBuilder sb = new StringBuilder();
            for (Integer element : lake) {
                sb.append(element).append(", ");
            }

            sb.replace(sb.length() - 2, sb.length() - 1, "");
            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
