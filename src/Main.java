import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import UI.*;

public class Main extends JFrame {
    JButton button = new JButton("Nuova partita");
    JPanel panel = new JPanel();
    public Main() {
        button.addActionListener(_ -> {
            new TavoloCarte();
            this.dispose();
        });
        try{
            setIconImage(ImageIO.read(new File("out/png_carte/bastoni1.png")));
        }
        catch (IOException e){
            e.printStackTrace();
        };
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new BorderLayout());
        panel.add(button, BorderLayout.SOUTH);
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