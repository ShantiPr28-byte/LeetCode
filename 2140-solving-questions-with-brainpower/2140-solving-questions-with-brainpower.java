class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length + 1];
        Arrays.fill(dp, -1);

        return solve(0, questions, dp);
    }

    private long solve(int idx, int[][] questions, long[] dp) {
        int n = questions.length;
        if(idx >= questions.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        long take = questions[idx][0] + solve(idx + questions[idx][1] + 1, questions, dp);

        long skip = solve(idx + 1, questions, dp);

        return dp[idx] = Math.max(take, skip);
    }
}