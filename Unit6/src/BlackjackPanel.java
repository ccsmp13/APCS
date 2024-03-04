import java.util.List;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;
import javax.swing.JPanel;

public class BlackjackPanel extends JPanel {

    BlackjackPlayer p1;
    BlackjackPlayer dealer;
    Deck deck;
    char userInput;
    String state;
    final int LEFT_OF_ORGIN = 100;
    int fps = 10;
    int playerScore;
    int dealerScore;
    List<Card> discardPile;
    String playerString;
    String dealerString;
    String winnerString;
    int roundCount;

    public BlackjackPanel(int width, int height) {
        roundCount = 0;
        discardPile = new ArrayList<Card>();
        deck = new Deck();
        deck.shuffle();
        userInput = 0;
        state = "READY";
        p1 = new BlackjackPlayer("Player 1");
        dealer = new BlackjackPlayer("Dealer");

    }

    public void run() {
        while (roundCount <= 10000) {
            update();
        }
        System.exit(0);
    }

    public void update() {
        

            final int ADD_TO_DECK = 30;
            final int DEALER_LIMIT = 17;
            final int TARGET_SCORE = 21;
            if (state.equals("READY")) {

                state = "DEALING";

            } else if (state.equals("DEALING")) {
                p1.take(deck.deal());
                p1.take(deck.deal());
                dealer.take(deck.deal());

                // auto transition
                state = "PLAYER1";

            } else if (state.equals("PLAYER1")) {
                int dealerScore = dealer.getScore();

                if (p1.getScore() < 12) {
                    p1.take(deck.deal());
                } else if (p1.getScore() > 11 && dealerScore > 6 && p1.getScore() < 17){
                    p1.take(deck.deal());
                } else if (p1.getScore() == 12 && dealerScore < 4){
                    p1.take(deck.deal());
                } else if (p1.getScore() > 16){
                    state = "DEALERSTURN";
                } else if (p1.getScore() > 12 && p1.getScore() < 17 && dealerScore < 7){
                    state = "DEALERSTURN";
                } else if (p1.getScore() == 12 && (dealerScore == 4 || dealerScore == 5 || dealerScore == 6)){
                    state = "DEALERSTURN";
                }
                if (p1.getScore() > TARGET_SCORE) {
                    state = "SHOW";
                }

            } else if (state.equals("DEALERSTURN")) {
                while (dealer.getScore() < DEALER_LIMIT) {
                    dealer.take(deck.deal());
                }
                state = "SHOW";
            } else if (state.equals("SHOW")) {

                playerScore = p1.getScore();
                dealerScore = dealer.getScore();

                if (playerScore > TARGET_SCORE || dealerScore <= TARGET_SCORE && dealerScore > playerScore) {
                    p1.lose();
                } else if (dealerScore > TARGET_SCORE) {
                    p1.win();
                } else if ( playerScore > dealerScore){
                    if(p1.getHand().size() == 2 && p1.getScore() == 21){
                        //p1.bigWin();
                        //for 150% win black jack
                        p1.win();
                    } else {
                    p1.win();
                }
                } else if (playerScore == dealerScore) {

                } else {
                    throw new RuntimeException("Unable to score");
                }
                state = "DISCARD";
                
            } else if (state.equals("DISCARD")) {
                discardPile.addAll(p1.fold());
                discardPile.addAll(dealer.fold());
                if (discardPile.size() > ADD_TO_DECK) {
                    deck.returnToDeck(discardPile);
                    deck.shuffle();
                    discardPile.clear();
                }

                state = "READY";
                roundCount++;
                if (roundCount % 1000 == 0 || (roundCount % 5 == 0 && roundCount <= 10000)) {
                    double edge = (p1.getWins() - p1.getLosses()) / (double) roundCount;
                    System.out.println(edge);
                }
                
            } else {
                throw new RuntimeException("Undefined state: " + state);
            }
            
    }
}