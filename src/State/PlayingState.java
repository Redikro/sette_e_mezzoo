package State;

import Observer.Giocatore;
import Mazzo.Mazzo;

import javax.swing.*;

public class PlayingState implements GameState {

    @Override
    public void onPesca(Giocatore giocatore) {
        giocatore.addCarta(Mazzo.daiCarta());
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
    }
}
