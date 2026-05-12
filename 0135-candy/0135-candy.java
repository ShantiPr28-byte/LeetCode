class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        //corner case
        if(n == 1) return 1;

        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        //forward loop
        for(int i = 0; i < n - 1; i++) {
            if(ratings[i] < ratings[i+1]) {
                candies[i+1] = candies[i] + 1;
            }
        }
        //backward loop
        for(int i = n-1; i > 0; i--) {
            if(ratings[i] < ratings[i-1] && candies[i-1] <= candies[i]) {
                candies[i-1] = candies[i] + 1;
            }
        }

        int totalCandy = 0;
        for(int candy : candies) {
            totalCandy += candy;
        }

        return totalCandy;
    }
}