import java.awt.*;
import javax.swing.*;

public class RandomPanel extends JPanel {
  static final long serialVersionUID = 1;
  final int WIDTH = 640;
  final int HEIGHT = 640;

  public RandomPanel() {
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setBackground(Color.BLACK);
  }

  public static int getLCGNum(int m) {
    final int A = 65539;
    final int C = 0;
    int seed = getSeed();

    int r = (A * seed + C) % m;
    return Math.abs(r);
  }

  public static int getSeed() {
    final int SHORTEN = 100;
    final int LAST_THREE = 1000;
    int seed = (int) Math.abs(System.nanoTime());
    int intermediate = seed % LAST_THREE / SHORTEN;
    return Math.abs(seed + intermediate) / SHORTEN % LAST_THREE;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int x1 = WIDTH / 2;
    int y1 = HEIGHT / 2;
    int x2 = WIDTH / 2;
    int y2 = HEIGHT / 2;
    int panelMin = 0;
    int panelMax = HEIGHT;
    int step = 3;

    while (x1 <= panelMax && x1 >= panelMin && y1 <= panelMax && y1 >= panelMin) {
      int dir = (int) (Math.random() * 4);
      if (dir == 0) {
        g.setColor(Color.blue);
        x2 = x2 + step;
      } else if (dir == 1) {
        g.setColor(Color.red);
        y2 = y2 + step;
      } else if (dir == 2) {
        g.setColor(Color.green);
        y2 = y2 - step;
      } else if (dir == 3) {
        g.setColor(Color.yellow);
        x2 = x2 - step;

      }
      g.drawLine(x1, y1, x2, y2);
      x1 = x2;
      y1 = y2;

    }
  }
}