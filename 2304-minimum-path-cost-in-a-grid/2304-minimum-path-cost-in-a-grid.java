class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }

        int minCost = Integer.MAX_VALUE;
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                //try all columns from previous row
                for(int k = 0; k < n; k++) {
                    int cost = dp[i-1][k] + moveCost[grid[i-1][k]][j] + grid[i][j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        //find minimum in last row
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[m-1][j]);
        }

        return ans;
    }
}