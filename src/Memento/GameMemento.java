package Memento;

import Mazzo.Carta;
import Observer.Giocatore;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameMemento implements Memento, Serializable {
    @Serial
    private static final long serialVersionUID = 5L;
    private final List<Giocatore> giocatori;
    private final List<Carta> mazzo;

    public GameMemento(List<Giocatore> giocatori, List<Carta> mazzo) {
        // Creiamo copie "profondamente immutabili" per sicurezza
        this.giocatori = new ArrayList<>();
        for (Giocatore g : giocatori) {
            Giocatore copia = new Giocatore(g.getNome(), g.getGettoni(), g.isMazziere());
            this.giocatori.add(copia);
            System.out.println(this.giocatori);
        }

        this.mazzo = new ArrayList<>(mazzo);

    }

    public List<Giocatore> getGiocatori() {
        List<Giocatore> copia = new ArrayList<>();
        for (Giocatore g : giocatori) {
            Giocatore nuovo = new Giocatore(g.getNome(), g.getGettoni(), g.isMazziere());
            copia.add(nuovo);
        }
        return copia;
    }

    public List<Carta> getMazzo() {
        return new ArrayList<>(mazzo);
    }

    @Override
    public GameData restoreState() {
        return new GameData(getGiocatori(),getMazzo());
    }
}

