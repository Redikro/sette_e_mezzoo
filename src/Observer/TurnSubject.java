package Observer;

public interface TurnSubject {
    void addObserver(TurnObserver observer);
    void removeObserver(TurnObserver observer);
    void notifyObservers();
}
