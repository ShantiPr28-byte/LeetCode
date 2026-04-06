class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Integer[][][] dp = new Integer[n][m][m];

        return Math.max(0, solve(0, 0, m-1, grid, dp));
    }

    private int solve(int r1, int c1, int c2, int[][] grid, Integer[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;

        if(r1 >= n || c1 >= m || c2 >= m || c1 < 0 || c2 < 0) return Integer.MIN_VALUE;

        int cherry = grid[r1][c1];

        if(c1 != c2) cherry += grid[r1][c2];

        if(r1 == n-1) return cherry;

        if(dp[r1][c1][c2] != null) return dp[r1][c1][c2];

        int best = Integer.MIN_VALUE;
        for(int d1 = -1; d1 <= 1; d1++) {
            for(int d2 = -1; d2 <= 1; d2++) {
                int ans = solve(r1+1, c1 + d1, c2 + d2, grid, dp);
                best = Math.max(best, ans);
            }
        }

        cherry += best;

        return dp[r1][c1][c2] = cherry;
    }
} 