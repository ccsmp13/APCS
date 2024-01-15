import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel{
  static final long serialVersionUID = 1;

  public MyPanel(){
    setPreferredSize(new Dimension(250,200));
    setBackground(Color.BLACK);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.WHITE);
    g.drawRect(80,20,100,35);
    g.drawString("Hello World!",97,35);
    g.drawString("Goodbye for now!",83,50);
    g.setColor(Color.yellow);
    g.fillOval(500,500,500,500);
    g.setColor(Color.orange);
    g.fillOval(600,550,75,75);
    g.fillOval(550,800,75,75);
    g.fillOval(750,720,75,75);
    g.fillOval(720,900,75,75);
    g.fillOval(870,830,75,75);
    g.fillOval(830,600,75,75);
    g.setColor(Color.white);
    g.drawLine(760,510,760,400);
    g.drawLine(760,400,820,420);
    g.drawLine(820,420,760,440);
    g.setColor(Color.blue);
    g.drawLine(730,500,730,440);
      //body stick
    g.drawOval(715,410,30,30);
    g.drawLine(730,500,705,530);
    g.drawLine(730,500,755,530);
    g.drawLine(730,465,760,450);
    g.drawLine(730,465,700,450);
    }

}