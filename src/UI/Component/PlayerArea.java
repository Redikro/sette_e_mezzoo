package UI.Component;

import javax.swing.*;
import java.awt.*;

public class PlayerArea extends JPanel {

    public PlayerArea(String nome) {
        setLayout(new BorderLayout());
        setOpaque(false);
        JLabel nomeGiocatore = new JLabel(nome, SwingConstants.CENTER);
        nomeGiocatore.setFont(new Font("Comic Sans", Font.BOLD, 16));
        nomeGiocatore.setForeground(Color.WHITE);
        add(nomeGiocatore, BorderLayout.CENTER);
        setPreferredSize(new Dimension(160, 40));
    }
}
