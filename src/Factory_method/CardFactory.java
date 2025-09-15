package Factory_method;
import Mazzo.Card;
import Mazzo.Seme;
import Mazzo.Valore;

import java.util.ArrayList;
import java.util.List;
public class CardFactory {

    public static Card createCard(Seme seme, Valore valore) {
        return new Card(seme, valore);
    }

    /**
     * @return la lista delle singole carte che compongono un mazzo
     */
    public static List<Card> createNapoletaneDeck() {
        List<Card> deck = new ArrayList<>(40);
        for (Seme s : Seme.values()) {
            for (Valore v : Valore.values()) {
                deck.add(createCard(s, v));
            }
        }
        return deck;
    }
}