package UI;

import javax.swing.*;
import java.awt.*;

public class PlayerControlsPanel extends JPanel {
    private JButton pescaBtn;
    private JButton passaBtn;
    private JButton puntaBtn;

    public PlayerControlsPanel(GameManager controller) {
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        setOpaque(false);

        pescaBtn = new JButton("Pesca");
        passaBtn = new JButton("Passa");
        puntaBtn = new JButton("Punta");

        // Azioni collegate al controller
        pescaBtn.addActionListener(e -> controller.onPesca());
        passaBtn.addActionListener(e -> controller.onPassa());
        puntaBtn.addActionListener(e -> controller.onPunta());

        add(puntaBtn);
        add(pescaBtn);
        add(passaBtn);
    }

    // Opzionale: puoi disattivare i bottoni in base al turno
    public void setEnabledControls(boolean enabled) {
        pescaBtn.setEnabled(enabled);
        passaBtn.setEnabled(enabled);
        puntaBtn.setEnabled(enabled);
    }
}
