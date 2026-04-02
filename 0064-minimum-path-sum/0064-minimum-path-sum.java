class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Integer[][] dp = new Integer[m][n];

        // return solve(m-1, n-1, grid, dp);

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for(int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }

    // private int solve(int i, int j, int[][] grid, Integer[][] dp) {
    //     //base case 
    //     if(i == 0 && j == 0) return grid[0][0];

    //     //base case
    //     if(i < 0 || j < 0) return Integer.MAX_VALUE;

    //     if(dp[i][j] != null) return dp[i][j];

    //     int up = solve(i-1, j, grid, dp);
    //     int left = solve(i, j-1, grid, dp);

    //     return dp[i][j] = grid[i][j] + Math.min(up, left);
    // }
}