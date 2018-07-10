package tasks_1to6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        //Problem 5.	Generic Count Method Strings

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int lines = Integer.parseInt(reader.readLine());
        GBox<Double> box = new GBox<>();

        for (int i = 0; i < lines; i++) {
            box.addElementToList(Double.parseDouble(reader.readLine()));
        }

        Double element = Double.parseDouble(reader.readLine());

        System.out.println(box.getCount(element));


        //Problem 5. Generic Count Method Strings

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int lines = Integer.parseInt(reader.readLine());
//        tasks_1to6.GBox<String> box = new tasks_1to6.GBox<>();
//
//        for (int i = 0; i < lines; i++) {
//            box.addElementToList(reader.readLine());
//        }
//
//        String element = reader.readLine();
//
//        System.out.println(box.getCount(element));


        //TASK 4 - Generic Swap Method Integers

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int lines = Integer.parseInt(reader.readLine());
//        List<tasks_1to6.Box<Integer>> content = new ArrayList<>();
//
//        for (int i = 0; i < lines; i++) {
//            content.add(new tasks_1to6.Box<>(Integer.parseInt(reader.readLine())));
//        }
//
//        int[] indices = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int index1 = indices[0];
//        int index2 = indices[1];
//
//        tasks_1to6.Box.swap(content, index1, index2);
//
//        content.forEach(System.out::println);


        //TASK 3 - Generic Swap Method Strings

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int lines = Integer.parseInt(reader.readLine());
//        List<tasks_1to6.Box<String>> content = new ArrayList<>();
//
//        for (int i = 0; i < lines; i++) {
//            content.add(new tasks_1to6.Box<>(reader.readLine()));
//        }
//
//        int[] indices = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int index1 = indices[0];
//        int index2 = indices[1];
//
//        tasks_1to6.Box.swap(content, index1, index2);
//
//        content.forEach(System.out::println);

        // TEST WITH STRING

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int lines = Integer.parseInt(reader.readLine());
//
//        tasks_1to6.Box<String> box;
//        for (int i = 0; i < lines; i++) {
//            box = new tasks_1to6.Box<>(reader.readLine());
//
//            System.out.println(box);
//        }

        //TEST WITH INTEGER

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        int lines = Integer.parseInt(reader.readLine());
//
//        tasks_1to6.Box<Integer> box;
//        for (int i = 0; i < lines; i++) {
//            box = new tasks_1to6.Box<>(Integer.parseInt(reader.readLine()));
//
//            System.out.println(box);
//        }
    }
}
