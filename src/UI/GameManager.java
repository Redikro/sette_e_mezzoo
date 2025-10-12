package UI;

import Observer.Giocatore;
import Observer.TurnManager;
import State.*;
import Strategy.ActionStrategy;
import Strategy.CPU;
import UI.Screens.*;

import javax.swing.*;

public class GameManager {

    private GameState currentState;
    private final TurnManager turnManager = new TurnManager();
    private final ActionStrategy strategy = new CPU();

    public GameManager(String nome,int gettoni) {
        this.setState(new PlayingState(this));
        turnManager.aggiungiGiocatore(new Giocatore(nome,gettoni,true));
        turnManager.aggiungiGiocatore(new Giocatore("CPU1",gettoni,false));
        turnManager.aggiungiGiocatore(new Giocatore("CPU2",gettoni,false));
        turnManager.aggiungiGiocatore(new Giocatore("CPU3",gettoni,false));
    }

    public GameState getCurrentState() {
        return this.currentState;
    }

    public void setState(GameState state){
        this.currentState = state;
    }

    public TurnManager getTurnManager(){
        return this.turnManager;
    }

    public void onPesca() {
        System.out.println("Giocatore pesca una carta");
        // TODO: aggiungi logica pesca
    }

    public void onPassa() {
        System.out.println("Giocatore passa il turno");
        turnManager.nextTurn();
    }

    public void onPunta(Giocatore corrente) {
        if (getCurrentState() instanceof PlayingState) {
            currentState.onPunta(corrente);
        } else {
            JOptionPane.showMessageDialog(null, "Non puoi puntare in questo momento");
            JOptionPane.showMessageDialog(null, "Cambia nel costruttore di GameManager this.setState(new EvalState(this)) in this.setState(new PlayingState(this))");
        }
    }
}
