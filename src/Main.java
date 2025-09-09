import UI.Nuova_partita;

import javax.swing.*;
import java.awt.*;
import UI.*;

public class Main extends JFrame {
    JButton button = new JButton("Nuova partita");
    public Main() {
        button.addActionListener(_ -> {
            new Nuova_partita();
        });
        add(button);
        setTitle("Sette e Mezzo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(730, 540);
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}