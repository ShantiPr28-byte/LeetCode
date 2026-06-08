class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for(int num : nums) {
            if(num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        int[] result = new int[n];
        int i = 0, j = 0;
        for(int k = 0; k < n; k++) {
            if(k % 2 == 0) {
                result[k] = positive.get(i++);
            } else {
                result[k] = negative.get(j++);
            }
        }

        return result;
    }
}