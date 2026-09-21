class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {

                if(board[i][j] == '.') {

                    for(char c = '1'; c <= '9'; c++) {
                        if(isSafe(i, j, c, board)) {
                            board[i][j] = c;

                            if(solve(board)) return true;
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSafe(int r, int c, char ch, char[][] board) {
        for(int i = 0; i < 9; i++) {
            // row
            if(board[r][i] == ch) return false;

            //col
            if(board[i][c] == ch) return false;

            // 3 * 3 matrix
            if(board[3 * (r / 3) + i / 3][3 * (c / 3) + i % 3] == ch) return false;
        }

        return true;
    }
}