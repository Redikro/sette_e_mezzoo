package Mazzo;

import Factory_method.CardFactory;

import java.util.List;

public class Mazzo {
    private static Mazzo instance;
    public static Mazzo getInstance() {
        if (instance == null)
            instance = new Mazzo();

        return instance;
    }

    private final List<Card> original = CardFactory.createNapoletaneDeck(); // ordine base (per reset)
    private final List<Card> cards = CardFactory.createNapoletaneDeck();

    public List<Card> getCards() {
        return cards;
    }

    public List<Card> getOriginal() {
        return original;
    }

    private Mazzo() {}
}
