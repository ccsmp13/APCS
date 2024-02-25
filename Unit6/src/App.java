public class App {
    public static void main(String[] args) throws Exception {
        Player p1 = new BlackjackPlayer("Player 1");
        Player p2 = new BlackjackPlayer("Player 2");
        p2.take(new Card(11, 2));
        p1.take(new Card(10, 0));


    }
}
