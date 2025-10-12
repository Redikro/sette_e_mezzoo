package State;
import Observer.Giocatore;
import UI.GameManager;

public interface GameState {
    void enterState();
    void onPesca(Giocatore giocatore);
    void onPassa(Giocatore giocatore);
    void onPunta(Giocatore giocatore);
}
