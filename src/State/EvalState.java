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


    @Override
    public void onPesca(Giocatore giocatore) {
        JOptionPane.showMessageDialog(null, "Non puoi pescare in questo momento");
        JOptionPane.showMessageDialog(null, "Cambia nel costruttore di GameManager this.setState(new EvalState(this)) in this.setState(new PlayingState(this))");
    }

    @Override
    public void onPassa(Giocatore giocatore) {
        if (giocatore.isMazziere())
            return;
        if (context.calcoloVincitore(context.getMazziere(),giocatore).isMazziere())
            JOptionPane.showMessageDialog(null, context.getMazziere().getNome() + " vince contro "+ giocatore.getNome());
        else
            JOptionPane.showMessageDialog(null, context.getMazziere().getNome() + " perde contro " + giocatore.getNome());
    }
    @Override
    public void onPunta(Giocatore giocatore) {
        JOptionPane.showMessageDialog(null, "Non puoi puntare in questo momento");
        JOptionPane.showMessageDialog(null, "Cambia nel costruttore di GameManager this.setState(new EvalState(this)) in this.setState(new PlayingState(this))");
    }
}
