package Factory_method;

public abstract class Card {
    private int seme;
    int valore; //da aggiungere immagine

    public abstract int getSeme();
    public abstract int getValore();
    public abstract void setSeme(int seme);
    public abstract void setValore(int valore);
}