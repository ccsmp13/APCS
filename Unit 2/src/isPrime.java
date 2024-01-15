public class isPrime {
    public static void main(String[] args) {
        System.out.println(isNPrime(34));
    }

    public static boolean isNPrime(int n) {
        for (int k = 2; n <= k; k++) {
            if (n % k == 0) {
                return false;
            }
        }
        return true;
    }
}
