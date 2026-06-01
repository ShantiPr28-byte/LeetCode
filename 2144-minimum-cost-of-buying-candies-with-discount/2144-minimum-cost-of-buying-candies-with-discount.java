class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int totalCost = 0;
        int n = cost.length;

        int count = 0;
        for(int i = n - 1; i >= 0; i--) {
            if(count < 2) {
                totalCost += cost[i];
                count++;
            } else {
                count = 0;
            }
        }

        return totalCost;
    }
}