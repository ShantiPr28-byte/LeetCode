class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        long maxSum = 0;

        long currSum = 0;
        int i = 0;
        for(int j = 0; j < n; j++) {
            currSum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if(j - i + 1 > k) {
                currSum -= nums[i];
                map.put(nums[i], map.get(nums[i]) - 1);

                if(map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }

            if(j - i + 1 == k && map.size() == k) {
                maxSum = Math.max(maxSum, currSum);
            }
        }

        return maxSum;
    }
}