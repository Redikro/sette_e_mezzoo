package Observer;

import Mazzo.Carta;
import java.util.ArrayList;
import java.util.List;

public class Giocatore implements TurnObserver {
    private final String nome;
    private final List<Carta> mano = new ArrayList<>();
    private double punteggio = 0;
    private boolean fermo = false;

    public Giocatore(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public double getPunteggio() {
        return punteggio;
    }

    public boolean isFermo() {
        return fermo;
    }


    /**
     * Notifica il turno del giocatore corrente
     * @param currentPlayer il giocatore corrente
     */
    @Override
    public void onTurnChanged(Giocatore currentPlayer) {
        if (this == currentPlayer) {
            System.out.println("\n👉 È il turno di " + nome);
        }
    }
}
