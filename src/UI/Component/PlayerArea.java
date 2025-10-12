package UI.Component;

import Observer.Giocatore;
import Observer.TurnObserver;

import javax.swing.*;
import java.awt.*;

public class PlayerArea extends JPanel implements TurnObserver {
    private final Giocatore giocatore;
    private final JLabel punteggioTotale,punteggioMano,gettoni,puntata;

    public PlayerArea(Giocatore giocatore) {
        this.giocatore = giocatore;

        setLayout(new BorderLayout());
        setOpaque(true);
        setBackground(new Color(0, 60, 0)); // verde da tavolo
        setBorder(BorderFactory.createLineBorder(Color.black, 3));

        // Nome del giocatore
        JLabel nomeGiocatore = new JLabel(giocatore.getNome(), SwingConstants.CENTER);
        nomeGiocatore.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        nomeGiocatore.setForeground(Color.WHITE);
        add(nomeGiocatore, BorderLayout.NORTH);

        // --- centro: carta + punteggi
        JPanel centro = new JPanel(new BorderLayout());
        centro.setOpaque(false);

        // usa ImageObject se vuoi
        JLabel immagineCarta = new JLabel(new ImageIcon("out/immagini/png_carte/bastoni1.png"));
        immagineCarta.setPreferredSize(new Dimension(80, 110));
        immagineCarta.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        centro.add(immagineCarta, BorderLayout.WEST);

        JPanel punteggiPanel = new JPanel();
        punteggiPanel.setOpaque(false);
        punteggiPanel.setLayout(new BoxLayout(punteggiPanel, BoxLayout.Y_AXIS));

        punteggioTotale = new JLabel("Punteggio totale: " + giocatore.getPunteggio());
        punteggioTotale.setForeground(Color.YELLOW);
        punteggioMano = new JLabel("Punteggio carte: " + giocatore.getPunteggioCarte());
        punteggioMano.setForeground(Color.ORANGE);
        puntata = new JLabel("Puntata corrente: " + giocatore.getPuntata());
        puntata.setForeground(Color.ORANGE);


        punteggiPanel.add(punteggioTotale);
        punteggiPanel.add(Box.createVerticalStrut(5));
        punteggiPanel.add(punteggioMano);
        punteggiPanel.add(Box.createVerticalStrut(5));
        punteggiPanel.add(puntata);
        centro.add(punteggiPanel, BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);

        // Info in basso
        JPanel info = new JPanel(new GridLayout(1, 2));
        gettoni = new JLabel("Gettoni: " + giocatore.getGettoni(), SwingConstants.CENTER);
        info.setOpaque(false);
        info.add(gettoni);
        info.add(new JLabel("Mazziere: " + (giocatore.isMazziere() ? "Sì" : "No"), SwingConstants.CENTER));
        add(info, BorderLayout.SOUTH);
    }

    @Override
    public void onTurnChanged(Giocatore corrente) {
        boolean mioTurno = (corrente == giocatore);

        // Evidenzia il giocatore corrente
        if (mioTurno) {
            setBackground(new Color(0, 120, 0)); // più chiaro
            setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
        } else {
            setBackground(new Color(0, 60, 0));
            setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        }

        // aggiorna i valori visivi del giocatore
        aggiornaDati();
        repaint();
    }

    public void aggiornaDati() {
        puntata.setText("Puntata: " + giocatore.getPuntata());
        gettoni.setText("Gettoni: " + giocatore.getGettoni());
        punteggioTotale.setText("Punteggio totale: " + giocatore.getPunteggio());
        punteggioMano.setText("Punteggio carte: " + giocatore.getPunteggioCarte());
    }
}
