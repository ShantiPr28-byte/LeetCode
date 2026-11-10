class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return helper(0, n, costs, dp);
    }

    private int helper(int idx, int n, int[] costs, int[] dp) {
        if(idx == n) {
            return 0;
        }

        if(dp[idx] != -1) {
            return dp[idx];
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 1; i <= 3; i++) {
            int j = idx + i;

            if(j <= n) {
                int cost = costs[j-1] + i * i + helper(j, n, costs, dp);
                ans = Math.min(ans, cost);
            }
        }

        return dp[idx] = ans;
    }
}