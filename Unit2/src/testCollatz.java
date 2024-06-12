public class testCollatz {
    public static void main(String[] args) {
        tryAll();
    }

    public static int testCollatz1(int n) {
        int k = 0;
        while (n>1 && k <=1000) {

            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
            k++;
        }
        if ((k>1000)){
            return -1;
        } else {
            return k;
        }
        
    }

    public static void tryAll() {
        for (int k = 1; k <= 1000000; k++) {

            if (testCollatz1(k) <= 1000) {
                System.out.println(k + ": Required " + testCollatz1(k) + " iterations.");
            } else {
                System.out.println(k + ": did not converge.");
            }
        }
    }
}