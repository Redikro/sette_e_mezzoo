package UI.Component;

import UI.GameManager;

import javax.swing.*;
import java.awt.*;

public class TablePanel extends JPanel {
    private final Image bg = new ImageIcon("out/immagini/background/sfondo.png").getImage();

    private final CenterArea centerArea;
    private final PlayerArea playerArea;
    private final PlayerArea cpu1Area;
    private final PlayerArea cpu2Area;
    private final PlayerArea cpu3Area;

    public TablePanel() {
        setLayout(null);
        setPreferredSize(new Dimension(1152, 768));

        // Aree dei giocatori
        playerArea = new PlayerArea("GIOCATORE");
        cpu1Area = new PlayerArea("CPU 1");
        cpu2Area = new PlayerArea("CPU 2");
        cpu3Area = new PlayerArea("CPU 3");

        // Area centrale
        centerArea = new CenterArea();

        // Posizionamento
        addComponent(playerArea, 480, 680);
        addComponent(cpu1Area, 480, 20);
        addComponent(cpu2Area, 940, 340);
        addComponent(cpu3Area, 40, 340);
        addComponent(centerArea, 376, 250);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }

    private void addComponent(JComponent comp, int x, int y) {
        comp.setBounds(x, y, comp.getPreferredSize().width, comp.getPreferredSize().height);
        add(comp);
    }

    public CenterArea getCenterArea() {
        return centerArea;
    }

    public PlayerArea getPlayerArea() {
        return playerArea;
    }

    public PlayerArea getCpu1Area() {
        return cpu1Area;
    }

    public PlayerArea getCpu2Area() {
        return cpu2Area;
    }

    public PlayerArea getCpu3Area() {
        return cpu3Area;
    }
}
