class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return solve(0, nums, dp);
    }

    private boolean solve(int idx, int[] nums, Boolean[] dp) {
        if(idx == nums.length - 1) return true;
        if(idx >= nums.length) return false;

        if(dp[idx] != null) return dp[idx];

        for(int i = 1; i <= nums[idx]; i++) {
            if(solve(idx + i, nums, dp)) return dp[idx] = true;
        }

        return dp[idx] = false;
    }
}