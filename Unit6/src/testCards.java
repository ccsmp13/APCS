public class testCards {
    public static void main(String[] args) {
        Deck d1 = new Deck();
        d1.shuffle();
        Player a = new Player();
        Player b = new Player();
        a.take(d1.deal());
        b.take(d1.deal());
        a.take(d1.deal());
        b.take(d1.deal());
        a.take(d1.deal());
        b.take(d1.deal());
        a.take(d1.deal());
        b.take(d1.deal());
        System.out.println("Player a: \n" + a);
        System.out.println("Player b: \n" + b);
        
    }
}
