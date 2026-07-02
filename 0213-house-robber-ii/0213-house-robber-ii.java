class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 1) return Math.max(nums[0], nums[1]);

        int case1 = solve(0, n-2, nums);
        int case2 = solve(1, n-1, nums);

        return Math.max(case1, case2);
    }

    private int solve(int start, int end, int[] nums) {
        int[] dp = new int[end + 2];

        dp[end + 1] = 0;
        dp[end] = nums[end];

        for(int i = end - 1; i >= start; i--) {
            dp[i] = Math.max(dp[i+1], nums[i] + dp[i+2]);
        }

        return dp[start];
    }
}