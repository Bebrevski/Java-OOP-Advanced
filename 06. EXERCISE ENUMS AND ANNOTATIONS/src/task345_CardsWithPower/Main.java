package task345_CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String rank1 = reader.readLine();
        String suit1 = reader.readLine();
        Card card1 = new Card(rank1, suit1);

        //Solution task 3 and 4;

        //System.out.println(card1);
        //return;

        String rank2 = reader.readLine();
        String suit2 = reader.readLine();
        Card card2 = new Card(rank2, suit2);

        if (card1.compareTo(card2) > 0) {
            System.out.println(card1);
        } else {
            System.out.println(card2);
        }
    }
}
