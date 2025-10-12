package Strategy;

import Observer.Giocatore;

import java.util.ArrayList;

public class CPU implements ActionStrategy {

    @Override
    public int puntaGettoni(Giocatore cpu, ArrayList<Giocatore> giocatori){
        int somma = 0, indexCPU = giocatori.indexOf(cpu);
        for(int i = 0; i < indexCPU; i++){
            Giocatore g = giocatori.get(i);
            somma += g.getPuntata();
        }
        return somma == 0 ? 3 : somma/indexCPU;
    }
    @Override
    public Action chooseAction(Giocatore giocatore) {
        return giocatore.getPunteggioCarte() >= 5 ? Action.PASSA : Action.PESCA;
    }
}
