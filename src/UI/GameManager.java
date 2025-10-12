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

    public Giocatore calcoloVincitore(Giocatore mazziere, Giocatore altro){
        if (altro.isOut() || mazziere.getPunteggioCarte() >= altro.getPunteggioCarte()) {
            mazziere.setGettoni(altro.getPuntata());
            return mazziere;
        }
        else {
            altro.setGettoni(mazziere.getPuntata());
            return altro;
        }
    }
    public Giocatore getMazziere(){
        for (Giocatore g : turnManager.getGiocatori()){
            if (g.isMazziere())
                return g;
        }
        return null;
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
        currentState.onPassa(getTurnManager().getGiocatoreCorrente());
        if (getTurnManager().getIndex() == 3){
            nextState();
            getTurnManager().resetIndex();
        }
        turnManager.nextTurn();

    }

    private void nextState(){
        if (currentState instanceof EvalState)
            currentState = new PlayingState(this);
        else {
            currentState = new EvalState(this);
        }
    }

    public void onPunta(Giocatore corrente) {
            currentState.onPunta(corrente);
    }
}
