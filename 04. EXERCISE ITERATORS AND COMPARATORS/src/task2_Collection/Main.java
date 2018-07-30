package task2_Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            ListyIterator<String> listyIterator = new ListyIterator<>(Arrays.stream(reader.readLine()
                    .split("\\s+"))
                    .skip(1)
                    .toArray(String[]::new)
            );

            while (true) {
                String command = reader.readLine();

                if (command.equals("END")) {
                    break;
                }

                switch (command) {
                    case "HasNext":
                        System.out.println(listyIterator.hasNext());
                        break;
                    case "Move":
                        System.out.println(listyIterator.move());
                        break;
                    case "Print":
                        listyIterator.print();
                        break;
                    case "PrintAll":
                        listyIterator.printAll();
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
