class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        int minCost = Integer.MIN_VALUE;

        if(n == 2) {
            return stones[1] - stones[0]; 
        }
        for(int i = 2; i < n; i = i + 2) {
            minCost = Math.max(minCost, stones[i] - stones[i-2]);
        }

        for(int i = 3; i < n; i = i + 2) {
            minCost = Math.max(minCost, stones[i] - stones[i-2]);
        }

        return minCost;
    }
}