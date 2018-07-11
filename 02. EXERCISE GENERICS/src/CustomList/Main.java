package CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomList<String> myList = new CustomListImp<String>();

        String input = reader.readLine();

        while (!Constants.TERMINATE_COMMAND.equals(input)) {

            dispatchCommand(input, myList);

            input = reader.readLine();
        }
    }

    private static void dispatchCommand(String input, CustomList<String> myList) {
        String[] tokens = input.split("\\s+");

        String command = tokens[0];

        switch (command) {
            case Constants.ADD:

                myList.add(tokens[1]);
                break;

            case Constants.REMOVE:

                myList.remove(Integer.parseInt(tokens[1]));
                break;

            case Constants.MAX:

                System.out.println(myList.getMax());
                break;

            case Constants.MIN:

                System.out.println(myList.getMin());
                break;

            case Constants.GREATER:

                System.out.println(myList.countGreaterThan(tokens[1]));
                break;

            case Constants.SWAP:

                myList.swap(
                        Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2])
                );
                break;

            case Constants.CONTAINS:

                System.out.println(myList.contains(tokens[1]));
                break;

            case Constants.PRINT:

                System.out.println(myList.toString());
                break;

            case Constants.SORT:

                myList.sort();
                break;
        }
    }
}
