import java.awt.*;
import javax.swing.*;
import java.util.Scanner;

@SuppressWarnings("resource")
public class CurrencyPanel extends JPanel {
    static final long serialVersionUID = 1;

    double dollars;

    public CurrencyPanel() {
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.blue);
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the dollar value to convert: ");
        dollars = in.nextDouble();
        in.nextLine();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        String dollarString = String.format("You entered: %.2f USD", dollars);

        final double EURO_CONVERSION_RATE = 0.84;
        double euro = dollars * EURO_CONVERSION_RATE;
        String euroString = String.format("Euros: %.2f", euro);
        
        final double POUND_CONVERSION_RATE = 0.78;
        double modernPound = dollars * POUND_CONVERSION_RATE;
        String modernPoundString = String.format("Modern-Pounds: %.2f", modernPound);

        final int SHILL_IN_POUND = 20;
        final int PENCE_IN_SHILL = 12;
        int historicPound = (int) modernPound;
        double remainingPounds = modernPound - historicPound;
        int historicShill = (int) (remainingPounds * SHILL_IN_POUND);
        int historicPence = (int) (((remainingPounds * SHILL_IN_POUND - historicShill) * PENCE_IN_SHILL));
        

        String finHistoricPounds = String.format("%d Shillings: %d Pence: %d", historicPound, historicShill, historicPence);

        g.setColor(Color.white);
        g.drawRoundRect(20, 20, 260, 50, 20, 20);
        g.setFont(new Font("Serif Bold", Font.PLAIN, 28));
        g.drawString("Currency Converter", 30, 55);
        g.setFont(new Font("Serif", Font.PLAIN, 18));
        g.drawString(dollarString, 60, 100);
        g.setColor(Color.yellow);
        g.setFont(new Font("Serif", Font.PLAIN, 18));
        g.drawString(euroString, 78, 163);
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString("€", 50, 170);
        g.setColor(Color.red);
        g.setFont(new Font("Serif", Font.PLAIN, 18));
        g.drawString(modernPoundString, 78, 203);
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString("\u00A3", 50, 210);
        g.setColor(Color.black);
        g.setFont(new Font("Serif", Font.PLAIN, 18));
        g.drawString("Historic-Pounds:", 78, 243);
        g.drawString(finHistoricPounds, 78, 263);
        g.setFont(new Font("Serif", Font.PLAIN, 40));
        g.drawString("\u00A3", 50, 260);
    }
}
