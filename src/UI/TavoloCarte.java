package UI;

import javax.swing.*;
import java.awt.*;

public class TavoloCarte extends JFrame {

    public TavoloCarte() {
        setTitle("Tavolo da Carte");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new GridLayout(3, 3));

        // Celle vuote o con i giocatori
        add(new JPanel()); // (0,0)
        add(new GiocatoreLabel("Giocatore 3", 180)); // sopra
        add(new JPanel()); // (0,2)

        add(new GiocatoreLabel("Giocatore 2", 90)); // sinistra
        add(new JPanel()); // centro tavolo
        add(new GiocatoreLabel("Giocatore 4", 270)); // destra

        add(new JPanel()); // (2,0)
        add(new GiocatoreLabel("Giocatore 1", 0)); // sotto
        add(new JPanel()); // (2,2)
        setVisible(true);
    }

    public static void main(String[] args) {
        new TavoloCarte();
    }
}
