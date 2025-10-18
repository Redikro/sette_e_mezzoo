package Strategy;

import Observer.Giocatore;
import java.util.List;

public class CPUDifficile implements ActionStrategy {

    @Override
    public int puntaGettoni(Giocatore cpu, List<Giocatore> giocatori) {
        int base = (int) (cpu.getPunteggioCarte() * 2);
        return Math.min(cpu.getGettoni(), Math.max(3, base));
    }

    @Override
    public Action chooseAction(Giocatore giocatore) {
        float punteggio = giocatore.getPunteggioCarte();
        float distanza = 7.5f - punteggio;

        // se la distanza è > 2 → rischio basso → pesca
        if (distanza > 2.0f) return Action.PESCA;

        // se la distanza è tra 1 e 2 → pesca con probabilità 50%
        if (distanza > 1.0f && Math.random() < 0.5) return Action.PESCA;

        // altrimenti passa
        return Action.PASSA;
    }
}
