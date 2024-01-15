import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Stack;
import java.util.ArrayList;
import javax.swing.JPanel;

public class TowerOfHanoi extends JPanel {

    private static final long serialVersionUID = 1L;
    ArrayList<Stack<Integer>> towers;
    final int NUM_DISKS = 10;
    final int DELAY = 10;

    public TowerOfHanoi() {
        setPreferredSize(new Dimension(720, 400));
        setBackground(Color.LIGHT_GRAY);
        towers = new ArrayList<Stack<Integer>>();
        Stack<Integer> s = new Stack<Integer>();
        for (int i = NUM_DISKS; i > 0; i--) {
            s.push(i);
        }
        towers.add(s);
        towers.add(new Stack<Integer>());
        towers.add(new Stack<Integer>());
    }

    public void run() {
        moveDisks(NUM_DISKS, 0, 2, 1);
    }
    public void moveDisks(int num, int startPole, int endPole, int tempPole){
        if (num == 1){
            moveSingleDisk(startPole, endPole);
        } else{
            moveDisks(num - 1, startPole, tempPole, endPole);
            moveSingleDisk(startPole, endPole);
            moveDisks(num - 1, tempPole, endPole, startPole);

        }
    }

    public void moveSingleDisk(int startPole, int destinationPole) {
        Stack<Integer> source = towers.get(startPole);
        Stack<Integer> destination = towers.get(destinationPole);
        if (destination.empty() || source.peek().compareTo(destination.peek()) < 0) {
            destination.push(source.pop());
        } else {
            throw new RuntimeException(
                    "Can't put disk size " + source.peek() + " onto disk size " + destination.peek());
        }
        delay(DELAY);
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(360, 0, Color.LIGHT_GRAY, 360, 400, Color.DARK_GRAY);
        g2.setPaint(gp);
        g2.fillRect(0, 0, 720, 400);
        g.setColor(Color.BLACK);
        g.fillRect(117, 160, 6, 220);
        g.fillRect(357, 160, 6, 220);
        g.fillRect(597, 160, 6, 220);

        for (int i = 0; i < 3; i++) {
            Stack<Integer> s = towers.get(i);
            for (int j = 0; j < s.size(); j++) {
                Integer disk = s.get(j);
                drawDisk(g, i, j, disk.intValue());
            }
        }
    }

    public void drawDisk(Graphics g, int pole, int layer, int diskSize) {
        g.setColor(Color.blue);
        int x = 120 + 240 * pole;
        int y = 360 - 22 * layer;
        int width = diskSize * 20;
        g.fillRoundRect(x - width / 2, y, width, 20, 10, 10);
    }

    public void delay(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}