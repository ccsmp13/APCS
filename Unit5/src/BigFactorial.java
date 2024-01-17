import java.math.BigInteger;

public class BigFactorial {
    public static void main(String[] args) {
        BigInteger x = new BigInteger("1") , y = BigInteger.valueOf(3);






        for (int i = 0; i <= 30; i++) {
            System.out.println(i + "\t" + factorial(i) + "\t" + bigFactorial(i));
        }
    }

    public static int factorial(int n){
        int f = 1;
        for (int k = n; k > 0; k--) {
            f = f * k;
        }
        return f;
    }
    public static BigInteger bigFactorial(int n){
        BigInteger f = new BigInteger("1");
        BigInteger k = BigInteger.valueOf(n);
        for (int i = n; i > 0; i--) {
            f = f.multiply(k);
            n--;
            k = BigInteger.valueOf(n);
        }
        return f;

    }

}
