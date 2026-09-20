class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        helper(0, board, result, n);

        return result;
    }

    private void helper(int col, char[][] board, List<List<String>> result, int n) {
        if(col == n) {
            List<String> temp = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            result.add(temp);
            return;
        }

        for(int row = 0; row < n; row++) {
            if(isSafe(row, col, board, n)) {
                board[row][col] = 'Q';

                helper(col + 1, board, result, n);

                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board, int n) {
        int dupRow = row;
        int dupCol = col;

        // upper left
        while(row >= 0 && col >= 0) {
            if(board[row][col] == 'Q') {
                return false;
            }
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        //left
        while(col >= 0) {
            if(board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        row = dupRow;
        col = dupCol;

        //bottom left
        while(row < n && col >= 0) {
            if(board[row][col] == 'Q') {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }
}