class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] nums) {
        int n = nums.length;
        if(n == 1) return 1;

        Arrays.sort(nums);
        if(nums[0] != 1) nums[0] = 1;

        for(int i = 1; i < n; i++) {
            if(nums[i] - nums[i-1] > 1) {
                nums[i] = nums[i-1] + 1;
            }
        }

        return nums[n-1];
    }
}