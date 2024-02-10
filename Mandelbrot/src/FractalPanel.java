import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class FractalPanel extends JPanel implements MouseListener, KeyListener {
    int width = 600;
    int height = 400;
    View view = new View(width, height);
    Palette p = new Palette(0);
    Complex topLeft;
    Complex botRight;
    double ratio = .1;

    public FractalPanel() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        addMouseListener(this);
        addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        
        int iteration;
        double normedN;
        Color c1;
        Complex complex1;
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                complex1 = view.translate(x,y);
                iteration = Mandelbrot.testPoint(complex1);
                normedN = (double)iteration / Mandelbrot.iterationLimit;
                c1 = p.getColor(normedN);
                g.setColor(c1);
                g.fillRect(x, y, 1, 1);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // unused
    }

    @Override
    public void mousePressed(MouseEvent e) {
        topLeft = view.translate(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        botRight = view.translate(e.getX(), e.getY());
        view.setComplexCorners(topLeft, botRight);
        repaint();
        Mandelbrot.iterationLimit *= 1.4;
        

    }
    

    @Override
    public void mouseEntered(MouseEvent e) {
        // unused
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // unused
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // unused
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == '='){
            Mandelbrot.iterationLimit *= 2;
        }
        if(e.getKeyChar() == '-'){
            Mandelbrot.iterationLimit /= 2;
        }
        if(e.getKeyChar() == '1'){
            p = new Palette(0);
        }
        if(e.getKeyChar() == '2'){
            p = new Palette(1);
        }
        if(e.getKeyChar() == '3'){
            p = new Palette(2);
        }
        if(e.getKeyChar() == 'd'){
            botRight = botRight.add(new Complex(ratio,0));
            topLeft = topLeft.add(new Complex(ratio,0));
            view.setComplexCorners(topLeft, botRight);
        }
        if(e.getKeyChar() == 'a'){
            botRight = botRight.add(new Complex(-ratio,0));
            topLeft = topLeft.add(new Complex(-ratio,0));
            view.setComplexCorners(topLeft, botRight);
        }
        if(e.getKeyChar() == 's'){
            botRight = botRight.add(new Complex(0,-ratio));
            topLeft = topLeft.add(new Complex(0,-ratio));
            view.setComplexCorners(topLeft, botRight);
        }
        if(e.getKeyChar() == 'w'){
            botRight = botRight.add(new Complex(0,ratio));
            topLeft = topLeft.add(new Complex(0,ratio));
            view.setComplexCorners(topLeft, botRight);
        }
        if(e.getKeyChar() == '['){
           ratio /= 10;
        }
        if(e.getKeyChar() == ']'){
           ratio *= 10;
        }
        repaint();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // unused
        
    }
}


