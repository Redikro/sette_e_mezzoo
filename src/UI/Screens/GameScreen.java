package UI.Screens;

import javax.swing.*;

import java.awt.*;

import Observer.TurnManager;
import UI.*;
import UI.Component.*;
import UI.Panels.PlayerControlsPanel;


public class GameScreen implements Screen {
    private final JPanel panel;
    private final TablePanel table;
    private final PlayerControlsPanel controls;
    private final GameManager controller;

    public GameScreen(String nome,int gettoni) {
        panel = new JPanel(new BorderLayout());
        controller = new GameManager(nome,20);
        table = new TablePanel(controller);

        controls = new PlayerControlsPanel(controller);

        panel.add(table, BorderLayout.CENTER);
        panel.add(controls, BorderLayout.SOUTH);
    }

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void onShow() {

    }

}
