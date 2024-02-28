import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BlackjackPanel extends JPanel implements KeyListener {

    BlackjackPlayer p1;
    BlackjackPlayer dealer;
    Deck deck;
    char userInput;
    String state;
    final int LEFT_OF_ORGIN = 100;
    int fps = 10;
    BufferedImage background;
    int playerScore;
    int dealerScore;

    public BlackjackPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setBackground(new Color(18, 130, 70));
        String filename = "Unit6/images/background.jpg";
        try {
            background = ImageIO.read(new File(filename));
        } catch (IOException e) {
            background = null;
            System.out.println(e + " file: " + filename);
        }
        deck = new Deck();
        userInput = 0;
        state = "READY";
        p1 = new BlackjackPlayer("Player 1");
        dealer = new BlackjackPlayer("Dealer");
        

        // TODO remove these test lines after testing
       

        addKeyListener(this);

        // add KeyListener / MouseListener here
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw background BufferedImage here
        // draw foreground objects here
        // TODO display all cards in the hands neatly on the panel
        // g.drawImage(imageObject, x, y, w, h, null);
        int x = LEFT_OF_ORGIN;
        int offset = 130;
        g.drawImage(background, 0, 0, null);
        for (Card c : p1.getHand()) {
            g.drawImage(c.getFace(), x, 400, 128, 176, null);
            x += offset;
        }
        x = LEFT_OF_ORGIN;
        for (Card c : dealer.getHand()) {
            g.drawImage(c.getFace(), x, 20, 128, 176, null);
            x += offset;
        }

    }

    public void run() {
        while (true) {
            update(); // implement state machine in update
            repaint();
            delay(1000 / fps);
        }
    }

    public void update() {
        if (state.equals("READY")) {
            // do nothing - wait on user
            if (userInput == ' ') {
                deck.shuffle();
                state = "DEALING";
                userInput = 0;
            }
        } else if (state.equals("DEALING")) {
            p1.take(deck.deal());
            p1.take(deck.deal());
            dealer.take(deck.deal());
            // auto transition
            state = "PLAYER1";

        } else if (state.equals("PLAYER1")) {
            if (userInput == 's') {
                state = "DEALERSTURN";
                userInput = 0;
            }
            if (userInput == 'h') {
                p1.take(deck.deal());
                userInput = 0;
            }
            if (p1.getScore() > 21) {
                state = "SHOW";
            }
        } else if (state.equals("DEALERSTURN")) {
            while (dealer.getScore() <= 17) {
                dealer.take(deck.deal());
            }
            state = "SHOW";
        } else if (state.equals("SHOW")) {

            if (dealer.getScore() == p1.getScore() || (p1.getScore() > 21 && dealer.getScore() > 21)) {
                System.out.println("Wash");
            } else if (p1.getScore() > 21 || (dealer.getScore() > p1.getScore() && dealer.getScore() <= 21)) {
                p1.setLosses(p1.getLosses() + 1);
                System.out.println("Dealer wins");
            } else if ((dealer.getScore() < p1.getScore() && p1.getScore() <= 21)
                    || dealer.getScore() > 21 && p1.getScore() <= 21) {
                p1.setWins(p1.getWins() + 1);
                System.out.println("Player wins");
            } else {
                throw new RuntimeException("Unable to score");
            }
            state = "DISCARD";
        } else if (state.equals("DISCARD")) {
            deck.returnToDeck(p1.fold());
            deck.returnToDeck(dealer.fold());
            state = "READY";
            System.out.println("Player 1 wins: " + p1.getWins());
            System.out.println("Player 1 losses: " + p1.getLosses());

        } else {
            throw new RuntimeException("Undefined state: " + state);
        }
    }

    public void delay(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        userInput = e.getKeyChar();
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
