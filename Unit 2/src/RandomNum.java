public class RandomNum {
    public static int getLCGNum(int m) {
        final int A = 5;
        final int C = 3;
        int seed = getSeed();

        int r = (A * seed + C) % m;
        return Math.abs(r);

    }

    public static int getSeed() {
        final int SHORTEN = 100;
        final int LAST_THREE = 1000;
        int seed = (int) Math.abs(System.nanoTime());
        int intermediate =  seed % LAST_THREE / SHORTEN;
        return Math.abs(seed + intermediate) / SHORTEN % LAST_THREE;
    }

    public static void main(String[] args) {
        for (int k = 1; k <= 40; k++) {
            System.out.println(getLCGNum(4));
        }
    }
}
