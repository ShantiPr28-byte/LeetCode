class Solution {
    public int maxProduct(int[] nums) {
        int max = Math.max(nums[0], nums[1]);
        int secondMax = Math.min(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++) {
            if(nums[i] > max) {
                secondMax = max;
                max = nums[i];
            } else if(nums[i] > secondMax || nums[i] == max) {
                secondMax = nums[i];
            }
        }

        return (max - 1) * (secondMax - 1);
    }
}