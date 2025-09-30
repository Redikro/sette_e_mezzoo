package Observer;

import Mazzo.Mazzo;

import java.util.ArrayList;
import java.util.List;


public class TurnManager implements TurnSubject {
    private final List<TurnObserver> observers = new ArrayList<>(4);
    private final List<Giocatore> giocatore = new ArrayList<>(4);
    private int index = 0;
    private int puntata = 0;
    public void aggiungiGiocatore(Giocatore giocatore) {
        this.giocatore.add(giocatore);
        addObserver(giocatore);
    }


        public void nextTurn() {
        if (giocatore.get(index).getNome() == "") {
            nextTurn();
        }
            index = (index + 1) % observers.size();
            notifyObservers();
            }


    public Giocatore getGiocatoreCorrente() {
        return giocatore.get(index);
    }

    public static Mazzo getMazzo(){
        return Mazzo.getInstance();
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
     * notifica tutti gli osservatori che lo stato è cambiato
     */
    @Override
    public void notifyObservers() {
        Giocatore corrente = getGiocatoreCorrente();
        for (TurnObserver observer : observers) {
                observer.onTurnChanged(corrente);
        }
    }
}
