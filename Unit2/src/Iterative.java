public class Iterative {
    public static void main(String[] args) {
        System.out.println(fibSeq(9));
        System.out.println(factorial(10));
        System.out.println(isThree(145677484));

    }

    public static boolean isThree(int n) {

        while (n > 0) {
            if (n % 10 == 3) {
                return true;
            } else {
                n = n / 10;
            }
        }
        return false;
    }

    public static int factorial(int a) {
        int res = 1;
        for (int k = a; k > 0; k--) {
            res = res * k;
        }
        return res;
    }

    public static int fibSeq(int n) {
        int a = 0;
        int b = 1;
        int res = 0;
        for (int k = 0; k <= n - 1; k++) {

            res = a + b;
            b = a;
            a = res;

        }
        return res;
    }
}
