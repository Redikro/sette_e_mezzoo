package UI;

import Mazzo.*;

import javax.swing.*;
import java.awt.*;

public class TavoloCarte extends JFrame {
    private final GiocatorePanel g1, g2, g3, g4;
    private JPanel actionPanel;
    private JButton drawButton,finishButton,putButton;
    private ImagePanel panel;

    public ImagePanel getImagePanel(Seme seme, Valore value) {
        panel = new ImagePanel("out/png_carte/" + seme + value + ".png",160,230);
        panel.setSize(new Dimension(panel.getWidth(), panel.getHeight()));
        return panel;
    }



    public TavoloCarte(String nome1,String nome2, String nome3, String nome4) {
        initializeFrame();
        // Creo pannelli giocatori
        g1 = new GiocatorePanel(nome1, 0);
        g2 = new GiocatorePanel(nome2, 90);
        g3 = new GiocatorePanel(nome3, 180);
        g4 = new GiocatorePanel(nome4, 270);

        setPanelsSettings();

        add(new JPanel()); add(g3); add(new JPanel());
        add(g2); add(new JPanel()); add(g4);
        add(new JPanel()); add(g1); add(new JPanel());

        drawButton = new JButton("Pesca");
        putButton = new JButton("Punta");
        finishButton = new JButton("Stai");

        final int[] puntata = new int[1];
        
        putButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(
                    null, // oppure TavoloCarte.this se sei dentro un JFrame
                    "Quanti gettoni vuoi puntare?",
                    "Punta",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (input != null) { // se non preme "Annulla"
                try {
                    puntata[0] = Integer.parseInt(input);
                    JOptionPane.showMessageDialog(
                            null,
                            "Hai puntato " + puntata[0] + " gettoni."
                    );
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Inserisci un numero intero valido!",
                            "Errore",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });


        g1.add(getImagePanel(Seme.BASTONI,Valore.ASSO));

        revalidate();
        repaint();

        setVisible(true);
    }


    private void initializeFrame(){
        setTitle("Tavolo di Gioco");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(new GridLayout(3, 3));
    }

    private void setPanelsSettings(){
        actionPanel.setOpaque(true);
        g1.setOpaque(true);
        g2.setOpaque(true);
        g3.setOpaque(true);
        g4.setOpaque(true);
        g1.setBorder(BorderFactory.createLineBorder(Color.RED,4));
        g2.setBorder(BorderFactory.createLineBorder(Color.RED,4));
        g3.setBorder(BorderFactory.createLineBorder(Color.RED,4));
        g4.setBorder(BorderFactory.createLineBorder(Color.RED,4));
    }
}
