import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
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
    List<Card> discardPile;
    String playerString;
    String dealerString;
    String winnerString;

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
        discardPile = new ArrayList<Card>();
        deck = new Deck();
        userInput = 0;
        state = "READY";
        p1 = new BlackjackPlayer("Player 1");
        dealer = new BlackjackPlayer("Dealer");
       

        addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
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
        Font font = new Font("Verdana", Font.BOLD, 40);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString(dealerString, 20, 50);
        g.drawString(playerString, 20, 550);
        g.drawString(winnerString, 400, 300);

    }

    public void run() {
        while (true) {
            update();
            repaint();
            delay(1000 / fps);
        }
    }

    public void update() {
        final int ADD_TO_DECK = 15;
        final int DEALER_LIMIT = 17;
        final int TARGET_SCORE = 21;
        dealerString = "" + dealer.getScore();
        playerString = "" + p1.getScore();
        winnerString = "";
        if (state.equals("READY")) {
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
            if (p1.getScore() > TARGET_SCORE) {
                state = "SHOW";
            }
        } else if (state.equals("DEALERSTURN")) {
            while (dealer.getScore() <= DEALER_LIMIT) {
                dealer.take(deck.deal());
            }
            state = "SHOW";
        } else if (state.equals("SHOW")) {

            int playerScore = p1.getScore();
            int dealerScore = dealer.getScore();

            if (playerScore > TARGET_SCORE || dealerScore <= TARGET_SCORE && dealerScore > playerScore) {
                winnerString = "Dealer wins";
            } else if (dealerScore > TARGET_SCORE || playerScore > dealerScore) {
                winnerString = "Player wins";
            } else if (playerScore == dealerScore) {
                winnerString = "Push";
            } else {
                throw new RuntimeException("Unable to score");
            }
            if (userInput == 'r') {
                state = "DISCARD";
                userInput = 0;
            }
        } else if (state.equals("DISCARD")) {
            discardPile.addAll(p1.fold());
            discardPile.addAll(dealer.fold());
            if(discardPile.size() > ADD_TO_DECK){
                deck.returnToDeck(discardPile);
                deck.shuffle();
            }
            
            state = "READY";

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
