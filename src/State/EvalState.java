package State;

import Observer.Giocatore;
import UI.GameManager;

import javax.swing.*;

public class EvalState implements GameState {
    private final GameManager context;

    public EvalState(GameManager context) {
        this.context = context;
    }

    @Override
    public void enterState() {
        JOptionPane.showMessageDialog(null, "Valutazioni finali");

    }

    private boolean controllaVincitore(Giocatore mazziere,Giocatore corrente){
        return false;
    }

    @Override
    public void onPesca(Giocatore giocatore) {}
    @Override
    public void onPassa(Giocatore giocatore) {}
    @Override
    public void onPunta(Giocatore giocatore) {}
}
