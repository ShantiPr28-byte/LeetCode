class Solution {
    public int minDays(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {

            for(int k = 1; k * (k + 1) / 2 <= i; k++) {
                int points = k * (k + 1) / 2;

                if(dp[i - points] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], k + 1 + dp[i - points]);
                }
            }
        }

        return dp[n] - 1;
    }
}