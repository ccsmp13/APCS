public class SearchUnitTest {
    public static void main(String[] args) {
        Deck d1 = new Deck();
        Deck d2 = new Deck();
        d1.defaultSort();
        System.out.println(d1.binarySearch(new Card(8,2)));
        System.out.println(d1.linearSearch(new Card(8,2)));
        System.out.println(d1.binarySearch(new Card(2,2)));
        System.out.println(d1.linearSearch(new Card(2,2)));
        System.out.println(d1.binarySearch(new Card(6,1)));
        System.out.println(d1.linearSearch(new Card(6,1)));
        System.out.println(d1.binarySearch(new Card(3,0)));
        System.out.println(d1.linearSearch(new Card(3,0)));
        
    }
}
