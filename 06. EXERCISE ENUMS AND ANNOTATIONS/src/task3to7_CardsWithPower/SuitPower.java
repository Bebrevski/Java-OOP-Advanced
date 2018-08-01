package task3to7_CardsWithPower;

@CustomAnnotation(category = "Suit", description = "Provides suit constants for a Card class.")
public enum SuitPower {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

   private int suitPower;

    SuitPower(int suitPower) {
        this.suitPower = suitPower;
    }

    public int getSuitPower() {
        return this.suitPower;
    }
}
