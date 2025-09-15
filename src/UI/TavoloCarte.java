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

    // JLabel personalizzato che ruota il testo
    static class GiocatoreLabel extends JPanel {
        private final String nome;
        private final int angolo; // gradi di rotazione

        public GiocatoreLabel(String nome, int angolo) {
            this.nome = nome;
            this.angolo = angolo;
            setPreferredSize(new Dimension(100, 100));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            // Centro del pannello
            int cx = getWidth() / 2;
            int cy = getHeight() / 2;

            // Rotazione
            g2d.rotate(Math.toRadians(angolo), cx, cy);

            // Disegno testo centrato
            FontMetrics fm = g2d.getFontMetrics();
            int textWidth = fm.stringWidth(nome);
            int textHeight = fm.getAscent();
            g2d.drawString(nome, cx - textWidth / 2, cy + textHeight / 2);

            g2d.dispose();
        }
    }

    public static void main(String[] args) {
        new TavoloCarte();
    }
}
