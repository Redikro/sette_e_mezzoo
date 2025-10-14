package UI.Panels;

import UI.GameManager;

import javax.swing.*;
import java.awt.*;

public class PlayerControlsPanel extends JPanel {
    private final JButton pescaBtn;
    private final JButton passaBtn;
    private final JButton puntaBtn;

    public PlayerControlsPanel(GameManager controller) {
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        setOpaque(false);

        pescaBtn = new JButton("Pesca");
        passaBtn = new JButton("Passa");
        puntaBtn = new JButton("Punta");
        JButton exitBtn = new JButton("Esci");

        // Azioni collegate al controller
        pescaBtn.addActionListener(_ -> controller.onPesca());
        passaBtn.addActionListener(_ -> controller.onPassa());
        puntaBtn.addActionListener(_ -> {
           controller.onPunta(controller.getTurnManager().getGiocatoreCorrente());
           controller.getTurnManager().notifyObservers();
        });
        exitBtn.addActionListener(_ -> System.exit(0));

        add(puntaBtn);
        add(pescaBtn);
        add(passaBtn);
        add(exitBtn);
    }

    // Opzionale: puoi disattivare i bottoni in base al turno
    public void setEnabledControls(boolean enabled) {
        pescaBtn.setEnabled(enabled);
        passaBtn.setEnabled(enabled);
        puntaBtn.setEnabled(enabled);
    }
}
