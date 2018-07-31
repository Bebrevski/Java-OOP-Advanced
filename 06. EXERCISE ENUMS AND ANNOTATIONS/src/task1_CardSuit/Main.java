package task1_CardSuit;

public class Main {
    public static void main(String[] args) {
        CardSuit[] cards = CardSuit.values();

        System.out.println("Card Suits:");
        for (CardSuit card : cards) {
            System.out.println(card);
        }
    }
}
