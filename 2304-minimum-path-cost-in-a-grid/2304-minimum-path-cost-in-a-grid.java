class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;

        Integer[][] dp = new Integer[m][n];

        int minCost = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            int cost = solve(0, j, grid, moveCost, dp);
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    private int solve(int i, int j, int[][] grid, int[][] moveCost, Integer[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if(i == m-1) return grid[i][j];

        if(dp[i][j] != null) return dp[i][j];

        int minCost = Integer.MAX_VALUE;
        for(int k = 0; k < n; k++) {
            int cost = grid[i][j] + moveCost[grid[i][j]][k] + solve(i+1, k, grid, moveCost, dp);
            minCost = Math.min(minCost, cost);
        }

        return dp[i][j] = minCost;
    }
}