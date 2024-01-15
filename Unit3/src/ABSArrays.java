import java.util.Arrays;

public class ABSArrays {
    public static void main(String[] args) {
        int[] a = { 1, -4, -6, 4, 13, 56, -34, -93845, 43, -2345 };
        int[] b = functionalABSArray(a);
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(a));
        modifierABSArray(a);
        System.out.println(Arrays.toString(a));
    }

    public static void modifierABSArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.abs(a[i]);
        }
    }

    public static int[] functionalABSArray(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = Math.abs(a[i]);
        }
        return b;
    }

}
