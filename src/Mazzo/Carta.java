package Mazzo;

import javax.swing.*;

/**
 * Una carta ha un seme e un valore
 */
public class Carta {
    private final Seme seme;
    private final Valore valore; //da aggiungere immagine
    private final ImageIcon immaginecarta;

    public Carta(Seme seme, Valore valore) {
        this.seme = seme;
        this.valore = valore;
        this.immaginecarta = caricaImmagine();
    }

    public ImageIcon ottieniCarta() {
        return immaginecarta;
    }

    /**
     * @throws NullPointerException se l'immagine della carta non è stata trovata
     * @return l'immagine della carta corrispondente
     */
    private ImageIcon caricaImmagine() {
        String path = "out/png_carte" + this.seme.toString()+this.valore.toString();
        ImageIcon immaginecarta = new ImageIcon(path);
        if (immaginecarta == null) {
            throw new NullPointerException("Immagine non esiste");
        }
        return immaginecarta;
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

        if (!(o instanceof Carta c))
            return false;

        return seme == c.seme && valore == c.valore;
    }

}