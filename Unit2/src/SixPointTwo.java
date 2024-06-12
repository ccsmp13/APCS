public class SixPointTwo {
    public static void main(String[] args) {
        System.out.println(squareRoot(144));
    }
    public static double squareRoot(double a){
        //n = (k + a/k)/2
        final double THRESHHOLD = .0001;
        double k = a/2;
        double n = 0.0;
        double j = THRESHHOLD + 1;
        while (j > THRESHHOLD){
            
            n = (k + a / k) / 2;  
            j = Math.abs(k - n);
            k = n;
            
        }
        return k;
    }
}
