class Solution {
    public int minOperations(int[] nums, int sum) {
        Integer[][] dp = new Integer[nums.length + 1][sum + 1];

        int min = helper(0, sum, nums, dp);

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

    private int helper(int idx, int target, int[] nums, Integer[][] dp) {
        if(target == 0) {
            return 0;
        }

        if(target < 0 || idx == nums.length) return Integer.MAX_VALUE;

        if(dp[idx][target] != null) {
            return dp[idx][target];
        }

        // skip
        int ans = helper(idx + 1, target, nums, dp);

        //take
        int value = nums[idx];
        int operations = 0;

        //Division
        while(value > 0) {

            if(value <= target) {
                int next = helper(idx + 1, target - value, nums, dp);

                if(next != Integer.MAX_VALUE) {
                    ans = Math.min(ans, next + operations);
                }
            }

            value /= 2;
            operations++;
        }
        
        //Multiplication
        value = nums[idx];
        operations = 0;

        while(value <= target) {
            
            if(value > 0) {
                int next = helper(idx + 1, target - value, nums, dp);

                if(next != Integer.MAX_VALUE) {
                    ans = Math.min(ans, next + operations);
                }
            }

            if(value > target / 2) break;

            value *= 2;
            operations++;
        }

        return dp[idx][target] = ans;
    }
}