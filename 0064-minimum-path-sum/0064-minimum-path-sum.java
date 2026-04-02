class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        return solve(m-1, n-1, grid);
    }

    private int solve(int i, int j, int[][] grid) {
        //base case 
        if(i == 0 && j == 0) return grid[0][0];

        //base case
        if(i < 0 || j < 0) return Integer.MAX_VALUE;

        int up = solve(i-1, j, grid);
        int left = solve(i, j-1, grid);

        return grid[i][j] + Math.min(up, left);
    }
}