package task8_CardGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Player {

    private Comparator<Card> COMPARATOR = getComparator();

    private String name;
    private List<Card> cards;
    private String winningRank;
    private String winningSuit;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(this.cards);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public boolean hasSuchCard(Card card) {
        for (Card currentCard : this.cards) {
            if (currentCard.getCardPower() == card.getCardPower()) {
                return true;
            }
        }

        return false;
    }

    private void sortCards() {
        Collections.sort(this.cards, COMPARATOR);
    }

    private Comparator<Card> getComparator() {
        return (c1, c2) -> Integer.compare(c2.getCardPower(), c1.getCardPower());
    }

    public int checkCards() {
        this.sortCards();

        int highestCardValue = this.cards.get(0).getCardPower();
        this.winningRank = this.cards.get(0).getRank().name();
        this.winningSuit = this.cards.get(0).getSuit().name();

        return highestCardValue;
    }

    @Override
    public String toString() {
        return String.format("%s wins with %s of %s."
                , this.name
                , this.winningRank
                , this.winningSuit);
    }
}
