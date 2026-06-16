class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        Integer[][] dp = new Integer[len1][len2];

        return solve(len1 - 1, len2 - 1, word1, word2, dp);
    }

    private int solve(int n1, int n2, String word1, String word2, Integer[][] dp) {
        if(n1 < 0) {
            return n2 + 1;
        }
        if(n2 < 0) {
            return n1 + 1;
        }

        if(dp[n1][n2] != null) {
            return dp[n1][n2];
        }

        int insert = 0, delete = 0, replace = 0;
        if(word1.charAt(n1) == word2.charAt(n2)) {
            return dp[n1][n2] = solve(n1 - 1, n2 - 1, word1, word2, dp);
        } else {
            insert = 1 + solve(n1, n2 - 1, word1, word2, dp);
            delete = 1 + solve(n1 - 1, n2, word1, word2, dp);
            replace = 1 + solve(n1 - 1, n2 - 1, word1, word2, dp);
        }

        return dp[n1][n2] = Math.min(Math.min(insert, delete), replace);
    } 
}