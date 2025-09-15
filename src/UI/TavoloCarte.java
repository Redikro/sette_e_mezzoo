package UI;

import javax.swing.*;
import java.awt.*;

public class TavoloCarte extends JFrame {
    private final GiocatorePanel g1, g2, g3, g4;

    public TavoloCarte(String nome1,String nome2, String nome3, String nome4) {
        setTitle("Tavolo da Carte");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(new GridLayout(3, 3));

        // Creo pannelli giocatori
        g1 = new GiocatorePanel(nome1, 0);
        g2 = new GiocatorePanel(nome2, 90);
        g3 = new GiocatorePanel(nome3, 180);
        g4 = new GiocatorePanel(nome4, 270);
        g1.setOpaque(true);
        g2.setOpaque(true);
        g3.setOpaque(true);
        g4.setOpaque(true);
        g1.setBorder(BorderFactory.createLineBorder(Color.RED,4));
        g2.setBorder(BorderFactory.createLineBorder(Color.RED,4));
        g3.setBorder(BorderFactory.createLineBorder(Color.RED,4));
        g4.setBorder(BorderFactory.createLineBorder(Color.RED,4));

        add(new JPanel()); add(g3); add(new JPanel());
        add(g2); add(new JPanel()); add(g4);
        add(new JPanel()); add(g1); add(new JPanel());

        g1.aggiungiCarta(new ImageIcon("out/png_carte/bastoni1.png"));
        g1.aggiungiCarta(new ImageIcon("out/png_carte/bastoni2.png"));

        revalidate();
        repaint();

        setVisible(true);
    }

}
