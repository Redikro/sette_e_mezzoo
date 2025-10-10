package UI.Component;

import UI.ImageObject;

import javax.swing.*;
import java.awt.*;

public class CenterArea extends JPanel {
    public CenterArea() {
        setLayout(null);
        setOpaque(false);
        setPreferredSize(new Dimension(400, 250));

    //Se vogliamo una carta al centro

        //carte scalabili
        /*ImageObject carta1 = new ImageObject("out/immagini/png_carte/bastoni7.png", 100, 200);
        carta1.setScale(0.4);
        ImageObject carta2 = new ImageObject("out/immagini/png_carte/coppe1.png", 200, 60);
        carta2.setScale(0.4);*/

        //carte con JLabel
        /*JLabel carta1 = new JLabel(new ImageIcon("out/immagini/png_carte/bastoni7.png"));
        JLabel carta2 = new JLabel(new ImageIcon("out/immagini/png_carte/coppe1.png"));
        carta1.setBounds(100, 60, 80, 120);
        carta2.setBounds(200, 60, 80, 120);*/

        // Mazzo con JLabeò
        /*JLabel mazzo = new JLabel(new ImageIcon("out/immagini/png_carte/retro.png"));
        mazzo.setBounds(150, 180, 200, 200);*/

        //Mazzo scalabile
        ImageObject mazzo = new ImageObject("out/immagini/png_carte/retro.png", 80, 20);
        mazzo.setScale(0.30);


        // Gettone
        JLabel gettone = new JLabel(new ImageIcon("out/png_carte/gettone.png"));
        gettone.setBounds(320, 100, 40, 40);

        //add(carta1);
        //add(carta2);
        add(mazzo);
        add(gettone);
    }
}