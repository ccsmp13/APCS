import java.util.Scanner;

public class ModernToHistoricPounds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the modern-day pounds
        System.out.print("Enter modern-day dollars: ");
        double dollars = scanner.nextDouble();

 double poundConversionRate = .78;
    double modernPounds = (dollars * poundConversionRate);
        // Convert modern pounds to historic pounds, shillings, and pence
        int historicPounds = (int) modernPounds;
        double remainingPounds = modernPounds - historicPounds;
        int shillings = (int) (remainingPounds * 20);
        int pence = (int) (((remainingPounds * 20 - shillings) * 12));

        // Display the conversion
        System.out.println("Historic Pounds: " + historicPounds);
        System.out.println("Shillings: " + shillings);
        System.out.println("Pence: " + pence);

        scanner.close();
    }
}
