package Strategy;

import Observer.Giocatore;
import java.util.ArrayList;

public interface ActionStrategy {

    int puntaGettoni(Giocatore giocatore,ArrayList<Giocatore> giocatori);
    Action chooseAction(Giocatore giocatore);
}
