class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        dp[0][0] = 0;
        for(int i = 1; i <= amount; i++) {
            if(i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = (int)1e9;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= amount; j++) {
                if(coins[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j - coins[i]]);
                }
            }
        }

        int ans = dp[n-1][amount];
        return (ans == (int)1e9) ? -1 : ans;
    }
}