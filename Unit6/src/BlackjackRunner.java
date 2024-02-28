import javax.swing.JFrame;

public class BlackjackRunner {

  public static void main(String[] args) {
    JFrame f = new JFrame("Put Frame Title Here"); 
    BlackjackPanel p = new BlackjackPanel(800,600);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(p);
    f.pack();
    f.setVisible(true);
    p.setFocusable(true);
    p.requestFocusInWindow();
    p.run();
  }

}
