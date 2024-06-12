public class MagicSquare {
    public static void main(String[] args) {
        int[][] a = buildMagicSquare(15);
        printMagicSquare(a);
        sumMagicSquare(a);
        
    }

    public static int[][] buildMagicSquare(int dim) {
        int[][] sqr = new int[dim][dim];
        int k = 1;
        int r = 0;
        int c = dim / 2;
        while (k <= dim * dim) {
            if (sqr[r][c] == 0) {
                sqr[r][c] = k;
            } else {
                r += 2;
                c--;
                if (r > dim - 1){
                    r -= dim;
                }
                if (c < 0){
                    c += dim;
                }
                
                
                sqr[r][c] = k;
            }
            k++;
            if (r == 0) {
                r = dim - 1;
            } else {
                r--;
            }
            if (c == dim - 1) {
                c = 0;
            } else{
                c++;
            }
        }
        return sqr;
    }

    public static void printMagicSquare(int[][] sqr) {
        for (int r = 0; r < sqr.length; r++) {
            for (int c = 0; c < sqr[r].length; c++) {
                System.out.printf("%4d", sqr[r][c]);
            }
            System.out.println();
        }
    }

    public static void sumMagicSquare(int[][] sqr) {
        final int SHIFT = 1;
        int sum = 0;
        // row
        for (int r = 0; r < sqr.length; r++) {
            sum = 0;
            for (int c = 0; c < sqr.length; c++) {
                sum += sqr[r][c];
            }
            System.out.printf("Row %d: %d\n", r, sum);
        }
        // column
        for (int c = 0; c < sqr.length; c++) {
            sum = 0;
            for (int r = 0; r < sqr.length; r++) {
                sum += sqr[r][c];
            }
            System.out.printf("Column %d: %d\n", c, sum);
        }
        // diag1
        sum = 0;
        for (int i = 0; i < sqr.length; i++) {
            sum += sqr[i][i];

        }
        System.out.printf("Diagnol 1: %d\n", sum);
        // diag2
        sum = 0;
        int c = sqr.length - SHIFT;
        for (int r = 0; r < sqr.length; r++) {

            sum += sqr[r][c];
            c--;

        }
        System.out.printf("Diagnol 2: %d\n", sum);
    }
}
