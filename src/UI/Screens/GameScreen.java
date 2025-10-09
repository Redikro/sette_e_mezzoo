package UI.Screens;

import javax.swing.*;

import UI.*;
import UI.Component.TablePanel;

public class GameScreen implements Screen {
    private final GameManager gameManager =  new GameManager();
    private final TablePanel panel = new TablePanel(gameManager);

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public void onShow() {}
}
