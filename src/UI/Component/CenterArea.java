package UI.Component;

import javax.swing.*;
import java.awt.*;

public class CenterArea extends JPanel {
    public CenterArea() {
        setLayout(null);
        setOpaque(false);
        setPreferredSize(new Dimension(400, 250));

        // Carte visibili
        JLabel carta1 = new JLabel(new ImageIcon("out/png_carte/7bastoni.png"));
        JLabel carta2 = new JLabel(new ImageIcon("out/png_carte/7fiori.png"));
        carta1.setBounds(100, 60, 80, 120);
        carta2.setBounds(200, 60, 80, 120);

        // Mazzo
        JLabel mazzo = new JLabel(new ImageIcon("out/png_carte/back.png"));
        mazzo.setBounds(150, 180, 80, 120);

        // Gettone
        JLabel gettone = new JLabel(new ImageIcon("out/png_carte/gettone.png"));
        gettone.setBounds(320, 100, 40, 40);

        add(carta1);
        add(carta2);
        add(mazzo);
        add(gettone);
    }
}