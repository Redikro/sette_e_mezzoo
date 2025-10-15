package UI;

import Mazzo.Mazzo;
import Observer.*;
import State.*;
import Strategy.*;
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
        Mazzo.getInstance().mischiaCarte();
    }

    public Giocatore calcoloVincitore(Giocatore mazziere, Giocatore altro) {
        double punteggioMazziere = mazziere.getPunteggioCarte();
        double punteggioAltro = altro.getPunteggioCarte();

        boolean mazziereOut = mazziere.isOut();
        boolean altroOut = altro.isOut();

        // Caso 1: entrambi sballano → vince comunque il mazziere
        if (mazziereOut && altroOut) {
            mazziere.setGettoni(altro.getPuntata());
            return mazziere;
        }

        // Caso 2: l'altro sballa → vince il mazziere
        if (altroOut) {
            mazziere.setGettoni(altro.getPuntata());
            return mazziere;
        }

        // Caso 3: il mazziere sballa → vince l'altro
        if (mazziereOut) {
            altro.setGettoni(mazziere.getPuntata());
            return altro;
        }

        // Caso 4: nessuno sballa → vince chi è più vicino a 7.5
        if (punteggioMazziere >= punteggioAltro) {
            mazziere.setGettoni(altro.getPuntata());
            return mazziere;
        } else {
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

    public void setState(GameState state){
        this.currentState = state;
    }

    public TurnManager getTurnManager(){
        return this.turnManager;
    }

    public void onPesca() {
        currentState.onPesca(getTurnManager().getGiocatoreCorrente());
    }

    public void onPassa() {
        currentState.onPassa(getTurnManager().getGiocatoreCorrente());
        if (getTurnManager().getGiocatoreCorrente() == getTurnManager().getGiocatori().getLast()){
            nextState();
            getTurnManager().resetTurni();
        }
        else
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
