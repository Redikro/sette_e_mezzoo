package UI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GiocatorePanel extends JPanel {
    private final String nome;
    private final int angolo; // rotazione
    private final List<ImageIcon> carteInMano = new ArrayList<>();

    public GiocatorePanel(String nome, int angolo) {
        this.nome = nome;
        this.angolo = angolo;
        setPreferredSize(new Dimension(150, 150));
        setOpaque(false);
    }


    public void resetCarte() {
        carteInMano.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int cx = getWidth() / 2;
        int cy = getHeight() / 2;

        // Ruoto il contesto
        g2d.rotate(Math.toRadians(angolo), cx, cy);

        // Disegno nome
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(nome);
        g2d.drawString(nome, cx - textWidth / 2, cy - 40);

        // Disegno carte in mano (affiancate)
        int offsetX = -((carteInMano.size() - 1) * 20) / 2; // centratura
        for (int i = 0; i < carteInMano.size(); i++) {
            Image img = carteInMano.get(i).getImage().getScaledInstance(40, 70, Image.SCALE_SMOOTH);
            g2d.drawImage(img, cx + offsetX + i * 20, cy, this);
        }

        g2d.dispose();
    }
}
