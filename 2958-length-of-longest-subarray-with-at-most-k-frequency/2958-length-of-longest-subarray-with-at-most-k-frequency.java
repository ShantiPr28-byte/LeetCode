class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        
        int maxLen = 0;
        int len = 0;
        int j = 0;
        for(int i = 0; i < n; i++) {
            if(map.containsKey(nums[i])) {
                if(map.get(nums[i]) < k) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                    len++;
                } else {
                    while(j < i) {
                        if(nums[j] == nums[i]) {
                            len = i - j;
                            j = j + 1;
                            break;
                        }
                        map.put(nums[j], map.get(nums[j]) - 1);
                        j++;
                    }
                }
            } else {
                map.put(nums[i], 1);
                len++;
            }

            maxLen = Math.max(len, maxLen);
        }

        return maxLen;
    }
}