class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffix = new int[n+1];

        for(int i = n-1; i >= 0; i--) {
            suffix[i] = suffix[i+1] + piles[i];
        }

        int[][] dp = new int[n][n+1];

        return solve(0, 1, piles, suffix, dp);
    }

    private int solve(int i, int m, int[] piles, int[] suffix, int[][] dp) {
        int n = piles.length;

        if(i + 2 * m >= n) {
            return suffix[i];
        }

        if(dp[i][m] != 0) return dp[i][m];

        int best = 0;

        for(int x = 1; x <= 2 * m; x++) {
            int newM = Math.max(x, m);

            int opponent = solve(i + x, newM, piles, suffix, dp);

            int currentPlayer = suffix[i] - opponent;

            best = Math.max(best, currentPlayer);
        }

        dp[i][m] = best;

        return best;
    }
}