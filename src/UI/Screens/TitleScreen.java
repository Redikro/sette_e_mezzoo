package UI.Screens;

import UI.*;

import javax.swing.*;
import java.awt.*;


public class TitleScreen implements Screen {
    private final JPanel panel;

    public TitleScreen(MainFrame frame) {
        panel = new JPanel() {
            private final Image bg = new ImageIcon("out/immagini/background/sfondo.png").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
            }
        };



        panel.setLayout(new BorderLayout());

        // Titolo
        JLabel titolo = new JLabel(new ImageIcon("out/immagini/background/titolo2.png"));
        titolo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titolo, BorderLayout.NORTH);

        // Nuova partita
        JPanel bottom = getPanel(frame);
        panel.add(bottom, BorderLayout.CENTER);
    }

    private JPanel getPanel(MainFrame frame) {
        JButton startButton = new JButton("NUOVA PARTITA");
        startButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
        startButton.setOpaque(false);
        startButton.addActionListener(_ -> {
            String nome = JOptionPane.showInputDialog("Nome Giocatore");
            if(nome == null || nome.isEmpty()) {nome = "🚘";}
            String g = "";
            while (g.isEmpty() || Integer.parseInt(g) <= 0) {
                g = JOptionPane.showInputDialog("Inserisci Gettoni Giocatore");
            }
            int gettoni = Integer.parseInt(g);
            frame.setScreen(new GameScreen(nome,gettoni));
        });

        JPanel bottom = new JPanel();
        bottom.setOpaque(false);
        bottom.add(startButton);
        return bottom;
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void onShow() {}
}
