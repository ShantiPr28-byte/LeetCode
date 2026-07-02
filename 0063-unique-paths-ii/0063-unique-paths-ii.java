class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;

        int[][] dp = new int[m][n];
        for(int[] curr : dp) {
            Arrays.fill(curr, -1);
        }

        return solve(m-1, n-1, obstacleGrid, dp);
    }

    private int solve(int i, int j, int[][] obstacleGrid, int[][] dp) {
        if(i == 0 && j == 0) return 1;

        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(obstacleGrid[i][j] == 1) return 0;

        return dp[i][j] = solve(i-1, j, obstacleGrid, dp) + solve(i, j-1, obstacleGrid, dp);
    }
}