class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        //Initialize with large value
        for(int i = 0; i <= amount; i++) {
            dp[i] = (int)1e9;
        }

        //Base case
        dp[0] = 0;

        for(int coin : coins) {
            for(int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - coin]);
            }
        }

        return (dp[amount] == (int)1e9) ? -1 : dp[amount]; 
    }
}