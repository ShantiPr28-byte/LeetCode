class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        Integer[][][] dp = new Integer[m][n+1][target+1];

        int ans = solve(0, 0, 0, houses, cost, m, n, target, dp);

        if(ans == Integer.MAX_VALUE / 2) {
            return -1;
        }
        return ans;
    }

    private int solve(int i, int prevColor, int neighbour, int[] houses, int[][] cost, int m, int n, int target, Integer[][][] dp) {
        if(i == m) {
            if(target == neighbour) {
                return 0;
            } else {
                return Integer.MAX_VALUE / 2;
            }
        }

        if(neighbour > target) {
            return Integer.MAX_VALUE / 2;
        }

        if(dp[i][prevColor][neighbour] != null) {
            return dp[i][prevColor][neighbour];
        }

        int ans = Integer.MAX_VALUE / 2;
        if(houses[i] != 0) {
            //we do not have to color that house
            int color = houses[i];
            int newNeighbour = neighbour + (color != prevColor ? 1 : 0);
            ans = solve(i+1, color, newNeighbour, houses, cost, m, n, target, dp);
        } else {
            //we have to color that house with all colors
            for(int color = 1; color <= n; color++) {
                int newNeighbour = neighbour + (color != prevColor ? 1 : 0);
                ans = Math.min(ans, cost[i][color-1] + solve(i+1, color, newNeighbour, houses, cost, m, n, target, dp));

            }

        }

        return dp[i][prevColor][neighbour] = ans;
    }
}