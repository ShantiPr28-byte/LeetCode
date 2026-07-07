class Solution {
    public int numOfPairs(String[] nums, String target) {
        int n = nums.length;
        int ans = 0;

        HashMap<String, Integer> freqMap = new HashMap<>();
        for(String s : nums) {
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }

        for(String s : nums) {
            if(target.startsWith(s)) {
                String suffix = target.substring(s.length());

                ans += freqMap.getOrDefault(suffix, 0);

                if(s.equals(suffix)) {
                    ans--;
                }
            }
        }

        return ans;
    }
}