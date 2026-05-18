class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return solve(0, 0, s1, s2, s3, dp);
    }

    private boolean solve(int i, int j, String s1, String s2, String s3, Boolean[][] dp) {
        if(i + j == s3.length()) {
            if(i == s1.length() && j == s2.length()) {
                return true;
            }
            return false;
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        boolean ans = false;

        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j) && j < s2.length() && s2.charAt(j) == s3.charAt(i+j)) {
            return dp[i][j] = solve(i+1, j, s1, s2, s3, dp) || solve(i, j+1, s1, s2, s3, dp);
        }

        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j) ) {
            return dp[i][j] = ans || solve(i+1, j, s1, s2, s3, dp);
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j)) {
            return dp[i][j] = ans || solve(i, j+1, s1, s2, s3, dp);
        }

        return ans;
    }
}