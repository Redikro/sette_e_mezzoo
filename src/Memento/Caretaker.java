package Memento;

import java.util.ArrayList;
import java.util.List;


public class Caretaker {
    private final List<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento m) {
        mementos.add(m);
    }

    public Memento getLastMemento() {
        if (mementos.isEmpty()) return null;
        return mementos.getLast();
    }
}
