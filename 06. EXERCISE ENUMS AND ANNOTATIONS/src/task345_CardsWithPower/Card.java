package task345_CardsWithPower;

public class Card implements Comparable<Card> {
    private RankPowers rankPowers;
    private SuitPower suitPower;
    private int cardPower;

    public Card(String rankPowers, String suitPower) {
        this.rankPowers = Enum.valueOf(RankPowers.class, rankPowers.toUpperCase());
        this.suitPower = Enum.valueOf(SuitPower.class, suitPower.toUpperCase());

        this.cardPower = this.rankPowers.getCardPower() + this.suitPower.getSuitPower();
    }


    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d"
                , this.rankPowers.name()
                , this.suitPower.name()
                , this.cardPower);
    }

    @Override
    public int compareTo(Card other) {
        if (Integer.compare(this.cardPower, other.cardPower) > 0) {
            return 1;
        } else if (Integer.compare(this.cardPower, other.cardPower) < 0) {
            return -1;
        }

        return 0;
    }
}
