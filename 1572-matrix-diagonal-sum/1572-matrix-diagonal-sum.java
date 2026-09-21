class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(i == n - 1 - i) {
                ans += mat[i][i];
            } else {
                ans += mat[i][i];
                ans += mat[i][n - 1 - i];
            }
        }

        return ans;
    }
}