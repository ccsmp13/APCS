public class TwoDArrayPrac {
    public static void main(String[] args) {
        int[][] a = new int[10][10];
        int i = 0;
        int z = 0;
        for (int r = 0; r < a.length; r++) {
            if (z % 2 == 0){
                for (int c = 0; c < a.length; c++) {
                    a[c][r] = i;
                    i++;
                }

            } else {
                for (int c = a.length - 1; c >= 0; c--) {
                    a[c][r] = i;
                    i++;
                }
            }
            z++;
        }
        printArr(a);
    }

    public static void printArr(int[][] a){
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a.length; c++) {
                System.out.print(" " + a[r][c] + " ");
            }
            System.out.println();
        }
    }
}
