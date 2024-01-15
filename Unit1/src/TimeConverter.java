import java.util.Scanner;

@SuppressWarnings("resource")

public class TimeConverter {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the total number of seconds: ");
        int startTotalSeconds = in.nextInt();
        in.nextLine();

        int totalHours = startTotalSeconds / 3600;
        int totalMinutes = (startTotalSeconds % 3600) / 60;
        int totalSeconds = (startTotalSeconds % 3600) % 60;
        

        System.out.printf("%d seconds = %d hour(s), %d minute(s), and %d second(s)\n",startTotalSeconds,totalHours,totalMinutes,totalSeconds);

    }
}