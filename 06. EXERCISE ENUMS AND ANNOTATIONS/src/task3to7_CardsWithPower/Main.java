package task3to7_CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Start code for task 3, 4, 5

//        String rank1 = reader.readLine();
//        String suit1 = reader.readLine();
//        Card card1 = new Card(rank1, suit1);

        //Solution task 3 and 4;

        //System.out.println(card1);


        //Solution task 5;

//        String rank2 = reader.readLine();
//        String suit2 = reader.readLine();
//        Card card2 = new Card(rank2, suit2);
//
//        if (card1.compareTo(card2) > 0) {
//            System.out.println(card1);
//        } else {
//            System.out.println(card2);
//        }

        //Solution task 6

//        String typeOfEnum = reader.readLine();
//        CustomAnnotation annotation;
//
//        switch (typeOfEnum) {
//            case "Rank":
//                annotation = RankPowers.class.getAnnotation(CustomAnnotation.class);
//                break;
//
//            case "Suit":
//                annotation = SuitPower.class.getAnnotation(CustomAnnotation.class);
//                break;
//            default:
//                return;
//        }
//
//        System.out.println(getOutput(annotation));


        //Solution task 7

//        String input = reader.readLine();
//
//        SuitPower[] suits = SuitPower.values();
//
//        RankPowers[] ranks = RankPowers.values();
//
//        for (SuitPower suit : suits) {
//            for (RankPowers rank : ranks) {
//                System.out.println(String.format("%s of %s", rank.name(), suit.name()));
//            }
//        }


    }

    @Deprecated(since = "Only for task 6")
    private static String getOutput(CustomAnnotation annotation) {
        return String.format("Type = %s, Description = %s"
                , annotation.type(), annotation.description());
    }
}
