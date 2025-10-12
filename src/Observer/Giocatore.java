package Observer;

import Mazzo.Carta;
import java.util.ArrayList;
import java.util.List;

public class Giocatore implements TurnObserver {
    private final String nome;
    private final List<Carta> mano = new ArrayList<>();
    private int gettoni;
    private int puntata = 0;
    private int punteggio = 0;
    private final boolean mazziere;

    public boolean isMazziere() {
        return mazziere;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public int getPunteggio(){
        return this.punteggio;
    }

    public int getGettoni() {
        return gettoni;
    }

    public Giocatore(String nome,int gettoni,boolean mazziere) {
        this.mazziere = mazziere;
        this.nome = nome;
        this.gettoni = gettoni;
    }

    public List<Carta> getMano() {
        return mano;
    }

    public float getPunteggioCarte(){
        float punteggio = 0;
        for(Carta c : mano){
            punteggio += c.getRealVal();
        }
        return punteggio;
    }

    public boolean punta(int puntata){
        if (this.puntata + puntata <= this.getGettoni()) {
            this.puntata += puntata;
            this.gettoni -= puntata;
            return true;
        }
        return false;
    }

    public int getPuntata(){
        return this.puntata;
    }

    public String getNome() {
        return this.nome;
    }

    /**
     * Notifica il turno del giocatore corrente
     * @param currentPlayer il giocatore corrente
     */
    @Override
    public void onTurnChanged(Giocatore currentPlayer) {
        if (this == currentPlayer) {
            System.out.println("\n👉 È il turno di " + this.nome);
        }
    }
}
