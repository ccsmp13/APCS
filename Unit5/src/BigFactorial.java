public class BigFactorial {
    public static void main(String[] args) {
        for (int i = 0; i <= 30; i++) {
            System.out.println(i + "\t" + factorial(i));
        }
    }

    public static int factorial(int n){
        int f = 1;
        for (int k = n; k > 0; k--) {
            f = f * k;
        }
        return f;
    }

}
