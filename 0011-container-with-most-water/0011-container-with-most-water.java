class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n - 1;
        int maxWater = Integer.MIN_VALUE;

        while(i < j) {
            int min = Math.min(height[i], height[j]);
            maxWater = Math.max(maxWater, min * (j - i));

            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxWater;
    }
}