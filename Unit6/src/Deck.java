import java.util.List;
import java.util.ArrayList;

public class Deck {
    private List<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
        for (int s = 0; s < 4; s++) {
            for (int r = 1; r <= 13; r++) {
                deck.add(new Card(r,s));
                
            }
        }

    }
    public Card deal(){
        Card topCard = deck.remove(0);
        return topCard;
    }
    public int getCardsLeft(){
        return deck.size();
    }

    public String toString(){
        String result = "";
        for (Card c : deck){
            result += c;
            result += "\n";
        }
        return result;
    }
    public void shuffle(){
        for (int i = 0; i < 1000; i++) {
            Card randCard = deck.remove((int)(Math.random()*52));
            deck.add(randCard);
        }
    }
}

