package Mazzo;

import javax.swing.*;

/**
 * Una carta ha un seme e un valore
 */
public class Carta {
    private final Seme seme;
    private final Valore valore;

    public Carta(Seme seme, Valore valore) {
        this.seme = seme;
        this.valore = valore;
    }

    // get seme e valore
    public float getRealVal(){
        return valore.getRealVal();
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