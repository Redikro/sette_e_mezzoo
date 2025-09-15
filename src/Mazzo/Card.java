package Mazzo;

public class Card {
    private Seme seme;
    private Valore valore; //da aggiungere immagine

    public Seme getSeme();
    public Valore getValore();
    public void setSeme(Seme seme);
    public void setValore(Valore valore);

    @Override
    public String toString()
    {
        return valore.toString() + " " + seme.toString();
    }
}