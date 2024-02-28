import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class App {
    public static void main(String[] args) throws Exception {
        BlackjackPlayer p1 = new BlackjackPlayer("Player 1");
        BlackjackPlayer p2 = new BlackjackPlayer("Player 2");
        Deck d = new Deck();
        d.shuffle();
        d.deal();
        


    }
}
