package Strategy;

import Observer.Giocatore;
import Observer.TurnManager;

import java.util.ArrayList;

public interface ActionStrategy {
    enum Action {
        PESCA,PASSA;

        @Override
        public String toString() {
            return switch (this){
                case PESCA -> "Pesca";
                case PASSA -> "Passa";
            };
        }
    }

    int puntaGettoni(Giocatore giocatore,ArrayList<Giocatore> giocatori);
    Action chooseAction(Giocatore giocatore);
}
