class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] dp = new Integer[m][n][maxMove+1];
        return solve(startRow, startColumn, m-1, n-1, maxMove, dp);
    }

    private int solve(int i, int j, int m, int n, int maxMove, Integer[][][] dp) {
        if(i < 0 || j < 0 || i > m || j > n) return 1;

        if(maxMove == 0) return 0;

        if(dp[i][j][maxMove] != null) return dp[i][j][maxMove];

        // long left = solve(i, j-1, m, n, maxMove - 1, dp);
        // long up = solve(i-1, j, m, n, maxMove - 1, dp);
        // long right = solve(i, j+1, m, n, maxMove -1, dp);
        // long down = solve(i+1, j, m, n, maxMove - 1, dp);

        int ans = 0;
        for(int k = 0; k < 4; k++) {
            int R = dr[k];
            int C = dc[k];

            ans = (ans + solve(i + R, j + C, m, n, maxMove - 1, dp)) % 1000000007;
        }

        return dp[i][j][maxMove] = ans;
    }
}