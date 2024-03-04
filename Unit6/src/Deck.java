import java.util.List;
import java.util.Random;
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
    public void shuffle() {
    Random rand = new Random();
    int n = deck.size();
    
    for (int i = n - 1; i > 0; i--) {
        // Generate a random index j such that 0 <= j <= i
        int j = rand.nextInt(i + 1);
        
        // Swap the elements at indices i and j
        Card temp = deck.get(i);
        deck.set(i, deck.get(j));
        deck.set(j, temp);
    }
}
    
    // public void shuffle() {
    //     for (int i = 0; i < 1000; i++) {
    //         Card randCard = deck.remove((int) (Math.random() * deck.size()));
    //         deck.add(randCard);
    //     }
    // }
    public void returnToDeck(List<Card> cards){
        this.deck.addAll(cards);
    }
    public void clearDeck(){
        this.deck.clear();
    }
}

