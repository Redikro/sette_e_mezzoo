package UI.Screens;

import UI.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TitleScreen implements Screen {
    private final JPanel panel;
    private final JButton startButton;

    public TitleScreen(MainFrame frame) {
        panel = new JPanel() {
            private final Image bg = new ImageIcon("out/sfondo.png").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        };



        panel.setLayout(new BorderLayout());

        // Titolo in alto
        JLabel titolo = new JLabel(new ImageIcon("out/titolo2.png"));
        titolo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titolo, BorderLayout.NORTH);

        // Bottone in basso
        startButton = new JButton("NUOVA PARTITA");
        startButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        startButton.setOpaque(false);
        startButton.addActionListener(_ -> frame.setScreen(new GameScreen()));

        JPanel bottom = new JPanel();
        bottom.setOpaque(false);
        bottom.add(startButton);
        panel.add(bottom, BorderLayout.CENTER);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void onShow() {}
}
