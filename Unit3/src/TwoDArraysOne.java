public class TwoDArraysOne {
    public static void main(String[] args) {
        String[][] b = displayString(3, 4);
        print2DString(b);

        String[][] a = createArray(4, 6);
        print2DString(a);
        System.out.println();
        a = strictString(a, 0, 0, 3, 2);
        print2DString(a);

    }

    public static String[][] displayString(int row, int col) {
        String[][] arr = new String[row][col];
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                arr[r][c] = String.format("Row %d, Column %d     ", r, c);
            }
        }
        return arr;
    }

    public static void print2DString(String[][] arr) {
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                System.out.print(arr[r][c]);
            }
            System.out.println();
        }
    }

    public static String[][] strictString(String[][] a, int startRow, int startCol, int endRow, int endCol) {
        int difRow = endRow - startRow;
        int difCol = endCol - startCol;
        String[][] output = new String[difRow][difCol];
        int k = 0;
        int n = 0;
        for (int r = startRow; r < endRow; r++) {
            for (int c = startCol; c < endCol; c++) {
                output[k][n] = String.format("%10s", a[r][c]);
                n++;
            }
            n = 0;
            k++;
        }
        return output;
    }

    public static String[][] createArray(int row, int col) {
        String[][] arr2d = new String[row][col];
        for (int r = 0; r < arr2d.length; r++) {
            for (int c = 0; c < arr2d[r].length; c++) {
                arr2d[r][c] = Integer.toString((r + 1) * (c + 3)) + "    ";
            }
        }

        return arr2d;
    }
}
