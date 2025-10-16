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
    public void onPesca(Giocatore giocatore) {
        JOptionPane.showMessageDialog(null, "Non puoi pescare in questo momento");
    }

    @Override
    public void onPassa(Giocatore giocatore) {
        if (!giocatore.isMazziere())
            JOptionPane.showMessageDialog(null, context.getMazziere().getNome() + " vince contro "+ giocatore.getNome());
        else
            JOptionPane.showMessageDialog(null, context.getMazziere().getNome() + " perde contro " + giocatore.getNome());
        giocatore.svuotaMano();
        System.out.println(giocatore.getMano().isEmpty());
    }

    @Override
    public void onPunta(Giocatore giocatore) {
        JOptionPane.showMessageDialog(null, "Non puoi puntare in questo momento");
    }
}
