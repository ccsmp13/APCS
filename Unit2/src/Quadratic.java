import java.util.Scanner;

@SuppressWarnings("resource")
public class Quadratic {
    // double posResult = (-b + Math.sqrt((b) * (b) - 4 * (a) * (c))) / (2 * (a));
    // double negResult = (-b - Math.sqrt((b) * (b) - 4 * (a) * (c))) / (2 * (a));
    public static void main(String[] args) {
        int a = getUserInput("Enter the A coefficient: ");
        int b = getUserInput("Enter the B coefficient: ");
        int c = getUserInput("Enter the C coefficient: ");

        System.out.println(calcQuad(a, b, c));

        // process the quadratic stuff in a seperate method
        // have it reurn a message to be printed (dont print in method)(string)

    }

    public static String calcQuad(int a, int b, int c) {
        if (2 * a == 0) {
            return "Error: Divide by zero";
        } else if ((b) * (b) - 4 * (a) * (c) < 0) {
            return "Error: Negative radicand";
        } else if (Math.sqrt((b) * (b) - 4 * (a) * (c)) == 0) {
            double result = -b / 2 * a;

            return "Your answer is: " + result;
        } else {
            double posResult = (-b + Math.sqrt((b) * (b) - 4 * (a) * (c))) / (2 * (a));
            double negResult = (-b - Math.sqrt((b) * (b) - 4 * (a) * (c))) / (2 * (a));
            return "Your answers are: " + posResult + " and " + negResult;
        }

    }

    public static int getUserInput(String prompt) {
        Scanner in = new Scanner(System.in);
        System.out.println(prompt);
        if (!in.hasNextInt()) {
            String input = in.next();
            System.out.println(input + " Is not an integer. Exiting...");
            System.exit(0);
        }
        int reply = in.nextInt();
        return reply;
    }
}
