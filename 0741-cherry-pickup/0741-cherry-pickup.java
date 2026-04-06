class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][][][] dp = new Integer[n][n][n][n];
        return Math.max(0,solve(0, 0, 0, 0, grid, dp));
    }

    private int solve(int r1, int c1, int r2, int c2, int[][] grid, Integer[][][][] dp) {
        int n = grid.length;
        if(r1 >= n || c1 >= n || r2 >= n || c2 >= n) return Integer.MIN_VALUE;

        if(grid[r1][c1] == -1 || grid[r2][c2] == -1) return Integer.MIN_VALUE;

        int cherry = grid[r1][c1];
        if(r1 != r2 || c1 != c2) cherry+= grid[r2][c2];

        if(r1 == n-1 && c1 == n-1) return grid[r1][c1];

        if(dp[r1][c1][r2][c2] != null) return dp[r1][c1][r2][c2];

        int right = solve(r1, c1+1, r2, c2+1, grid, dp);
        int down = solve(r1+1, c1, r2+1, c2, grid, dp);
        int dr = solve(r1, c1+1, r2+1, c2, grid, dp);
        int rd = solve(r1+1, c1, r2, c2+1, grid, dp);

        int best=Math.max(Math.max(down, right), Math.max(dr, rd));
        cherry+=best;
        return dp[r1][c1][r2][c2] = cherry;
    }
}