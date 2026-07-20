class Solution {
    public boolean increasingTriplet(int[] nums) {
        // n^3, n^2(lis), nlogn(lis with binary search), n
        int n = nums.length;

        if(n < 3) return false;

        int[] minPrefix = new int[n];
        minPrefix[0] = nums[0];
        int[] maxSuffix = new int[n];
        maxSuffix[n-1] = nums[n-1];

        for(int i = 1; i < n; i++) {
            minPrefix[i] = Math.min(minPrefix[i-1], nums[i]);
        }

        for(int i = n-2; i >= 0; i--) {
            maxSuffix[i] = Math.max(maxSuffix[i+1], nums[i]);
        }

        for(int i = 1; i < n-1; i++) {
            if(minPrefix[i] < nums[i] && nums[i] < maxSuffix[i]) {
                return true;
            }
        }

        return false;
    }
}