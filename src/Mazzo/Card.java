package Mazzo;

public class Card {
    private final Seme seme;
    private final Valore valore; //da aggiungere immagine

    public Card(Seme seme, Valore valore) {
        this.seme = seme;
        this.valore = valore;
    }

    public Seme getSeme(){
        return seme;
    }
    public Valore getValore(){
        return valore;
    }

    @Override
    public String toString()
    {
        return valore.toString() + " " + seme.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Card c))
            return false;

        return seme == c.seme && valore == c.valore;
    }

}