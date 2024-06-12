import java.util.ArrayList;

public class SortTest {

    public static void main(String[] args) {
        Deck d = new Deck();

        // BUBBLE SORT TEST //
        System.out.println("\nRunning bubble sort test...");
        d.shuffle();
        d.bubbleSort();
        // System.out.println(d + "\n"); // uncomment to print the results of the sort
        System.out.println("Bubble sort works correctly: " + isInOrder(d));
        System.out.println("Size of deck after bubble sort: " + d.getCardsLeft());

        // SELECTION SORT TEST //
        System.out.println("\nRunning selection sort test...");
        d.shuffle();
        d.selectionSort();
        // System.out.println(d + "\n"); // uncomment to print the results of the sort
        System.out.println("Selection sort works correctly: " + isInOrder(d));
        System.out.println("Size of deck after selection sort: " + d.getCardsLeft());

        // INSERTION SORT TEST //
        System.out.println("\nRunning insertion sort test...");
        d.shuffle();
        d.insertionSort();
        //System.out.println(d + "\n"); // uncomment to print the results of the sort
        System.out.println("Insertion sort works correctly: " + isInOrder(d));
        System.out.println("Size of deck after insertion sort: " + d.getCardsLeft());

        // MERGE SORT TEST //
        System.out.println("\nRunning merge sort test...");
        d.shuffle();
        d.mergeSort();
        // System.out.println(d + "\n"); // uncomment to print the results of the sort
        System.out.println("Merge sort works correctly: " + isInOrder(d));
        System.out.println("Size of deck after merge sort: " + d.getCardsLeft());

        // // QUICK SORT TEST //
        System.out.println("\nRunning quick sort test...");
        d.shuffle();
        d.quickSort();
        // System.out.println(d + "\n"); // uncomment to print the results of the sort
        System.out.println("Quick sort works correctly: " + isInOrder(d));
        System.out.println("Size of deck after quick sort: " + d.getCardsLeft());

        // BUCKET SORT TEST //
        System.out.println("\nRunning bucket sort test...");
        d.shuffle();
        d.bucketSort();
        // System.out.println(d + "\n"); // uncomment to print the results of the sort
        System.out.println("Bucket sort works correctly: " + isInOrder(d));
        System.out.println("Size of deck after bucket sort: " + d.getCardsLeft());
    }

    private static boolean isInOrder(Deck testDeck) {
        final int COMPARISONS_IN_FULL_DECK = 51;
        int sortCount = 0;
        Card previous = testDeck.deal(); // the only public way to access each Card is by dealing
        ArrayList<Card> discards = new ArrayList<Card>();
        while (testDeck.getCardsLeft() > 0) {
            Card next = testDeck.deal();
            if (previous.compareTo(next) <= 0) {
                sortCount++;
            } else {
                System.err.println("Error: " + next + " should come before " + previous);
            }
            discards.add(previous);
            previous = next;
        }
        discards.add(previous); // add last card
        testDeck.returnToDeck(discards); // and the only public way to add cards back is this
        return sortCount == COMPARISONS_IN_FULL_DECK;
    }
}


