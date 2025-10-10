package UI;

import UI.Screens.*;

public class GameManager {
    private final GameScreen gameScreen;

    public GameManager(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public void onPesca() {
        System.out.println("Giocatore pesca una carta");
        // TODO: aggiungi logica pesca
    }

    public void onPassa() {
        System.out.println("Giocatore passa il turno");
        // TODO: logica passa
    }

    public void onPunta() {
        System.out.println("Giocatore effettua una puntata");
        // TODO: mostra finestra input puntata
    }
}
