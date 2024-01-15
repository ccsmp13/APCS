import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")

public class Conway extends JPanel implements KeyListener, MouseListener {
    // put class & instance variables to control animation here
    int fps = 1;
    final int START_WIDTH = 500;
    final int START_HEIGHT = 500;
    int gridsize = 10;
    int[][] cells = new int[START_HEIGHT / gridsize][START_WIDTH / gridsize];
    boolean pause = true;
    int pressX;
    int pressY;

    public Conway(int w, int h) {
        setPreferredSize(new Dimension(START_WIDTH, START_HEIGHT));
        setBackground(Color.BLACK);
        addKeyListener(this);
        addMouseListener(this);
    }

    public void drawCells(Graphics g) {
        g.setColor(Color.green);
        for (int r = 0; r < cells.length; r++) {
            for (int c = 0; c < cells.length; c++) {
                if (cells[r][c] == 1) {
                    g.fillOval(c * gridsize, r * gridsize, gridsize, gridsize);
                }
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = this.getWidth();
        int height = this.getHeight();

        g.setColor(Color.LIGHT_GRAY);

        for (int y = 0; y < height; y += gridsize) {
            g.drawLine(0, y, width, y);

        }
        for (int x = 0; x < width; x += gridsize) {
            g.drawLine(x, 0, x, height);

        }
        drawCells(g);

        // draw background BufferedImage here
        // draw foreground objects here
    }

    public void run() {
        int k = 0;
        while (true) {
            // update animation variables here
            delay(1000 / fps);
            repaint();

            int numAlive = 0;
            if (!pause) {

                cells = updateCells(cells);
                k++;
                numAlive = countAlive(cells);
                System.out.printf("In round %d there are %d boxes alive\n", k, numAlive);

            } else {
                System.out.println("Paused\n");
                addCells(cells);

            }
        }
    }

    public int countAlive(int[][] cells) {
        int k = 0;
        for (int r = 0; r < cells.length; r++) {
            for (int c = 0; c < cells.length; c++) {
                k += cells[r][c];
            }
        }
        return k;
    }

    public int[][] addCells(int[][] cells) {
        final int CHOP = 10;
        final int ALIVE = 1;
        int loc1 = pressX / CHOP;
        int loc2 = pressY / CHOP;
        cells[loc2][loc1] = ALIVE;
        pressX = 0;
        pressY = 0;
        return cells;
    }

    public int[][] updateCells(int[][] oldCells) {
        int[][] newCells = new int[oldCells.length][oldCells.length];
        int k = 0;
        final int OFFSET = 1;
        final int ALIVE = 1;
        for (int r = 1; r < newCells.length - 1; r++) {
            for (int c = 1; c < newCells.length - 1; c++) {
                if (oldCells[r][c] == 1) {
                    k += oldCells[r - OFFSET][c - OFFSET];
                    k += oldCells[r - OFFSET][c];
                    k += oldCells[r - OFFSET][c + OFFSET];
                    k += oldCells[r][c - OFFSET];
                    k += oldCells[r][c + OFFSET];
                    k += oldCells[r + OFFSET][c - OFFSET];
                    k += oldCells[r + OFFSET][c];
                    k += oldCells[r + OFFSET][c + OFFSET];
                    if (k == 2 || k == 3) {
                        newCells[r][c] = ALIVE;
                    }
                } else {
                    k += oldCells[r - OFFSET][c - OFFSET];
                    k += oldCells[r - OFFSET][c];
                    k += oldCells[r - OFFSET][c + OFFSET];
                    k += oldCells[r][c - OFFSET];
                    k += oldCells[r][c + OFFSET];
                    k += oldCells[r + OFFSET][c - OFFSET];
                    k += oldCells[r + OFFSET][c];
                    k += oldCells[r + OFFSET][c + OFFSET];
                    if (k == 3) {
                        newCells[r][c] = ALIVE;
                    }

                }
                k = 0;

            }
        }
        return newCells;
    }

    public void delay(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // call event handling methods
            // use sysouts for debugging like this:
            // System.out.println("The left arrow was pressed");
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // call event handling methods
        }
    }

    public void keyTyped(KeyEvent e) {
        // note the difference between getKeyChar and getKeyCode
        if (e.getKeyChar() == 'q') {
            pause = !pause;
        }

    }

    public void mouseClicked(MouseEvent e) {
        // called when the mouse is pressed and released quickly
    }

    public void mouseEntered(MouseEvent e) {
        // called when the mouse enters the window
    }

    public void mouseExited(MouseEvent e) {
        // called when the mouse leaves the window
    }

    public void mousePressed(MouseEvent e) {
        pressX = e.getX();
        pressY = e.getY();
        // set a variable based on mouse coordinates
        // or check a condition based on mouse coordinates

    }

    public void mouseReleased(MouseEvent e) {
        int releaseX = e.getX();
        int releaseY = e.getY();
        // set a variable based on mouse coordinates
        // or check a condition based on mouse coordinates
    }
}
