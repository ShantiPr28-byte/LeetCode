class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] mainDiag = new boolean[2 * n - 1];
        boolean[] antiDiag = new boolean[2 * n - 1];

        helper(0, n, cols, mainDiag, antiDiag, board, result);

        return result;
    }

    private void helper(int col, int n, boolean[] cols, boolean[] mainDiag, boolean[] antiDiag, char[][] board, List<List<String>> result) {
        if(col == n) {
            List<String> temp = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            result.add(temp);
            return;
        }

        for(int row = 0; row < n; row++) {
            int d1 = n - 1 + col - row;
            int d2 = row + col;

            if(cols[row] || mainDiag[d1] || antiDiag[d2]) continue;

            board[row][col] = 'Q';

            cols[row] = true;
            mainDiag[d1] = true;
            antiDiag[d2] = true;

            helper(col + 1, n, cols, mainDiag, antiDiag, board, result);

            board[row][col] = '.';

            cols[row] = false;
            mainDiag[d1] = false;
            antiDiag[d2] = false;
        }
    }
}