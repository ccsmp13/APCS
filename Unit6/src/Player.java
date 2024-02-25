import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand;
    private String name;

    public Player(){
        hand = new ArrayList<Card>();
    }
    public Player(String s){
        name = s;
        hand = new ArrayList<Card>();
    }

    public void take(Card c){
        hand.add(c);
    }

    public List<Card> fold(){
        List<Card> foldedHand = hand;
        hand = new ArrayList<Card>();
        return foldedHand;
    }

    public int getScore(){
        return 0;
    }

    public String toString(){
        String res = "";
        for (Card card : hand) {
            res += card;
            res += "\n";
        }
        return res;
    }
    public List<Card> getHand() {
        return hand;
    }
    public String getName() {
        return name;
    }
    


}
