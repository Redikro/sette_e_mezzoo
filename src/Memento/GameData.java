package Memento;

import Mazzo.Carta;
import Observer.Giocatore;

import java.io.Serial;
import java.util.List;
import java.io.Serializable;

public class GameData implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private List<Giocatore> giocatore;
    private List<Carta> mazzo;

    public GameData(List<Giocatore> giocatori,List<Carta> mazzo) {
        this.giocatore = giocatori;
        this.mazzo = mazzo;
    }

    public List<Giocatore> getGiocatore() {
        return giocatore;
    }

    public List<Carta> getMazzo() {
        return mazzo;
    }
}
