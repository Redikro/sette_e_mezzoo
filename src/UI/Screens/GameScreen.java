package UI.Screens;

import javax.swing.*;

import java.awt.*;
import UI.*;
import UI.Component.*;


public class GameScreen implements Screen {
    private final JPanel panel;
    private final TablePanel table;
    private final PlayerControlsPanel controls;
    private final GameManager controller;

    public GameScreen(MainFrame frame) {
        panel = new JPanel(new BorderLayout());
        table = new TablePanel();
        controller = new GameManager(this);
        controls = new PlayerControlsPanel(controller);

        panel.add(table, BorderLayout.CENTER);
        panel.add(controls, BorderLayout.SOUTH);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void onShow() {}

    public TablePanel getTablePanel() {
        return table;
    }
}
