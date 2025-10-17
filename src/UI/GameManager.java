package UI;

import Mazzo.Mazzo;
import Observer.*;
import Strategy.*;
import UI.Screens.*;
import Strategy.Action;

import javax.swing.*;
import java.util.Objects;

public class GameManager {

    private final TurnManager turnManager = new TurnManager();
    private ActionStrategy strategy;
    private final Object cpuLock = new Object();

    public GameManager(String nome, int gettoni,String difficolta) {
        turnManager.aggiungiGiocatore(new Giocatore(nome, gettoni, true,difficolta)); // mazziere umano
        turnManager.aggiungiGiocatore(new Giocatore("CPU1", gettoni, false,difficolta));
        turnManager.aggiungiGiocatore(new Giocatore("CPU2", gettoni, false,difficolta));
        turnManager.aggiungiGiocatore(new Giocatore("CPU3", gettoni, false,difficolta));
        Mazzo.getInstance().mischiaCarte();
        setStrategy(difficolta);
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
                mazziere.setGettoni(giocatore.getPuntata());
            } else if (altroOut) {
                text.append(mazziere.getNome())
                        .append(" vince contro ")
                        .append(giocatore.getNome())
                        .append(" (")
                        .append(giocatore.getNome())
                        .append(" ha sballato)\n");
                mazziere.setGettoni(giocatore.getPuntata());
            } else if (mazziereOut) {
                text.append(mazziere.getNome())
                        .append(" perde contro ")
                        .append(giocatore.getNome())
                        .append(" (mazziere ha sballato)\n");
                giocatore.setGettoni(mazziere.getPuntata());
            } else if (punteggioMazziere >= punteggioAltro) {
                text.append(mazziere.getNome())
                        .append(" vince contro ")
                        .append(giocatore.getNome())
                        .append(" (")
                        .append(punteggioMazziere)
                        .append(" vs ")
                        .append(punteggioAltro)
                        .append(")\n");
                mazziere.setGettoni(giocatore.getPuntata());
            } else {
                text.append(mazziere.getNome())
                        .append(" perde contro ")
                        .append(giocatore.getNome())
                        .append(" (")
                        .append(punteggioMazziere)
                        .append(" vs ")
                        .append(punteggioAltro)
                        .append(")\n");
                giocatore.setGettoni(mazziere.getPuntata());
            }
        }

        JOptionPane.showMessageDialog(null, text.toString());
    }

    public Giocatore getMazziere() {
        for (Giocatore g : turnManager.getGiocatori()) {
            if (g.isMazziere())
                return g;
        }
        return null;
    }

    public void resettaMano() {
        for (Giocatore g : turnManager.getGiocatori()) {
            g.svuotaMano();
            g.resetPuntata();
        }
    }

    public TurnManager getTurnManager() {
        return this.turnManager;
    }

    public void onPesca() {
        Giocatore giocatore = getTurnManager().getGiocatoreCorrente();
        if (!giocatore.isOut())
            giocatore.addCarta(Mazzo.daiCarta());
        else
            JOptionPane.showMessageDialog(null, giocatore.getNome() + " ha sballato");
        this.getTurnManager().notifyObservers();
        System.out.println(giocatore.getMano());
    }

    public void onPassa() {
        try {
            getTurnManager().getGiocatoreCorrente().setPuntato(false);
            getTurnManager().nextTurn();
            eseguiTurnoCPU();
        } catch (IndexOutOfBoundsException e) {
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
                JOptionPane.showMessageDialog(null, "Non hai abbastanza gettoni");
        }
        this.getTurnManager().notifyObservers();
    }



    /**
     *Stabilisce la modalità.
     */
    public void setStrategy(String strategy) {
    if (Objects.equals(strategy, "Difficile"))
        this.strategy = new CPUDifficile();
    else
        this.strategy = new CPU();
    }

    /**
     * Fa eseguire automaticamente il turno alle CPU.
     */
    public void eseguiTurnoCPU() {
        Giocatore corrente = getTurnManager().getGiocatoreCorrente();
        if (!corrente.isMazziere()) {
            new Thread(() -> {
                synchronized (cpuLock) {
                    try {
                        System.out.println(corrente.getNome() + " sta pensando...");
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }

                    System.out.println(corrente.getNome() + " ha puntato " +  corrente.haPuntato());
                    if (!corrente.haPuntato()) {
                        System.out.println(corrente.getNome() + "Sto puntando...");
                        corrente.punta(strategy.puntaGettoni(corrente, getTurnManager().getGiocatori()));
                        corrente.setPuntato(true);

                    }
                Action action = strategy.chooseAction(corrente);
                System.out.println(corrente.getNome() + " sceglie " + action);

                switch (action) {
                    case PESCA -> {
                        onPesca();
                        if (!corrente.isOut()) {
                            eseguiTurnoCPU();
                        } else {
                            onPassa();
                        }
                    }
                    case PASSA -> {
                        corrente.setPuntato(false);
                        System.out.println(corrente.getNome() + "Ho finito il turno ho puntato = " +  corrente.haPuntato());
                        onPassa();
                    }
                }
              }
            }).start();
        }
    }
}
