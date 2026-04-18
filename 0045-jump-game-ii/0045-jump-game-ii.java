class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        return solve(0, nums, dp);
    }

    private int solve(int i, int[] nums, int[] dp) {
        int n = nums.length;

        if(i >= n-1) return 0;

        if(dp[i] != 0) return dp[i];

        int minJump = Integer.MAX_VALUE;

        for(int j = 1; j <= nums[i]; j++) {
            int res = solve(i + j , nums, dp);
            if(res != Integer.MAX_VALUE) {
                minJump = Math.min(minJump, 1 + res);
            }
        }

        return dp[i] = minJump;
    }
}