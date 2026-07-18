class Solution {
    public int arrayPairSum(int[] nums) {
        int[] freq = new int[20001];
        
        for(int i = 0; i < nums.length; i++) {
            freq[nums[i] + 10000]++;
        }

        int ans = 0;
        boolean take = true;

        for(int i = 0; i < freq.length; i++) {
            while(freq[i] > 0) {
                if(take) {
                    ans += i - 10000;
                }
                take = !take;
                freq[i]--;
            }
        }

        return ans;
    }
}