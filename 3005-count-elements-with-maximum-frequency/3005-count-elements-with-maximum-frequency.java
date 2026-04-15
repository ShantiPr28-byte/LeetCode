class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[100];

        int maxFreq = 0, result = 0;
        for(int num : nums) {
            freq[num]++;
            maxFreq = Math.max(maxFreq, freq[num]);
        }

        for(int f : freq) {
            if(f == maxFreq) {
                result += f;
            }
        }

        return result;
    }
}