public class Time {
    public static void main(String[] args){
        
        int hour = 23;
        int second = 11;
        int minute = 11;
        int hourInSec = hour*60*60;
        int percentDayPassed = (hourInSec+minute*60+second)*100 / (24*60*60)*10;
        int hourNow = 23;
        int secondNow = 15;
        int minuteNow = 35;

        System.out.print("Number of seconds since midnight: ");
        System.out.println(hourInSec+minute*60+second);
        System.out.print("Number of seconds left today: ");
        System.out.println((24-hour)*60*60-minute*60-second);
        System.out.print("Percentage of the day that has passed: ");
        System.out.print(percentDayPassed/10);
        System.out.println("%");
        System.out.print("Time Elapsed: ");
        System.out.print(hour-hourNow);
        System.out.print(":");
        System.out.print(minuteNow-minute);
        System.out.print(".");
        System.out.print(secondNow-second);


    }
}
