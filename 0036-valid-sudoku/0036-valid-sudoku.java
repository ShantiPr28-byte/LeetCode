class Solution {
    public boolean isValidSudoku(char[][] board) {
        return solve(board);
    }

    private boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {

                if(board[i][j] != '.') {
                    char ch = board[i][j];

                    if(!isSafe(i, j, ch, board)) return false;
                }
            }
        }

        return true;
    }

    private boolean isSafe(int r, int c, char ch, char[][] board) {
        for(int i = 0; i < 9; i++) {

            //row
            if(i != c && board[r][i] == ch) return false;

            //col
            if(i != r && board[i][c] == ch) return false;

            // matrix
            int row = 3 * (r / 3) + i / 3;
            int col = 3 * (c / 3) + i % 3;

            if((row != r && col != c) && board[row][col] == ch) {
                return false;
            }
        }

        return true;
    }
}