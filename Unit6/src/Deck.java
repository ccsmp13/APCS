import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private List<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();
        for (int s = 0; s < 4; s++) {
            for (int r = 1; r <= 13; r++) {
                deck.add(new Card(r, s));

            }
        }

    }

    public Card deal() {
        Card topCard = deck.remove(0);
        return topCard;
    }

    public int getCardsLeft() {
        return deck.size();
    }

    public String toString() {
        String result = "";
        for (Card c : deck) {
            result += c;
            result += "\n";
        }
        return result;
    }

    public int linearSearch(Card target) {
        for (int i = 0; i < this.deck.size(); i++) {

            if (this.deck.get(i).compareTo(target) == 0) {
                return i;
            }
        }
        return -1;
    }
    
    public void bucketSort(){
        List<List<Card>> buckets = new ArrayList<List<Card>>();
        List<Card> sorted = new ArrayList<Card>();
        

        for (int i = 0; i < 14; i++) {
            buckets.add(new ArrayList<Card>());
        }
        for (Card c : this.deck) {
            buckets.get(c.getRank()).add(c);
        }
        for (int i = 0; i < buckets.size(); i++) {
            buckets.set(i , mergeSort(buckets.get(i)));
        }
        for (List<Card> bucket : buckets) {
            sorted.addAll(bucket);
        }
        this.deck = sorted;
    }

    public void bubbleSort() {
        boolean isSwaps = true;
        while (isSwaps) {
            isSwaps = false;
            for (int i = 0; i < deck.size() - 1; i++) {
                if (this.deck.get(i).compareTo(this.deck.get(i + 1)) > 0) {
                    swap(i, i + 1);
                    isSwaps = true;
                }

            }
        }
    }

    private void swap(int a, int b) {
        Card c = this.deck.get(a);
        c = this.deck.set(b, c);
        this.deck.set(a, c);
    }

    public void defaultSort() {
        Collections.sort(deck);
    }

    public int binarySearch(Card target) {
        int low = 0;
        int high = deck.size() - 1;
        int mid = 0;

        while (high >= low) {
            mid = (low + high) / 2;
            if (target.compareTo(this.deck.get(mid)) == 0) {
                return mid;
            } else if ((target.compareTo(this.deck.get(mid)) > 0)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public void mysterySort() {
        for (int i = 0; i < this.deck.size(); i++) {
            for (int j = i; j < this.deck.size(); j++) {
                if (this.deck.get(i).compareTo(this.deck.get(j)) > 0) {
                    swap(i, j);
                }
            }
        }
    }

    public void selectionSort() {

        for (int i = 0; i < this.deck.size(); i++) {
            int index = 0;
            Card min = new Card(14, 3);
            for (int j = i; j < this.deck.size(); j++) {
                if (this.deck.get(j).compareTo(min) < 0) {
                    min = this.deck.get(j);
                    index = j;

                }
            }
            swap(i, index);
        }
    }

    public void insertionSort() {

        for (int i = 1; i < this.deck.size(); i++) {
            Card c = this.deck.get(i);
            if (c.compareTo(this.deck.get(i - 1)) < 0) {
                for (int j = i - 1; j > -1 && c.compareTo(this.deck.get(j)) <= 0; j--) {
                    swap(i, j);
                    i--;
                }
            }
        }

    }

    public void quickSort() {
        deck = quickSort(deck);
    }

    public static List<Card> quickSort(List<Card> unsorted) {
        // dont forget the base case
        // there is a list method called addAll which adds all elements to another
        // someList.addAll(someOtherList)
        if (unsorted.size() <= 1) {
            return unsorted;
        }
        List<Card> smallList = new ArrayList<>();
        List<Card> bigList = new ArrayList<>();
        Card pivot = unsorted.remove(unsorted.size() / 2);
        for (Card card : unsorted) {
            if (card.compareTo(pivot) > 0) {
                bigList.add(card);
            } else {
                smallList.add(card);

            }
        }

        smallList = quickSort(smallList);
        bigList = quickSort(bigList);
        smallList.add(pivot);
        smallList.addAll(bigList);
        return smallList;

    }

    public void mergeSort() {
        this.deck = mergeSort(this.deck);
    }

    public List<Card> mergeSort(List<Card> unsorted) {

        List<Card> listOne = new ArrayList<>();
        List<Card> listTwo = new ArrayList<>();
        if (unsorted.size() <= 1) {
            return unsorted;
        }
        for (int i = 0; i < unsorted.size() / 2; i++) {
            listOne.add(unsorted.get(i));
        }
        for (int i = unsorted.size() / 2; i < unsorted.size(); i++) {
            listTwo.add(unsorted.get(i));
        }
        listOne = mergeSort(listOne);
        listTwo = mergeSort(listTwo);

        return merge(listOne, listTwo);

    }

    private List<Card> merge(List<Card> listOne, List<Card> listTwo) {
        List<Card> merged = new ArrayList<>();
        int chokedList = 0;
        
        while(listOne.size() > 0 && listTwo.size() > 0){
            if(listOne.get(0).compareTo(listTwo.get(0)) < 0){
                merged.add(listOne.remove(0));

            } else{
                merged.add(listTwo.remove(0));
            }
            if(listOne.size() <= 0){
                chokedList = 2;
            }
            if(listTwo.size() <= 0){
                chokedList = 1;
            }
        }
            merged.addAll(listOne);
            merged.addAll(listTwo);
        
        
        
        return merged;
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
    // for (int i = 0; i < 1000; i++) {
    // Card randCard = deck.remove((int) (Math.random() * deck.size()));
    // deck.add(randCard);
    // }
    // }
    public void returnToDeck(List<Card> cards) {
        this.deck.addAll(cards);
    }

    public void clearDeck() {
        this.deck.clear();
    }
}
