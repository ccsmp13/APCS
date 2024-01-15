import java.util.Arrays;

public class ArrayMethods {

    public static void main(String[] args) {
        int[] a = { 48, 72, 98, 95, 83, 48, 39, 91, 91, 94 };
        int[] gradeHist = makeHistogram(a);
        System.out.println(Arrays.toString(gradeHist));

    }
    public static double[] downSample(double[] arr){
        double[] result = new double[arr.length / 2];
        for (int i = 0; i < arr.length - 1; i+=2) {
            result[i/2] = (arr[i] + arr[i + 1]) / 2;
            
        }
        return result;
    }
    /**
     * 
     * @param arr
     * @return
     */
    public static boolean isInOrder(int[] arr){
        
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;
    }

    public static int findIndexFromEnd(int[] arr,int target){
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }
    public static int[] makeHistogram(int[] data){
        final int NUM_BINS = 10;
        int[] hist = new int[NUM_BINS];
        for (int i = 0; i < data.length; i++) {
            //calc which bin to put data[i] into
            int bin = data[i] / 10;
            // increase the count in that bin by 1
            hist[bin]++;
        }
        return hist;
    }

    /**
     * Returns the first occurance of a target item in an array
     * or -1 if the target is not in the array
     * 
     * @param arr    the array to be searched
     * @param target the value to search for
     * @return an in with the index of the first occurance of the target or -1 if
     *         not found
     */
    public static int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // finds the last occurance in a not very efficent way
    public static int lastIndexOf(int[] arr, int target) {
        int loc = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                loc = i;
            }
        }
        return loc;
    }

    public static void printArray(int[] a) {
        // for:each loop is a nice shortcut
        // if you dont need to modify or see index
        // of the array
        for (int val : a) {
            System.out.println(val);
        }

    }

    public static int findMax(int[] a) {
        int remember = a[0];
        // for (int i = 0; i < a.length; i++) {
        for (int val : a) {
            if (val > remember) {
                remember = val;
            }

        }
        return remember;
    }

    public static int indexOfMax(int[] a) {
        int bigVal = a[0];
        int locOfMax = 0;
        for (int i = 0; i < a.length; i++) {
            if (bigVal < a[i]) {
                bigVal = a[i];
                locOfMax = i;
            }
        }
        return locOfMax;

    }
}