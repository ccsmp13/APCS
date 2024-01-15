import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClockPanel extends JPanel implements ActionListener {
    static final long serialVersionUID = 1;
    JTextField hourInput;
    JTextField minInput;
    JTextField secInput;
    int hour = 12;
    int min = 0;
    int sec = 0;

    public ClockPanel() {
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.WHITE);

        // creates and adds hour, min ,sec labels and input fields
        JLabel hourLabel = new JLabel("Hour");
        add(hourLabel);
        hourInput = new JTextField(4);
        hourInput.addActionListener(this); // invokes actionPerformed method below on new input
        add(hourInput);
        JLabel minLabel = new JLabel("Minute");
        add(minLabel);
        minInput = new JTextField(4);
        minInput.addActionListener(this);
        add(minInput);
        JLabel secLabel = new JLabel("Second");
        add(secLabel);
        secInput = new JTextField(4);
        secInput.addActionListener(this);
        add(secInput);
        Timer tick = new Timer(1000, this);
        tick.start();
    }

    public static Boolean isHourValid(int hour) {
        final int VALID_HOUR = 12;
        final int MINIMUM = 0;

        if (hour > VALID_HOUR || hour < MINIMUM) {
            return false;
        }
        return true;
    }

    public static Boolean isMinValid(int min) {
        final int VALID_MIN = 59;
        final int MINIMUM = 0;
        if (min > VALID_MIN || min < MINIMUM) {
            return false;
        }
        return true;
    }

    public static Boolean isSecValid(int sec) {
        final int VALID_SEC = 59;
        final int MINIMUM = 0;
        if (sec > VALID_SEC || sec < MINIMUM) {
            return false;
        }
        return true;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*****
         * ASSIGNMENT *********
         * 1. Write methods that check whether hour, min, and sec are within
         * valid ranges (1-12 for hour, 0-59 for min and sec) and return booleans
         *
         * 2. Call those methods inside paintComponent here. If any of the three
         * is not valid, use g.drawRect to draw a red box around that input field in the
         * panel.
         * 
         * 3. If all hour, min, sec are all valid, only then invoke the drawClock(g)
         * method here.
         */
        if (!isHourValid(hour)) {
            g.setColor(Color.red);
            g.drawRect(8, 4, 85, 22);
        }
        if (!isMinValid(min)) {
            g.setColor(Color.red);
            g.drawRect(93, 4, 95, 22);
        }
        if (!isSecValid(sec)) {
            g.setColor(Color.red);
            g.drawRect(190, 4, 95, 22);
        }
        if (isHourValid(hour) && isMinValid(min) && isSecValid(sec)) {
            drawClock(g);
        }

    }

    @Override
    /**
     * Recieves and processes user input event.
     * Catches errors if the input is not an integer,
     * otherwise assigns it to the matching varaible.
     */
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == hourInput) {
                hour = Integer.parseInt(e.getActionCommand());
            } else if (e.getSource() == minInput) {
                min = Integer.parseInt(e.getActionCommand());
            } else if (e.getSource() == secInput) {
                sec = Integer.parseInt(e.getActionCommand());
            } else {
                updateTime();
            }
            // output for debugging
            System.out.println(hour + "   " + min + "   " + sec);
            // System.out.println(javax.swing.SwingUtilities.isEventDispatchThread());
        } catch (NumberFormatException nfe) {
            // output for debugging
            System.out.println("non-integer input");
        }
        repaint();
    }

    /**
     * Increases the value of sec by one, with rollover and update of
     * minute and hour as needed.
     */
    public void updateTime() {
        sec++;
        if (sec == 60) {
            sec = 0;
            min++;
        }
        if (min == 60) {
            min = 0;
            hour++;
        }
        if (hour == 13) {
            hour = 1;
        }

    }

    /**
     * Draws an analog clock face using the values from hour, min, sec
     * 
     * @param g the Grpahics object
     */
    public void drawClock(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; // suing Graphics2D to set line widths
        final double HOUR_HAND_LEN = 0.5; // hand lengths as a fraction of radius
        final double MIN_HAND_LEN = 0.8;
        final double SEC_HAND_LEN = 0.9;

        // calculate overall dimensions based on panel size
        int w = this.getWidth();
        int h = this.getHeight();
        int midX = w / 2;
        int midY = h / 2;
        int r = Math.min(w, h) * 2 / 5;

        // clock circle
        g2.setColor(Color.BLACK);
        g2.drawOval(r / 4, r / 4, 2 * r, 2 * r);
        g2.setColor(Color.DARK_GRAY);

        // hour hand
        // calcuates angle from top and then x and y components using trig
        double hourAngle = hour / 12.0 * 2.0 * Math.PI;
        int hourX = (int) (midX + HOUR_HAND_LEN * r * Math.sin(hourAngle));
        int hourY = (int) (midY - HOUR_HAND_LEN * r * Math.cos(hourAngle));
        g2.setStroke(new BasicStroke(8, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        g2.drawLine(midX, midY, hourX, hourY);

        // minute hand
        double minAngle = min / 60.0 * 2.0 * Math.PI;
        int minX = (int) (midX + MIN_HAND_LEN * r * Math.sin(minAngle));
        int minY = (int) (midY - MIN_HAND_LEN * r * Math.cos(minAngle));
        g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        g2.drawLine(midX, midY, minX, minY);

        // second hand
        double secAngle = sec / 60.0 * 2.0 * Math.PI;
        int secX = (int) (midX + SEC_HAND_LEN * r * Math.sin(secAngle));
        int secY = (int) (midY - SEC_HAND_LEN * r * Math.cos(secAngle));
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));
        g2.drawLine(midX, midY, secX, secY);
    }

}