class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if(cost1 + cost2 <= costBoth) {
            return 1L * cost1 * need1 + 1L * cost2 * need2;
        }

        long ans = 0;

        int minNeed = Math.min(need1, need2);
        ans += 1L * minNeed * costBoth;

        int maxNeed = Math.max(need1, need2);
        int cost = 0;
        if(maxNeed == need1) {
            cost = cost1;
        } else {
            cost = cost2;
        }

        if(cost >= costBoth) {
            ans += 1L * costBoth * (maxNeed - minNeed);
        } else {
            ans += 1L * cost * (maxNeed - minNeed);
        }

        return ans;
    }
}