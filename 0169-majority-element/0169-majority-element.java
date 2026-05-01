class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, candidate = nums[0];

        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(count == 0) {
                candidate = nums[j];
                i = j-1;
            }
            if(nums[i] == nums[j]) {
                count++;
                i++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}