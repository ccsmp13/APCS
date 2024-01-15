import javax.swing.JFrame;

public class HanoiRunner {
	 public static void main(String[] args) {
		    JFrame f = new JFrame("Towers of Hanoi"); 
		    TowerOfHanoi p = new TowerOfHanoi();
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    f.add(p);
		    f.pack();
		    f.setVisible(true);
		    p.run();
		  }
}