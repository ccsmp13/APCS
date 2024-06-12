public class CalcMillionaire {
    public static void main(String[] args) {
        calcMillionaireUnitTest();
    }
    public static int calcMillionaire(double annualDeposit, double intRate){
        int years = 0;
        final int MIL = 1000000;
        double rate = intRate / 100 + 1.0;
        double product = 0;
        double sum = 1;

        while (product < MIL){
            sum = product + annualDeposit;
            years++;
            product = sum * rate;
            
        }
        return years;
    }
    
    public static void calcMillionaireUnitTest() {
        System.out.println("$1000/yr @ 0% = 1000 years:  " + (calcMillionaire(1000, 0) == 1000));
        System.out.println("$5000/yr @ 0% = 200 years:  " + (calcMillionaire(5000, 0) == 200));
        System.out.println("$1000/yr @ 0.5% = 359 years:  " + (calcMillionaire(1000, 0.5) == 359));
        System.out.println("$5000/yr @ 0.5% = 139 years:  " + (calcMillionaire(5000, 0.5) == 139));
        System.out.println("$1000/yr @ 4% = 94 years:  " + (calcMillionaire(1000, 4) == 94));
        System.out.println("$5000/yr @ 4% = 56 years:  " + (calcMillionaire(5000, 4) == 56));
        System.out.println("$1000/yr @ 8% = 57 years:  " + (calcMillionaire(1000, 8) == 57));
        System.out.println("$5000/yr @ 8% = 36 years:  " + (calcMillionaire(5000, 8) == 36));
    }
}
