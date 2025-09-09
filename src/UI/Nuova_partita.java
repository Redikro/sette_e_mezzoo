package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Nuova_partita extends JFrame {
    public Nuova_partita() {
        try{
            setIconImage(ImageIO.read(new File("out/png_carte/bastoni1.png")));
        }
        catch (IOException e){
            e.printStackTrace();
        };
        setTitle("Nuova Partita");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(730, 540);
        setResizable(true);
        setVisible(true);
    }
}
