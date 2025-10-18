package UI.Component;

import UI.Panels.ImageObject;

import javax.swing.*;
import java.awt.*;

public class CenterArea extends JPanel {
    public CenterArea() {
        setLayout(null);
        setOpaque(false);
        setPreferredSize(new Dimension(400, 250));

        //Mazzo.Mazzo scalabile
        ImageObject mazzo = new ImageObject("out/immagini/png_carte/retro.png", 120, 20);
        mazzo.setScale(0.30);

        add(mazzo);

    }
}