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
        if (!giocatore.isOut())
            giocatore.addCarta(Mazzo.daiCarta());
        else
            JOptionPane.showMessageDialog(null,giocatore.getNome() + " ha sballato");
        context.getTurnManager().notifyObservers();
        System.out.println(giocatore.getMano());
    }

    @Override
    public void onPassa(Giocatore giocatore) {}

    @Override
    public void onPunta(Giocatore giocatore) {
        SpinnerNumberModel mod = new SpinnerNumberModel(1, 1, giocatore.getGettoni(), 1);
        JSpinner spinner = new JSpinner(mod);
        int result = JOptionPane.showConfirmDialog(
                null,
                spinner,
                giocatore.getNome() + ": Inserisci numero di gettoni da puntare",
                JOptionPane.OK_CANCEL_OPTION
        );
        if (result == JOptionPane.OK_OPTION) {
            int puntata = (int) spinner.getValue();
            if (!giocatore.punta(puntata))
                JOptionPane.showMessageDialog(null,"Non hai abbastanza gettoni");
        }
        context.getTurnManager().notifyObservers();
    }
}
