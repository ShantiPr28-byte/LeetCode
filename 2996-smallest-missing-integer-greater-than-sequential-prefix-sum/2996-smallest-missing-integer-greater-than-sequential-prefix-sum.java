class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0] + 1;

        int sum = nums[0];

        for(int j = 1; j < n; j++) {
            if(nums[j] == nums[j-1] + 1) {
                sum += nums[j];
            } else {
                break;
            }
        }

        Arrays.sort(nums);

        for(int num : nums) {
            if(num == sum) {
                sum++;
            }
        }

        return sum;
    }
}