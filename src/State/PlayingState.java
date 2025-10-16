package State;

import Observer.Giocatore;
import Mazzo.Mazzo;
import UI.GameManager;

import javax.swing.*;

public class PlayingState implements GameState {
    private final GameManager context;

    public PlayingState(GameManager context) {
        this.context = context;
    }

    @Override
    public void onPesca(Giocatore giocatore) {

    }

    @Override
    public void onPassa(Giocatore giocatore) {}

    @Override
    public void onPunta(Giocatore giocatore) {

    }
}
