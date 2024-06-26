import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Card implements Comparable<Card>{
    private int rank;
    private int suit;
    private BufferedImage face;
    private static BufferedImage back;

    static{
        String filename = "Unit6/images/back02.png";
        try {
            back = ImageIO.read(new File(filename));
        } catch (IOException e) {
            back = null;
            System.out.println(e + " file: " + filename);
        }
    }
    public static final String[] RANKS = {
            null, "Ace", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "Jack", "Queen", "King" };
    public static final String[] SUITS = {
            "Clubs", "Diamonds", "Hearts", "Spades" };

    public Card(int rank, int suit) {
        if (rank < 1 || rank > 13) {
        
        }
        final int NUM_SUITS = 4;
        this.rank = rank;
        this.suit = suit;
       // int num = (rank - 1) * NUM_SUITS + suit + 1;
        //String filename = String.format("Unit6/images/card%02d.png", num);
        //try {
        //    this.face = ImageIO.read(new File(filename));
        //} catch (IOException e) {
        //    this.face = null;
        //    System.out.println(e + " file: " + filename);
       // }
    }


    public String toString() {
        String s = RANKS[this.rank] + " of " + SUITS[this.suit];
        return s;
    }

    public boolean equals(Card that) {
        return this.rank == that.rank
                && this.suit == that.suit;
    }

    // public int compareTo(Card that) {
    //     if (this.suit < that.suit) {
    //         return -1;
    //     }
    //     if (this.suit > that.suit) {
    //         return 1;
    //     }
    //     if (this.rank < that.rank) {
    //         return -1;
    //     }
    //     if (this.rank > that.rank) {
    //         return 1;
    //     }{


            
    //     }
    //     return 0;
    // }

    public int getRank() {
        return this.rank;
    }

    public int getSuit() {
        return this.suit;
    }
    public int compareTo(Card other){
        int thisNum = this.rank * 4 + this.suit;
        int othernum = other.rank * 4 + other.suit;
        return thisNum - othernum;
    }

    public BufferedImage getFace(){
        return this.face;
    }

    public BufferedImage getBack(){
        return this.back;
    }


    


    



    

}
