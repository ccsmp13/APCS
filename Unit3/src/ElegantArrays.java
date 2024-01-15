public class ElegantArrays {
    public static int majority(boolean[] results) {
        int sum = 0;
        for (boolean vote : results) {
            if (vote) {
                sum++;
            } else {
                sum--;
            }
        }
        return sum;
    }

    public static double[] findMinMidMax(double[] data) {

        double[] results = new double[3];

        double minAcumulator = Double.MAX_VALUE;
        double meanSum = 0;
        double maxAcumulator = -Double.MAX_VALUE;
        for (double res : data) {
            if (res < minAcumulator) {
                minAcumulator = res;
                meanSum += res;
                if (res > maxAcumulator) {
                    maxAcumulator = res;
                }
            }
        }
        results[0] = minAcumulator;
        results[1] = meanSum / data.length;
        results[2] = maxAcumulator;

        return results;
    }

    public static int findMode(int[] data) {
        final int NUM_BINS = 10;

        int[] hist = new int[NUM_BINS];
        for (int val : data) {
            int bin = val;
            hist[bin]++;
        }
        int indexAcumulator = 0;
        for (int i = 0; i < hist.length; i++) {
            if (hist[i] > hist[indexAcumulator]) {
                indexAcumulator = i;
            }
        }

        return indexAcumulator;
    }
}
