class Solution {
    public int buyChoco(int[] prices, int money) {
        int choco1 = Integer.MAX_VALUE;
        int choco2 = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < choco1) {
                choco2 = choco1;
                choco1 = prices[i];
            } else if(prices[i] < choco2) {
                choco2 = prices[i];
            }
        }

        int cost = choco1 + choco2;

        return cost <= money ? money - cost : money;
    }
}