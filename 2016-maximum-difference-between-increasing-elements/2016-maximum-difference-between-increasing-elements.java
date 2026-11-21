class Solution {
    public int maximumDifference(int[] nums) {
        int ans = 0;
        int min = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else {
                ans = Math.max(ans, nums[i] - min);
            }
        }

        return ans == 0 ? -1 : ans;
    }
}