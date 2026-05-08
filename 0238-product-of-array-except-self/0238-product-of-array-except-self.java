class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        prefix[1] = nums[0];
        for(int i = 2; i < n; i++) {
            prefix[i] = nums[i-1] * prefix[i-1];
        }

        suffix[n-1] = 1;
        suffix[n-2] = nums[n-1];
        for(int i = n - 3; i >= 0; i--) {
            suffix[i] = nums[i+1] * suffix[i+1];
        }

        int[] result = new int[n];
        for(int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}