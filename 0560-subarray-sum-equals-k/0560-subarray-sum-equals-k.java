class Solution {
    public int subarraySum(int[] nums, int k) {
        int n =nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int currSum = 0;
        for(int i = 0; i < n; i++) {
            currSum += nums[i];
            count += map.getOrDefault(currSum - k, 0);

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}