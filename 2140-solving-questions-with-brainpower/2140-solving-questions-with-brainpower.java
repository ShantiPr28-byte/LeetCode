class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n+1];

        for(int i = n - 1; i >= 0; i--) {
            int next = i + questions[i][1] + 1;

            long take = questions[i][0];

            if(next < n) {
                take += dp[next];
            }

            long skip = dp[i+1];

            dp[i] = Math.max(take, skip);
        }

        return dp[0];
    }
}