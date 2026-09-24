class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(helper(i, j, vis, board, word, 0)) return true;
                }
            }
        }

        return false;
    }

    private boolean helper(int r, int c, boolean[][] vis, char[][] board, String word, int k) {
        int m = board.length;
        int n = board[0].length;

        if(k == word.length()) return true;

        if(r < 0 || c < 0 || r >= m || c >= n || vis[r][c] || board[r][c] != word.charAt(k)) {
            return false;
        }

        vis[r][c] = true;

        for(int i = 0; i < 4; i++) {
            int R = r + dr[i];
            int C = c + dc[i];

            if(helper(R, C, vis, board, word, k + 1)) return true;
        }

        vis[r][c] = false;

        return false;
    }
}