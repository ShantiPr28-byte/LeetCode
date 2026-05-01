class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0, count = 1;

        for(int j = 1; j < nums.length; j++) {
            if(nums[i] == nums[j]) {
                count++;
                if(count > 2) continue;
                i++;
                nums[i] = nums[j];
            } else {
                count = 1;
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}