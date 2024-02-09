import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class FractalPanel extends JPanel implements MouseListener {
    
    //declare class wide variables
    int width = 600;
    int height = 400;
    View view = new View(width, height);
    Palette p = new Palette(1);
    Complex topLeft;
    //declare any other fractal-related objects

    public FractalPanel() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        //initialize the fractal related objects here
        addMouseListener(this);
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
        Complex botRight = view.translate(e.getX(), e.getY());
        view.setComplexCorners(topLeft, botRight);
        repaint();
        Mandelbrot.updateRes();

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // unused
    }
}


