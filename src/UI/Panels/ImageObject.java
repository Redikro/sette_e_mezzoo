package UI.Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageObject extends JLabel {
    private BufferedImage originalImage;
    private Image scaledImage;

    public ImageObject(String imagePath, int x, int y) {
        setOpaque(false);
        loadImage(imagePath);
        setPosition(x, y);
    }

    private void loadImage(String path) {
        try {
            originalImage = javax.imageio.ImageIO.read(new java.io.File(path));
            scaledImage = originalImage;
            setIcon(new ImageIcon(scaledImage));
            setSize(originalImage.getWidth(), originalImage.getHeight());
        } catch (Exception e) {
            System.err.println("Errore caricamento immagine: " + path);
        }
    }


    public void setPosition(int x, int y) {
        setLocation(x, y);
    }


    public void setScale(double factor) {
        if (originalImage == null) return;
        int newW = (int) (originalImage.getWidth() * factor);
        int newH = (int) (originalImage.getHeight() * factor);
        scaledImage = originalImage.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        setIcon(new ImageIcon(scaledImage));
        setSize(newW, newH);
    }
}

