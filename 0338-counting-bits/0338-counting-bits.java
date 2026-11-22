class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i = 0; i <= n; i++) {

            // int count = Integer.bitCount(i);
            int count = 0;
            int j = i;
            while(j > 0) {
                j = j & (j - 1);
                count++;
            }

            ans[i] = count;
        }

        return ans;
    }
}