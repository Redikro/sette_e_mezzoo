package UI;

import Mazzo.Mazzo;
import Observer.*;
import Strategy.*;
import UI.Screens.*;

import javax.swing.*;

public class GameManager {

    private final TurnManager turnManager = new TurnManager();
    private final ActionStrategy strategy = new CPU();

    public GameManager(String nome,int gettoni) {
        turnManager.aggiungiGiocatore(new Giocatore(nome,gettoni,true));
        turnManager.aggiungiGiocatore(new Giocatore("CPU1",gettoni,false));
        turnManager.aggiungiGiocatore(new Giocatore("CPU2",gettoni,false));
        turnManager.aggiungiGiocatore(new Giocatore("CPU3",gettoni,false));
        Mazzo.getInstance().mischiaCarte();
    }

    public void calcoloVincitore() {
        JOptionPane.showMessageDialog(null, "Calcolo vincitori");
        StringBuilder text = new StringBuilder();
        Giocatore mazziere = getMazziere();

        for (Giocatore giocatore : getTurnManager().getGiocatoriNoMazziere()) {
            float punteggioMazziere = mazziere.getPunteggioCarte();
            float punteggioAltro = giocatore.getPunteggioCarte();
            boolean mazziereOut = mazziere.isOut();
            boolean altroOut = giocatore.isOut();

            if (mazziereOut && altroOut) {
                text.append(mazziere.getNome())
                        .append(" vince contro ")
                        .append(giocatore.getNome())
                        .append(" (entrambi sballano)\n");
            }
            else if (altroOut) {
                text.append(mazziere.getNome())
                        .append(" vince contro ")
                        .append(giocatore.getNome())
                        .append(" (")
                        .append(giocatore.getNome())
                        .append(" ha sballato)\n");
            }
            else if (mazziereOut) {
                text.append(mazziere.getNome())
                        .append(" perde contro ")
                        .append(giocatore.getNome())
                        .append(" (mazziere ha sballato)\n");
            }
            else if (punteggioMazziere >= punteggioAltro) {
                text.append(mazziere.getNome())
                        .append(" vince contro ")
                        .append(giocatore.getNome())
                        .append(" (")
                        .append(punteggioMazziere)
                        .append(" vs ")
                        .append(punteggioAltro)
                        .append(")\n");
            }
            else {
                text.append(mazziere.getNome())
                        .append(" perde contro ")
                        .append(giocatore.getNome())
                        .append(" (")
                        .append(punteggioMazziere)
                        .append(" vs ")
                        .append(punteggioAltro)
                        .append(")\n");
            }
        }

        JOptionPane.showMessageDialog(null, text.toString());
    }


    public Giocatore getMazziere(){
        for (Giocatore g : turnManager.getGiocatori()){
            if (g.isMazziere())
                return g;
        }
        return null;
    }


    public void resettaMano(){
        for (Giocatore g : turnManager.getGiocatori()){
            g.svuotaMano();
        }

    }

    public TurnManager getTurnManager(){
        return this.turnManager;
    }

    public void onPesca() {
        Giocatore giocatore = getTurnManager().getGiocatoreCorrente();
        if (!giocatore.isOut())
            giocatore.addCarta(Mazzo.daiCarta());
        else
            JOptionPane.showMessageDialog(null,giocatore.getNome() + " ha sballato");
        this.getTurnManager().notifyObservers();
        System.out.println(giocatore.getMano());
    }

    public void onPassa() {
        try {
            getTurnManager().nextTurn();
        }
        catch (IndexOutOfBoundsException e) {
            getTurnManager().resetTurni();
            calcoloVincitore();
            resettaMano();
            getTurnManager().notifyObservers();
        }
    }

    public void onPunta() {
        Giocatore giocatore = getTurnManager().getGiocatoreCorrente();
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
        this.getTurnManager().notifyObservers();
    }
}
