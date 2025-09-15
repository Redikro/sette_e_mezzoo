package Mazzo;

import Factory_method.CardFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazzo {
    private static Mazzo instance;
    private final List<Card> original = CardFactory.createNapoletaneDeck(); // ordine base (per reset)
    private List<Card> mazzo = CardFactory.createNapoletaneDeck();

    /**
     * @return il mazzo corrente
     */
    public List<Card> getMazzo() {
        return mazzo;
    }
    /**
     * Istanza singleton
     * @return istanza
     */
    public static Mazzo getInstance() {
        if (instance == null)
            instance = new Mazzo();

        return instance;
    }

    /**
     * @return il mazzo originale
     */
    public List<Card> getOriginal() {
        return original;
    }

    /**
     * Ripristina mazzo originale
     */
    public void resettaMazzo(){
        this.mazzo = original;
    }

    /**
     * Mischia il mazzo corrente
     */
    public void mischiaCarte() {
        Collections.shuffle(mazzo);
    }

    /**
     * @return quante carte rimangono nel mazzo
     */
    public int remaining() {
        return mazzo.size();
    }

    /**
     *
     * @return lista di carte che rimangono nel mazzo
     */
    public List<Card> getRemainingCardsSnapshot() {
        return new ArrayList<>(mazzo);
    }

    private Mazzo() {}
}
