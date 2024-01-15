import javax.swing.JFrame;

public class ConwayRunner {
    public static void main(String[] args) {
	    JFrame f = new JFrame("Conway's game of Life"); 
	    Conway p = new Conway(500, 500);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.add(p);
	    f.pack();
	    f.setVisible(true);
	    p.setFocusable(true);
	    p.requestFocusInWindow();
	    p.run();
	}

}
