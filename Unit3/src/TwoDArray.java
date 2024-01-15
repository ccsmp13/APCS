import java.util.Arrays;

public class TwoDArray {
    public static void main(String[] args) {

        int[][] a = createRandomArray(3, 10);
        print2DArray(a);
        System.out.println();
        System.out.println(sumColumn(a, 2));
    }

    public static void print2DArray(int[][] arr) {
        for (int r = 0; r < arr.length; r++) { // r is for row
            for (int c = 0; c < arr[r].length; c++) { // c is for column
                System.out.print(arr[r][c] + "   ");

            }
            System.out.println();
        }
    }

    public static void print2D(int[][] arr) {
        for (int[] row : arr) { // take each row from the array
            for (int val : row) { // then take each value from that row
                System.out.print(val + "   ");

            }
            System.out.println();
        }
    }
    public static int[] searchByCol(int[][] arr2d, int target) {
        for (int r = 0; r < arr2d.length; r++) {
            for (int c = 0; c < arr2d.length; c++) {
                if ( arr2d[r][c] == target) {
                    return new int [] {r,c};
                }
            }
        }
        return null;
    }
    /**
     * Creates a 2D int array of size row x column and fills it with random numbers 0 to 99
     * @param row the number of rows
     * @param col the number of columns
     * @return an int[][] array of size row x col filled with random numbers from 0 to 99
     */
    public static int[][] createRandomArray(int row, int col){
        final int RANGE = 100;
        int[][] arr2d = new int[row][col];
        for (int r = 0; r< arr2d.length; r++) {
            for (int c = 0; c < arr2d[r].length; c++) {
                arr2d[r][c] = (int)(Math.random() * RANGE);
            }
        }

        return arr2d;
    }

    public static String[][] createArraySection(String[][] a, int startRow, int startCol, int endRow, int endCol) {
        int difRow = endRow - startRow;
        int difCol = endCol - startCol;
        String[][] section = new String[difRow][difCol];
        int newRow = 0;
        for (int r = startRow; r < endRow; r++) {
            int newCol = 0;
            for (int c = startCol; c < endCol; c++) {
                section[newRow][newCol] = String.format("%10s", a[r][c]);
                newCol++;
            }
            newRow++;
        }
        return section;
    }
    public static int sumColumn(int[][] arr, int col){
       int sum = 0;
        for (int r = 0; r < arr.length; r++) {
            sum += arr[r][col];
                
            }
            return sum;
            
        }
    }

