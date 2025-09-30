import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import UI.*;

public class Main extends JFrame {
    private JButton button = new JButton("Nuova partita");
    private JPanel panel = new JPanel();
    private JTextField nome1 = new JTextField();
    private JTextField nome2 = new JTextField();
    private JTextField nome3 = new JTextField();
    private JTextField nome4 = new JTextField();
    public Main() {
        button.addActionListener(_ -> {
            new TavoloCarte(nome1.getText(), nome2.getText(), nome3.getText(), nome4.getText());
            this.dispose();
        });
        try{
            setIconImage(ImageIO.read(new File("out/png_carte/bastoni1.png")));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        nome1.setToolTipText("Nome Giocatore 1");
        nome2.setToolTipText("Nome Giocatore 2");
        nome3.setToolTipText("Nome Giocatore 3");
        nome4.setToolTipText("Nome Giocatore 4");
        nome1.setColumns(20);
        nome2.setColumns(20);
        nome3.setColumns(20);
        nome4.setColumns(20);
        button.setFocusable(true);
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BorderLayout());
        panel.add(button, BorderLayout.CENTER);
        panel.add(nome1, BorderLayout.NORTH);
        panel.add(nome2, BorderLayout.SOUTH);
        panel.add(nome3, BorderLayout.EAST);
        panel.add(nome4, BorderLayout.WEST);


        add(panel);
        initializeFrame();
    }

    public void initializeFrame(){
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