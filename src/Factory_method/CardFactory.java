package Factory_method;
import Mazzo.Card;
import Mazzo.Seme;
import Mazzo.Valore;

import java.util.ArrayList;
import java.util.List;
public class CardFactory {

    // Crea una singola carta
    public static Card createCard(Seme seme, Valore valore) {
        return new Card(seme, valore);
    }

    // Crea un mazzo completo da 40 carte napoletane
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