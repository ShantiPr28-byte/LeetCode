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

        while(true) {
            boolean found = false;

            for(int num : nums) {
                if(num == sum) {
                    found = true;
                    break;
                }
            }

            if(!found) {
                return sum;
            }

            sum++;
        }
    }
}