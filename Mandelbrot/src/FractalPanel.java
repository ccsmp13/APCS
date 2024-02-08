import java.awt.*;
import javax.swing.*;

public class FractalPanel extends JPanel {
    
    //declare class wide variables
    int width = 600;
    int height = 400;
    View view1 = new View(width, height);
    Palette p1 = new Palette(1);
    //declare any other fractal-related objects

    public FractalPanel() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        //initialize the fractal related objects here
    }

    public void paintComponent(Graphics g) {
        
        int iteration;
        double normedN;
        Color c1;
        Complex complex1;
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                complex1 = view1.translate(x,y);
                iteration = Mandelbrot.testPoint(complex1);
                normedN = (double)iteration / Mandelbrot.iterationLimit;
                c1 = p1.getColor(normedN);
                g.setColor(c1);
                g.fillRect(x, y, 1, 1);
            }
        }
    }
}


