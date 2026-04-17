class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount+1];
        int ans = solve(n-1, coins, amount, dp);
        return (ans == (int)1e9) ? -1 : ans;
    }

    private int solve(int i, int[] coins, int amount, Integer[][] dp) {
        if(amount == 0) return 0;
        if(i == 0) {
            if(amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return (int)1e9;
            }
        }

        if(dp[i][amount] != null) return dp[i][amount];

        int take = (int)1e9;
        if(coins[i] <= amount) {
            take = 1 + solve(i, coins, amount - coins[i], dp);
        }
        int nonTake = solve(i-1, coins, amount, dp);

        return dp[i][amount] = Math.min(take, nonTake);
    }
}