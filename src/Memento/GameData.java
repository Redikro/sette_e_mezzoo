package Memento;

import Mazzo.Carta;
import Observer.Giocatore;
import Strategy.ActionStrategy;

import java.io.Serial;
import java.util.List;
import java.io.Serializable;

public class GameData implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private List<Giocatore> giocatore;
    private List<Carta> mazzo;
    private String modalita;

    public GameData(List<Giocatore> giocatori,List<Carta> mazzo, String modalita) {
        this.giocatore = giocatori;
        this.mazzo = mazzo;
        this.modalita = modalita;
    }

    public String getModalita() {
        return this.modalita;
    }

    public List<Giocatore> getGiocatore() {
        return this.giocatore;
    }

    public List<Carta> getMazzo() {
        return this.mazzo;
    }
}
