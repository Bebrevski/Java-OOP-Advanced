package task8_CardGame;

public class Card {

    private Rank rank;
    private Suit suit;
    private int cardPower;

    public Card(String rankPowers, String suit) throws IllegalArgumentException {

        this.rank = Enum.valueOf(Rank.class, rankPowers);
        this.suit = Enum.valueOf(Suit.class, suit);

        this.cardPower = this.rank.getCardPower() + this.suit.getSuitPower();
    }

    public int getCardPower() {
        return this.cardPower;
    }

    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }
}
