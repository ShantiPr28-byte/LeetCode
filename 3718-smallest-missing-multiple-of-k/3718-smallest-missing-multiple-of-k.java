class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int j = 1;
        
        for(int i = 0; i < nums.length; i++) {
            int ans = j * k;
            if(nums[i] == ans) {
                j++;
            } else if(nums[i] > ans) {
                return ans;
            }
        }
        
        return j * k;
    }
}