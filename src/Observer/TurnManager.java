package Observer;


import java.util.ArrayList;
import java.util.List;

/**
 *  Da ora in poi usare solamente istanza in GameManager.
 *  Mai crearne una nuova.
 *  Se trovate eccezioni outofbounds al 99% avete creato e richiamato una istanza diversa.
 *  ex. GameManager.getTurnManager() restituisce istanza in uso di questa classe
 */
public class TurnManager implements TurnSubject {
    private final List<TurnObserver> observers = new ArrayList<>(4);
    private final List<Giocatore> giocatore = new ArrayList<>(4);
    private int index = 0;

    public void aggiungiGiocatore(Giocatore giocatore) {
        this.giocatore.add(giocatore);
        addObserver(giocatore);
    }

    public int getNumberOfPlayers(){
        return giocatore.size();
    }

    public int getIndex() {
        return this.index;
    }

    public void resetIndex() {
        this.index = 0;
    }

    public void resetTurni() {
        index = 0;                 // riparte dal primo giocatore
        notifyObservers();         // aggiorna subito tutti gli osservatori
        System.out.println("🔁 Turni resettati. Tocca a: " + getGiocatoreCorrente().getNome());
    }

    public void nextTurn() {
        if (giocatore.get(index).getNome().isEmpty()) {
            nextTurn();
        }
            index = (index + 1) % observers.size();
            notifyObservers();
    }

    public List<Giocatore> getGiocatori() {
        return this.giocatore;
    }

    public Giocatore getGiocatoreCorrente() {
        return giocatore.get(index);
    }

    /**
     *
     * @param observer aggiungi osservatore selezionato
     */
    @Override
    public void addObserver(TurnObserver observer) {
        observers.add(observer);
    }

    /**
     *
     * @param observer rimuove osservatore selezionato
     */
    @Override
    public void removeObserver(TurnObserver observer) {
        observers.remove(observer);
        giocatore.remove(observer);
    }

    /**
     * Notifica tutti gli osservatori che lo stato è cambiato
     */
    @Override
    public void notifyObservers() {
        Giocatore corrente = getGiocatoreCorrente();
        for (TurnObserver observer : observers) {
                observer.onTurnChanged(corrente);
        }
    }
}
