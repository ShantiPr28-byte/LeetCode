class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCost(0, cost), minCost(1, cost));
    }

    private int minCost(int i, int[] cost) {
        if(i >= cost.length) return 0;
        return cost[i] + Math.min(minCost(i+1, cost), minCost(i+2, cost));
    }
}