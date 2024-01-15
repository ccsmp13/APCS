import java.util.Scanner;

@SuppressWarnings("resource")
public class Echo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Type the radius of a circle: ");
        int radius = in.nextInt();
        in.nextLine();
        
        int pi = 31415;
        double area = radius * radius *pi;
        System.out.print("The area is: ");
        System.out.println(area/10000);

        double circumfrence = radius * pi * 2;
        System.out.print("The circumfrence is: ");
        System.out.println(circumfrence/10000);

    }
}