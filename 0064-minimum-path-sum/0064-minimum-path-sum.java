class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Integer[][] dp = new Integer[m][n];

        return solve(m-1, n-1, grid, dp);
    }

    private int solve(int i, int j, int[][] grid, Integer[][] dp) {
        //base case 
        if(i == 0 && j == 0) return grid[0][0];

        //base case
        if(i < 0 || j < 0) return Integer.MAX_VALUE;

        if(dp[i][j] != null) return dp[i][j];

        int up = solve(i-1, j, grid, dp);
        int left = solve(i, j-1, grid, dp);

        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }
}