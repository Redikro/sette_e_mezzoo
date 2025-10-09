package UI.Component;

import UI.GameManager;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {
    private final Image bg = new ImageIcon("out/sfondo.png").getImage();

    public TablePanel(GameManager gameManager) {
        setLayout(null);
        setPreferredSize(new Dimension(1152, 768));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void doLayout() {
        super.doLayout();
        removeAll();

        int w = getWidth();
        int h = getHeight();

        // Titolo
        ImageIcon titoloImg = new ImageIcon("out/titolo.png");
        JLabel titolo = new JLabel(titoloImg);
        titolo.setHorizontalAlignment(SwingConstants.CENTER);

// Centra l'immagine nella parte alta del tavolo
        int imgW = titoloImg.getIconWidth();
        int imgH = titoloImg.getIconHeight();
        titolo.setBounds((w - imgW) / 2, h / 2 - 150, imgW, imgH);

        add(titolo);

        // Giocatori
        add(new PlayerArea("GIOCATORE"), w/2 - 100, h - 80);
        add(new PlayerArea("CPU 1"), w/2 - 100, 20);
        add(new PlayerArea("CPU 2"), w - 200, h/2 - 40);
        add(new PlayerArea("CPU 3"), 20, h/2 - 40);

        // Area centrale (carte e mazzo)
        CenterArea center = new CenterArea();
        center.setBounds(w/2 - 200, h/2 - 80, 400, 250);
        add(center);
    }

    private void add(JComponent comp, int x, int y) {
        comp.setBounds(x, y, comp.getPreferredSize().width, comp.getPreferredSize().height);
        add(comp);
    }
}
