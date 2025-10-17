package Memento;

import java.io.*;

public class FileManager {
    public static void salvaSuFile(GameMemento memento, File file) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(memento);
        }
    }

    public static GameMemento caricaDaFile(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (GameMemento) ois.readObject();
        }
    }
}
