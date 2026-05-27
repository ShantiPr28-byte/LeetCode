class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int j = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];

            while(sum >= target) {
                minLen = Math.min(minLen, i - j + 1);

                sum -= nums[j];
                j++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}