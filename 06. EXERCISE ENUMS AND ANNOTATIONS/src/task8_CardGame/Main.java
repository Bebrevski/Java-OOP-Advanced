package task8_CardGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String player1Name = reader.readLine();
        String player2Name = reader.readLine();

        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);

        addInfo(reader, player1);
        addInfo(reader, player2);

        System.out.println(player1.checkCards() > player2.checkCards() ? player1 : player2);
    }

    private static void addInfo(BufferedReader reader, Player player) throws IOException {
        while (player.getCards().size() != 5) {
            String[] inputCards = reader.readLine().split(" of ");
            String rank = inputCards[0];
            String suit = inputCards[1];

            try {
                Card currentCard = new Card(rank, suit);

                if (player.hasSuchCard(currentCard)) {
                    System.out.println("Card is not in the deck.");
                    continue;
                } else {
                    player.addCard(currentCard);
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("No such card exists.");
            }
        }
    }
}
