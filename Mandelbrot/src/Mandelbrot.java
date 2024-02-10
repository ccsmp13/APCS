public class Mandelbrot {
    
    
    static int iterationLimit = 100;
    
    
    public static int testPoint(Complex c){
        Complex z = new Complex();
        int k = 0;
        while (z.abs() <= 2){
            z = z.square().add(c);
            k++;
            if(k >= iterationLimit){
                return -1;
            }
        }
        return k;
    }
    
}
