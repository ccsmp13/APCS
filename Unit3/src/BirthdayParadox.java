public class BirthdayParadox {

    public static void main(String[] args) {
        System.out.println(massTest(23));

    }

    public static double massTest(int numPeople) {
        final int NUM_TESTS = 100000;
        final int NUM_OUTPUTS = 2;
        final int PERCENT_SHIFT = 100;
        final int TRUE_BIN = 0;
        final int FALSE_BIN = 1;
        int[] output = new int[NUM_OUTPUTS];

        for (int k = 1; k <= NUM_TESTS; k++) {
            if (isBdaySame(dataHist(fillArray(numPeople)))) {
                output[TRUE_BIN]++;
            } else {
                output[FALSE_BIN]++;
            }
        }
        return (1.0 * output[TRUE_BIN] / NUM_TESTS) * PERCENT_SHIFT;
    }

    public static int[] fillArray(int n) {
        final int DAYS_IN_YEAR = 365;
        int[] data = new int[n];

        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * DAYS_IN_YEAR) + 1;
        }
        return data;
    }

    public static boolean isBdaySame(int[] dataHist) {
        for (int i = 0; i < dataHist.length; i++) {
            if (dataHist[i] > 1) {
                return true;
            }
        }
        return false;
    }

    public static int[] dataHist(int[] data) {
        final int NUM_BINS = 365;
        final int HIST_SHIFT = 1;
        int[] hist = new int[NUM_BINS];
        for (int i = 0; i < data.length; i++) {

            int bin = data[i];

            hist[bin - HIST_SHIFT]++;
        }
        return hist;
    }

}
