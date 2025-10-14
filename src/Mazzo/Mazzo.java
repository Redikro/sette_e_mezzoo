package Mazzo;

import Factory_method.CardFactory;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazzo {
    private static Mazzo instance;
    private static final List<Carta> original = CardFactory.createNapoletaneDeck();
    private static List<Carta> mazzo = CardFactory.createNapoletaneDeck();

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

    public static Carta daiCarta(){
        try {
            if (mazzo.isEmpty())
                throw new MazzoFinito("Mazzo Finito");
            Carta carta = mazzo.getFirst();
            mazzo.remove(carta);
            return carta;
        }
        catch (MazzoFinito e){
            JOptionPane.showMessageDialog(null,"Mazzo finito. Rimescolamento in corso");
            getInstance().resettaMazzo();
            getInstance().mischiaCarte();
            return daiCarta();
        }
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
        mazzo = original;
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
