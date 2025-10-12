package State;

import Observer.Giocatore;
import UI.GameManager;

import javax.swing.*;

public class PlayingState implements GameState {
    private final GameManager context;

    public PlayingState(GameManager context) {
        this.context = context;
    }

    @Override
    public void enterState() {
        System.out.println("🪙 Fase di puntate iniziata!");
        context.getTurnManager().resetTurni();
    }

    @Override
    public void onPesca(Giocatore giocatore) {
        System.out.println("❌ Non puoi pescare in fase di puntate!");
    }

    @Override
    public void onPassa(Giocatore giocatore) {
        if (context.getTurnManager().getIndex() == context.getTurnManager().getNumberOfPlayers()) {
            context.setState(new EvalState(context));
        }
        context.getTurnManager().nextTurn();
    }

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
