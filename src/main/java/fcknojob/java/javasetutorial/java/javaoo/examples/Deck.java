package fcknojob.java.javasetutorial.java.javaoo.examples;

import java.util.Arrays;

enum Suit {
    DIAMONDS, CLUBS, HEARTS, SPADES;
}

enum Rank {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
}

class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String toString() {
        return rank + " of " + suit;
    }
}

public class Deck {
    private Card[] cards = new Card[52];

    public Deck() {
        int i = 0;
        for (Suit s: Suit.values()) {
            for (Rank k: Rank.values()) {
                cards[i++] = new Card(s, k);
            }
        }
    }

    public Iterable<Card> getCardIterable() {
        return Arrays.asList(cards);
    }

    public static void main(String args[]) {
        for(Card card: new Deck().getCardIterable()){
            System.out.println(card);
        }
    }
}
