class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);

        dp = new int[n];
        Arrays.fill(dp, -1);
        int case1 = solve(0, n-2, nums);

        dp = new int[n];
        Arrays.fill(dp, -1);
        int case2 = solve(1, n-1, nums);

        return Math.max(case1, case2);
    }

    private int solve(int i, int lastIdx, int[]nums) {
        if(i > lastIdx) return 0;

        if(dp[i] != -1) return dp[i];

        int take = nums[i] + solve(i+2, lastIdx, nums);
        int skip = solve(i+1, lastIdx, nums);

        return dp[i] = Math.max(take, skip);
    }
}