import java.util.Scanner;

@SuppressWarnings("resource")

public class TempConverter {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Type a temperature in Celcius: ");
        double celciusTemp = in.nextDouble();
        in.nextLine();
        
        double fahrenheitTemp = celciusTemp * (9.0 / 5) + 32;
        System.out.printf("%.1f C = %.1f F\n",celciusTemp, fahrenheitTemp);
        
    }
    
}
