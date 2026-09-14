class Solution {
    public int minDays(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {
        if(n == 0) return -1;

        if(dp[n] != -1) return dp[n];

        int ans = Integer.MAX_VALUE;

        for(int k = 1; k * (k + 1) / 2 <= n; k++) {
            int points = k * (k + 1) / 2;

            int days = k + 1 + solve(n - points, dp);

            ans = Math.min(ans, days);
        }

        return dp[n] = ans;
    }
}