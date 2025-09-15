package Mazzo;

import Factory_method.CardFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazzo {
    private static Mazzo instance;
    public static Mazzo getInstance() {
        if (instance == null)
            instance = new Mazzo();

        return instance;
    }

    private final List<Card> original = CardFactory.createNapoletaneDeck(); // ordine base (per reset)
    private List<Card> mazzo = CardFactory.createNapoletaneDeck();

    public List<Card> getMazzo() {
        return mazzo;
    }

    public List<Card> getOriginal() {
        return original;
    }

    public void resettaMazzo(){
        this.mazzo = original;
    }

    public void mischiaCarte() {
        Collections.shuffle(mazzo);
    }

    public void resetAndShuffle() {
        resettaMazzo();
        mischiaCarte();
    }

    public int remaining() {
        return mazzo.size();
    }

    public List<Card> getRemainingCardsSnapshot() {
        return new ArrayList<>(mazzo);
    }

    private Mazzo() {}
}
