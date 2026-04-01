class Solution {
    // int[] dp;
    public int rob(int[] nums) {
        // dp = new int[nums.length];
        // Arrays.fill(dp, -1);
        // return solve(0, nums);

        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return(Math.max(nums[0], nums[1]));

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int maxAmount = Integer.MIN_VALUE;
        for(int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
            maxAmount = Math.max(maxAmount, dp[i]);
        }

        return maxAmount;
    }

    // private int solve(int i, int[] nums) {
    //     if(i >= nums.length) return 0;

    //     if(dp[i] != -1) return dp[i];

    //     int take = nums[i] + solve(i+2, nums);
    //     int skip = solve(i+1, nums);

    //     return dp[i] = Math.max(take, skip);
    // }
}