class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, 0, grid, dp);
    }

    private int helper(int i, int j, int[][] grid, int[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        if(i >= m || j >= n) return Integer.MAX_VALUE;;
        if(i == m - 1 && j == n - 1) return grid[m - 1][n - 1];

        if(dp[i][j] != -1) return dp[i][j];

        int down = helper(i + 1, j, grid, dp);
        int right = helper(i, j + 1, grid, dp);

        return dp[i][j] = Math.min(down, right) + grid[i][j];
    }
}