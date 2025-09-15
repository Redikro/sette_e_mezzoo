package Factory_method;
import Mazzo.Carta;
import Mazzo.Seme;
import Mazzo.Valore;

import java.util.ArrayList;
import java.util.List;
public class CardFactory {

    public static Carta createCard(Seme seme, Valore valore) {
        return new Carta(seme, valore);
    }

    /**
     * @return la lista delle singole carte che compongono un mazzo
     */
    public static List<Carta> createNapoletaneDeck() {
        List<Carta> deck = new ArrayList<>(40);
        for (Seme s : Seme.values()) {
            for (Valore v : Valore.values()) {
                deck.add(createCard(s, v));
            }
        }
        return deck;
    }
}