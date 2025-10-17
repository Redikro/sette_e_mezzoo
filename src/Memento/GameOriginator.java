package Memento;

public class GameOriginator {
    private GameData gameData;

    public void setState(GameData data) {
        this.gameData = data;
    }

    public GameMemento saveStateToMemento() {
        return new GameMemento(gameData.getGiocatore(),gameData.getMazzo());
    }

    public void restoreFrom(Memento memento) {
        if (memento instanceof GameMemento gm)
            this.gameData = gm.restoreState();
    }

    public GameData getGameData() {
        return this.gameData;
    }
}
