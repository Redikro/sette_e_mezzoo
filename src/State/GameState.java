package State;
import Observer.Giocatore;

public interface GameState {
    void enterState();
    void onPesca(Giocatore giocatore);
    void onPassa(Giocatore giocatore);
    void onPunta(Giocatore giocatore);
}
