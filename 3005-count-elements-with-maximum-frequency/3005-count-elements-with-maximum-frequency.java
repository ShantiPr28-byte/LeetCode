class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0, result = 0;

        for(int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);

            if(count > maxFreq) {
                maxFreq = count;
                result = count;
            } else if(count == maxFreq) {
                result += count;
            }
        }

        return result;
    }
}