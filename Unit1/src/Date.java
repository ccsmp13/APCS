public class Date {
    
    public static void main(String[] args){
       String month = "August";
       int date = 24;
       String day = "Thursday";
       int year = 2023;

       
       
       

       printAmerican(month, date, day, year);
       printEuropean(month, date, day, year);

    
    }

    public static void printEuropean(String month,int date, String day, int year){
    
    
        System.out.print("European format: ");
        System.out.print(day);
        System.out.print(" ");
        System.out.print(date);
        System.out.print(" ");
        System.out.print(month);
        System.out.print(" ");
        System.out.println(year);

    }

    public static void printAmerican(String month,int date, String day, int year){

        System.out.print("American format: ");
        System.out.print(day);
        System.out.print(", ");
        System.out.print(month);
        System.out.print(" ");
        System.out.print(date);
        System.out.print(", ");
        System.out.println(year);

    }
}
