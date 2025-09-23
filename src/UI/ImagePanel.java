package UI;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private static final Image image = new ImageIcon();

    public static ImagePanel(String img, int width, int height) {
        image = new ImageIcon(img).getImage();
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(),getHeight(), this);
    }
}
