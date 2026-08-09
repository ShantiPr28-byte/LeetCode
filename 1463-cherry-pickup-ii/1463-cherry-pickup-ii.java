class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Integer[][][] dp = new Integer[n][m][m];

        return solve(0, 0, m - 1, grid, dp);
    }

    private int solve(int r, int c1, int c2, int[][] grid, Integer[][][]dp) {
        int n = grid.length;
        int m = grid[0].length;

        if(r >= n || c1 >= m || c2 >= m || c1 < 0 || c2 < 0) return 0;

        if(r == n-1) {
            if(c1 == c2) {
                return grid[r][c1];
            } else {
                return grid[r][c1] + grid[r][c2];
            }
        }

        if(dp[r][c1][c2] != null) return dp[r][c1][c2];

        int max = 0;
        for(int i = -1; i < 2; i++) {
            for(int j = -1; j < 2; j++) {
                if(c1 == c2) {
                    max = Math.max(max, grid[r][c1] + solve(r + 1, c1 + i, c2 + j, grid, dp));
                } else {
                    max = Math.max(max, grid[r][c1] + grid[r][c2] + solve(r + 1, c1 + i, c2 + j, grid, dp));
                }
                
            }
        }

        return dp[r][c1][c2] = max;
    }
}