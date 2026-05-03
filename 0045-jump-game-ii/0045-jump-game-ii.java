class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(0, nums, dp);
    }

    private int solve(int idx, int[] nums, int[] dp) {
        if(idx >= nums.length - 1) return 0;

        if(dp[idx] != -1) return dp[idx];

        int minJump = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[idx]; i++) {
            int jump = solve(idx + i, nums, dp);
            if(jump != Integer.MAX_VALUE) {
                jump = 1 + jump;
            }
            minJump = Math.min(minJump, jump);
        }

        return dp[idx] = minJump;
    }
}