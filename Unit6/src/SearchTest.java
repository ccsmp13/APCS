public class SearchTest {

    public static void main(String[] args) {
        Deck d = new Deck();
        d.defaultSort();
        int searchFailures = 0;
        for (int rank = 1; rank <= 13; rank++){
            for (int suit = 0; suit <= 3; suit++){
                Card temp = new Card(rank, suit);
                if (d.linearSearch(temp) != d.binarySearch(temp)){
                    System.out.print("Linear search found the " + temp + " at: " + d.linearSearch(temp));
                    System.out.println(" but binary search found it at: " + d.binarySearch(temp));
                    searchFailures++;
                }
            }
        }
        if (searchFailures == 0){
            System.out.println("All cards found in the same places by both linear and binary search.");
        } else {
            System.out.println("There were " + searchFailures + " search mismatches.");
        }
    }
    
}

