public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = { { 'X', 'O', 'O' },
                           { 'O', ' ', 'X' },
                           { 'X', ' ', 'X' } };
        if (isValid(board)){
        System.out.println(checkWin(board));
        } else{
            System.out.println("Board not valid!");
        }
    }
    public static char checkRes(char[] res){
        if (res[0] == 'X' && res[1] == 'X' && res[2] == 'X'){
                return 'X';
            }
            if (res[0] == 'O' && res[1] == 'O' && res[2] == 'O'){
                return 'O';
            }
            return ' ';
    }

    public static boolean isValid(char[][] arr) {
        int difference = 0;
        for (char[] row : arr) {
            for (char thisChar : row) {
                if (thisChar == 'X') {
                    difference++;
                } else if (thisChar == 'O') {
                    difference--;
                } else if (thisChar != ' ' ){
                    return false;
                }
            }
        }
        return Math.abs(difference) <= 1;
    }
    public static char checkWin(char[][] arr){
        final int BOARD_DIM = 3;
        char[] res = new char[BOARD_DIM];
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr.length; c++) {
                res[c] = arr[r][c];
            }
            if (checkRes(res) != ' '){
                return checkRes(res);
            }
        }
        for (int c = 0; c < arr.length; c++) {
            for (int r = 0; r < arr.length; r++) {
                res[r] = arr[r][c];
            }
           if (checkRes(res) != ' '){
                return checkRes(res);
            }
        }
        for (int r = 0; r < res.length; r++) {
            int c = r;
            res[c] = arr[r][c];
        }
        if (checkRes(res) != ' '){
                return checkRes(res);
            }
            int c = 2;
            for (int r = 0; r < res.length; r++) {
                
                    res[r] = arr[r][c];
                c--;
            }
           if (checkRes(res) != ' '){
                return checkRes(res);
            }
        return ' ';
    }
}
