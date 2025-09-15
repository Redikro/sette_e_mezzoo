package Mazzo;

import Factory_method.CardFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazzo {
    private static Mazzo instance;
    private final List<Carta> original = CardFactory.createNapoletaneDeck(); // ordine base (per reset)
    private List<Carta> mazzo = CardFactory.createNapoletaneDeck();

    /**
     * @return il mazzo corrente
     */
    public List<Carta> getMazzo() {
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
    public List<Carta> getOriginal() {
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
    public List<Carta> getRemainingCardsSnapshot() {
        return new ArrayList<>(mazzo);
    }

    private Mazzo() {}
}
